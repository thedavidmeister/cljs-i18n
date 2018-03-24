(ns i18n.datetime
 (:require
  i18n.goog
  i18n.locale
  i18n.data
  goog.i18n.DateTimePatterns
  goog.i18n.DateTimeSymbols
  goog.i18n.DateTimeFormat
  goog.i18n.DateTimeParse
  goog.i18n.TimeZone
  taoensso.timbre
  [cljs.test :refer-macros [deftest is]]))

; PRIVATE API. DO NOT CALL THIS EXTERNALLY. IT IS FAR TOO EASY TO SCREW THIS UP.

(def formats
 {:full-date (.-FULL_DATE goog.i18n.DateTimeFormat.Format)
  :long-date (.-LONG_DATE goog.i18n.DateTimeFormat.Format)
  :medium-date (.-MEDIUM_DATE goog.i18n.DateTimeFormat.Format)
  :short-date (.-SHORT_DATE goog.i18n.DateTimeFormat.Format)
  :full-time (.-FULL_TIME goog.i18n.DateTimeFormat.Format)
  :long-time (.-LONG_TIME goog.i18n.DateTimeFormat.Format)
  :medium-time (.-MEDIUM_TIME goog.i18n.DateTimeFormat.Format)
  :short-time (.-SHORT_TIME goog.i18n.DateTimeFormat.Format)
  :full-datetime (.-FULL_DATETIME goog.i18n.DateTimeFormat.Format)
  :long-datetime (.-LONG_DATETIME goog.i18n.DateTimeFormat.Format)
  :medium-datetime (.-MEDIUM_DATETIME goog.i18n.DateTimeFormat.Format)
  :short-datetime (.-SHORT_DATETIME goog.i18n.DateTimeFormat.Format)})
(def default-pattern :long-date)

(defn pattern->common-pattern
 [pattern]
 (case pattern
  :year-full (.-YEAR_FULL goog.i18n.DateTimePatterns)
  :year-full-with-era (.-YEAR_FULL_WITH_ERA goog.i18n.DateTimePatterns)
  :year-month-abbr (.-YEAR_MONTH_ABBR goog.i18n.DateTimePatterns)
  :year-month-full (.-YEAR_MONTH_FULL goog.i18n.DateTimePatterns)
  :month-day-abbr (.-MONTH_DAY_ABBR goog.i18n.DateTimePatterns)
  :month-day-full (.-MONTH_DAY_FULL goog.i18n.DateTimePatterns)
  :month-day-short (.-MONTH_DAY_SHORT goog.i18n.DateTimePatterns)
  :month-day-medium (.-MONTH_DAY_MEDIUM goog.i18n.DateTimePatterns)
  :month-day-year-medium (.-MONTH_DAY_YEAR_MEDIUM goog.i18n.DateTimePatterns)
  :weekday-month-day-medium (.-WEEKDAY_MONTH_DAY_MEDIUM goog.i18n.DateTimePatterns)
  :weekday-month-day-year-medium (.-WEEKDAY_MONTH_DAY_YEAR_MEDIUM goog.i18n.DateTimePatterns)
  :day-abbr (.-DAY_ABBR goog.i18n.DateTimePatterns)
  pattern))

(def locale->symbols
 (i18n.goog/locale->symbols-fn :i18n/date-time-symbols))

(def locale->patterns
 (i18n.goog/locale->symbols-fn :i18n/date-time-patterns))

(i18n.goog/register-locale-cb!
 (fn [locale]
  (set! goog.i18n.DateTimeSymbols (locale->symbols locale))
  (set! goog.i18n.DateTimePatterns (locale->patterns locale))))

(defn formatter []
 (i18n.goog/formatter
  #(goog.i18n.DateTimeFormat. %)
  formats))

(defn parser []
 (i18n.goog/formatter
  #(goog.i18n.DateTimeParse. %)
  formats))

; PUBLIC API.

(defn timezone [v]
 (cond
  (instance? goog.i18n.TimeZone v)
  v

  (#{:local} v)
  (timezone (.getTimezoneOffset (js/Date.)))

  :else
  (.createTimeZone goog.i18n.TimeZone v)))

(defn -format
 [d & {:keys [locale pattern tz]}]
 {:pre [(string? locale)]
  :post [(string? locale)]}
 (i18n.goog/set-locale! (or locale i18n.data/default-locale))
 (let [pattern (pattern->common-pattern (or pattern default-pattern))
       tz (timezone (or tz :local))]
  (.format
   ((formatter)
    pattern)
   d
   tz)))
(def format (memoize -format))

(defn -parse
 [s & {:keys [locale pattern]}]
 {:pre [(string? s) (string? locale)]
  :post [(instance? js/Date %)]}
 (i18n.goog/set-locale! (or locale i18n.data/default-locale))
 (let [pattern (pattern->common-pattern pattern)]
  (let [d (js/Date.)]
   (.parse
    ((parser)
     pattern)
    s
    d)
   d)))
(def parse (memoize -parse))

; TESTS.

(deftest ??locale->symbols
 (is (identical? goog.i18n.DateTimeSymbols_en_AU (locale->symbols "en-AU")))
 (is (identical? goog.i18n.DateTimeSymbols_en (locale->symbols "asdf"))))

(deftest ??timezone
 (=
  {:id "Etc/GMT-10"
   :std_offset 600
   :names ["UTC+10" "UTC+10"]
   :names_ext {:STD_LONG_NAME_GMT "GMT+10:00"
               :STD_GENERIC_LOCATION "GMT+10:00"
               :transitions []}}
  (js->clj
   (.getTimeZoneData (timezone -600))
   :keywordize-keys true)))

(deftest ??common-pattern
 (is (= "11" (format (js/Date. 106000000000) :locale "en-US" :tz 0 :pattern :day-abbr)))

 (is (= "الجمعة، ١١ مايو، ١٩٧٣" (format (js/Date. 106000000000) :locale "ar" :tz 0 :pattern :weekday-month-day-year-medium)))
 (is (= "جمعه ۱۱ مهٔ ۱۹۷۳" (format (js/Date. 106000000000) :locale "fa" :tz 0 :pattern :weekday-month-day-year-medium)))
 (is (= "Fri, May 11, 1973" (format (js/Date. 106000000000) :locale "en" :tz 0 :pattern :weekday-month-day-year-medium)))

 (let [check-parse (fn [p]
                    (is
                     (=
                      [1973 5 11]
                      [(.getFullYear p)
                       (inc (.getMonth p))
                       (.getDate p)])))]

  (check-parse (parse "الجمعة، ١١ مايو، ١٩٧٣" :locale "ar" :tz 0 :pattern :weekday-month-day-year-medium))
  (check-parse (parse "جمعه ۱۱ مهٔ ۱۹۷۳" :locale "fa" :tz 0 :pattern :weekday-month-day-year-medium))
  (check-parse (parse "Fri, May 11, 1973" :locale "en" :tz 0 :pattern :weekday-month-day-year-medium))))

(deftest ??format
 (is (= "May 11, 1973" (format (js/Date. 106000000000) :locale "en-US" :tz 0)))
 (is (= "11 May 1973" (format (js/Date. 106000000000) :locale "en-AU" :tz 0)))

 (is (= "8:26 PM" (format (js/Date. 106000000000) :locale "en-US" :pattern :short-time :tz 0)))
 (is (= "8:26 pm" (format (js/Date. 106000000000) :locale "en-AU" :pattern :short-time :tz 0)))

 (is
  (=
   "Friday, May 11, 1973 at 8:26:40 PM UTC"
   (format (js/Date. 106000000000) :locale "en-US" :pattern :full-datetime :tz 0)))
 (is
  (=
   "Friday, 11 May 1973 at 8:26:40 pm UTC"
   (format (js/Date. 106000000000) :locale "en-AU" :pattern :full-datetime :tz 0)))

 (is
  (=
   "Saturday, 12 May 1973 at 6:26:40 am UTC+10"
   (format (js/Date. 106000000000) :locale "en-AU" :pattern :full-datetime :tz -600))))

(deftest ??parse
 (let [p (parse "May 12, 1973" :locale "en-US" :pattern :long-date)]
  (prn p)
  (is
   (=
    [1973 5 12]
    [(.getFullYear p)
     (inc (.getMonth p))
     (.getDate p)])))


 (let [p (parse "5/11/73" :locale "en-US" :pattern :long-date)]
  (is
   (=
    [2018 3 24]
    [(.getFullYear p)
     (inc (.getMonth p))
     (.getDate p)]))))


(deftest ??format-parse
 ; May 12 1973.
 (let [stamp 106000000000
       ds [(js/Date. stamp) (doto (goog.date.DateTime.) (.setTime stamp))]
       tests [["en-US" "5/11/73"]
              ["en-AU" "11/5/73"]]
       tests' (shuffle tests)]
  ; Do everything twice to flush out cache issues.
  (doseq [d ds]
   (dotimes [n 2]
    (taoensso.timbre/debug "Locale date format test run: " (inc n))

    (doseq [[l f] tests']
     (taoensso.timbre/debug "Checking locale: " l)
     (let [s (format d :locale l :pattern :short-date :tz 0)]
      (is (= f s)
          (str "Failed to format " l " to " f " correctly." s)))
     (let [p (parse f :locale l :pattern :short-date)]
      (is (== 1973 (.getFullYear p)))
      ; JS months are 0 indexed.
      (is (== 4 (.getMonth p)))
      (is (== 11 (.getDate p)))))))))
