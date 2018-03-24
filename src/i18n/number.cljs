; Everything here is based on the Google Closure lib:
; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformat.js
; Reading the code is far more useful than the official API docs unfortunately.
; Reasons for this wrapper:
; - Multiple locale support.
; - Caching the creation of NumberFormat objects.
; - Converting the super Java flavour OO code into something more functional.
(ns i18n.number
 (:require
  goog.i18n.NumberFormat
  goog.i18n.NumberFormat.Format
  goog.i18n.NumberFormatSymbols
  i18n.goog
  [cljs.test :refer-macros [deftest is are]]
  taoensso.timbre
  i18n.locale
  i18n.data))

; When passed nil instead of a number, what string to return?
(def default-nil-string "")
; When passed NaN instead of a number, what string to return?
(def default-nan-string "NaN")

; PRIVATE API. DO NOT CALL THIS EXTERNALLY. IT IS FAR TOO EASY TO SCREW THIS UP.

(defn nan?
 [n]
 ; http://adripofjavascript.com/blog/drips/the-problem-with-testing-for-nan-in-javascript.html
 (if (number? n)
  (not (== n n))
  false))

(def formats
 {:decimal (.-DECIMAL goog.i18n.NumberFormat.Format)
  :scientific (.-SCIENTIFIC goog.i18n.NumberFormat.Format)
  :percent (.-PERCENT goog.i18n.NumberFormat.Format)
  :currency (.-CURRENCY goog.i18n.NumberFormat.Format)
  :compact-short (.-COMPACT_SHORT goog.i18n.NumberFormat.Format)
  :compact-long (.-COMPACT_LONG goog.i18n.NumberFormat.Format)})
(def default-pattern :decimal)

(def locale->symbols
 (i18n.goog/locale->symbols-fn :number-format-symbols))

(def locale->latin-symbols
 (i18n.goog/locale->symbols-fn :number-format-symbols-latin))

(i18n.goog/register-locale-cb!
 (fn [locale]
  (set! goog.i18n.NumberFormatSymbols (locale->symbols locale))
  (set! goog.i18n.NumberFormatSymbols_u_nu_latn (locale->latin-symbols locale))))

(defn formatter
 [& {:keys [max-fraction-digits
            min-fraction-digits
            significant-digits
            trailing-zeros?
            enforce-ascii-digits]}]
 (i18n.goog/formatter
  (fn [pattern]
   ; setEnforceAsciiDigits must be called before constructing a formatter
   (goog.i18n.NumberFormat.setEnforceAsciiDigits (boolean enforce-ascii-digits))
   (let [number-format (goog.i18n.NumberFormat. pattern)]
    (when (integer? min-fraction-digits)
     (.setMinimumFractionDigits number-format min-fraction-digits))
    (when (integer? max-fraction-digits)
     (.setMaximumFractionDigits number-format max-fraction-digits))
    (when (integer? significant-digits)
     (.setSignificantDigits number-format significant-digits))
    (when (some? trailing-zeros?)
     (.setShowTrailingZeros number-format trailing-zeros?))
    number-format))
  formats))

(def parser formatter)

; PUBLIC API.

(defn -format
 [n & {:keys [locale
              pattern
              min-fraction-digits
              max-fraction-digits
              significant-digits
              trailing-zeros?
              enforce-ascii-digits
              nil-string
              nan-string]}]
 {:pre [(or (nil? n) (number? n))
        (or (nil? locale) (string? locale))]
  :post [(string? %)]}
 (let [locale (or locale i18n.data/default-locale)
       nil-string (or nil-string default-nil-string)
       nan-string (or nan-string default-nan-string)]
  (cond
   (nil? n) nil-string
   (nan? n) nan-string
   :else
   (do
    (i18n.goog/set-locale! locale)
    (.format
     ((formatter
       :min-fraction-digits min-fraction-digits
       :max-fraction-digits max-fraction-digits
       :significant-digits significant-digits
       :trailing-zeros? trailing-zeros?
       :enforce-ascii-digits enforce-ascii-digits)
      (or pattern default-pattern))
     n)))))
(def format (memoize -format))

(defn -parse
 [s & {:keys [locale pattern]}]
 {:pre [(string? s) (or (nil? locale) (string? locale))]
  :post [(number? %)]}
 (let [locale (or locale (-> i18n.data/locales :default :code))]
  (i18n.goog/set-locale! locale)
  (.parse
   ((parser)
    (or pattern default-pattern))
   s)))
(def parse (memoize -parse))

; TESTS.

(deftest ??format--ascii-digits
 (is (= "۱٬۰۰۰٬۰۰۰" (format 1000000 :locale "fa")))
 (is (= "1,000,000" (format 1000000 :locale "fa" :enforce-ascii-digits true))))

(deftest ??format--fraction-digits
 (let [n (/ 10 3)]
  (is (= "3.333" (format n)))
  (is (= "3.3" (format n :max-fraction-digits 1)))
  (is (= "3.33" (format n :max-fraction-digits 2)))

  ; mix max and min
  (is
   (=
    "Min value must be less than max value"
    (try (format n :min-fraction-digits 2 :max-fraction-digits 1)
     (catch js/Error e
      (.-message e)))))
  (is (= "3.33" (format n :min-fraction-digits 1 :max-fraction-digits 2)))
  (is (= "3.33" (format n :min-fraction-digits 2 :max-fraction-digits 2))))

 (is
  (=
   "Can't combine significant digits and minimum fraction digits"
   (try (format 1 :min-fraction-digits 1 :significant-digits 1)
    (catch js/Error e (.-message e)))))

 (let [n 1]
  (is (= "1" (format n)))
  (is (= "1.0" (format n :min-fraction-digits 1)))
  ; :max-fraction-digits does not fill with trailing zeros
  (is (= "1" (format n :max-fraction-digits 5)))

  ; trailing-zeros? has no effect on :min-fraction-digits
  (is (= "1.0" (format n :min-fraction-digits 1 :trailing-zeros? false)))
  ; trailing-zeros? has no effect on :max-fraction-digits
  (is (= "1" (format n :max-fraction-digits 2 :trailing-zeros? false))))

 ; rounding
 (let [n 1.5678]
  ; :max-fraction-digits rounds values
  (is (= "1.568" (format n))))

 ; significant digits
 (is (= "3.33" (format (/ 10 3) :significant-digits 3)))
 (is (= "0.333" (format (/ 1 3) :significant-digits 3)))
 (is (= "0.667" (format (/ 2 3) :significant-digits 3)))
 (is (= "1.2" (format 1.2 :significant-digits 3)))
 (is (= "1.20" (format 1.2 :significant-digits 3 :trailing-zeros? true))))

(deftest ??locale->symbols
 (is (identical? goog.i18n.NumberFormatSymbols_en_AU (locale->symbols "en-AU")))
 (is (identical? goog.i18n.NumberFormatSymbols_en (locale->symbols "asdf"))))

(deftest ??format-parse
 (let [b 1000000000
       tests [["en-IN" "1,00,00,00,000" "1,00,00,00,000.00"]
              ["en-AU" "1,000,000,000" "1,000,000,000.00"]
              ["gl" "1.000.000.000" "1.000.000.000,00"]]
       ; Shuffle to flush out potential memoize bugs.
       tests' (shuffle tests)]
  ; Do all of this twice to flush out potential memoize bugs.
  (dotimes [n 2]
   (taoensso.timbre/debug "Locale number format test run: " (inc n))

   (doseq [[l f p] tests']
    (taoensso.timbre/debug "Checking locale: " l)
    (is (-> b (format :locale l) (= f))
        (str "Failed to format " l " to " f " correctly." (format b :locale l)))
    (is (-> p (parse :locale l) (= b))
        (str "Failed to parse " p " as " l " correctly." (parse p :locale l)))
    (is (-> b (format :locale l) (parse :locale l) (= b))
        (str "Failed to round trip " l "."))))))

(deftest ??parse-examples
 (let [; Some strings that should evaluate to NaN.
       NaNs ["" "banana" "a1" "-" "NaN"]
       parse-me ["1"
                 "1.0"
                 "1,0"
                 "1a"
                 "1,000"
                 "1,00,0"
                 "1,000,000"
                 "1,000.00"
                 "1.000"
                 "1.00.0"
                 "1.000.000"
                 "1.000,00"]
       test-parsing (fn [l es]
                     (is (= (count es) (count parse-me)))
                     (doseq [[e s] (map vector es parse-me)]
                      (is (= e (parse s :locale l)))))]

  ; Empty string cannot parse to a number.
  (doseq [n NaNs]
   (is (nan? (parse n :locale "en"))))

  (test-parsing "en" [1 1 10 1 1000 1000 1000000 1000 1 1 1 1])

  (test-parsing "en-IN" [1 1 10 1 1000 1000 1000000 1000 1 1 1 1])

  (test-parsing "gl" [1 10 1 1 1 1 1 1 1000 1000 1000000 1000])))

(deftest ??format-examples
 (let [format-me [0
                  0.1
                  1.0
                  1.1
                  1.11
                  1.111
                  1.123
                  1.9876
                  1.987
                  1.98
                  1.9
                  1.5
                  -1
                  1
                  10
                  100
                  1000
                  10000
                  1000000
                  1000000000]
       test-formatting (fn [l es]
                        (is (identical? default-nil-string (format nil :locale l)))
                        (is (identical? default-nan-string (format ##NaN :locale l)))
                        (is (= (count es) (count format-me)))
                        (doseq [[e n] (map vector es format-me)]
                         (is (= e (format n :locale l)))))]

  (taoensso.timbre/debug "Test formatting in en locale")
  (test-formatting "en" ["0" "0.1" "1" "1.1" "1.11" "1.111" "1.123" "1.988" "1.987" "1.98" "1.9" "1.5" "-1" "1" "10" "100" "1,000" "10,000" "1,000,000" "1,000,000,000"])

  (taoensso.timbre/debug "Test formatting in en-IN locale")
  (test-formatting "en-IN" ["0" "0.1" "1" "1.1" "1.11" "1.111" "1.123" "1.988" "1.987" "1.98" "1.9" "1.5" "-1" "1" "10" "100" "1,000" "10,000" "10,00,000" "1,00,00,00,000"])

  (taoensso.timbre/debug "Test formatting in gl locale")
  (test-formatting "gl" ["0" "0,1" "1" "1,1" "1,11" "1,111" "1,123" "1,988" "1,987" "1,98" "1,9" "1,5" "-1" "1" "10" "100" "1.000" "10.000" "1.000.000" "1.000.000.000"])))

(deftest ??format--nil
 (is (= "" (format nil)))
 (is (= "x" (format nil :nil-string "x"))))

(deftest ??format--nan
 (is (= "NaN" (format ##NaN)))
 (is (= "z" (format ##NaN :nan-string "z"))))
