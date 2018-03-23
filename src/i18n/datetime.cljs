(ns i18n.datetime
 (:require
  i18n.goog
  i18n.locale
  goog.i18n.DateTimeSymbols
  goog.i18n.DateTimeFormat
  goog.i18n.DateTimeParse
  goog.i18n.TimeZone
  taoensso.timbre
  time.data
  [javelin.core :as j]
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

(def locale->symbols
 (i18n.goog/locale->symbols-fn :date-time-symbols))

(i18n.goog/register-locale-cb!
 #(set! goog.i18n.DateTimeSymbols (locale->symbols %)))

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
 (if-not (instance? goog.i18n.TimeZone v)
  (.createTimeZone goog.i18n.TimeZone v)
  v))

(defn -format
 [d & {:keys [locale pattern tz]}]
 {:pre [(time.data/date-time? d)
        (string? locale)]
  :post [(string? locale)]}
 (let [locale (or locale @i18n.locale/supported-user-locale)
       pattern (or pattern default-pattern)]
  (i18n.goog/set-locale! locale)
  (.format
   ((formatter)
    pattern)
   d
   (when tz (timezone tz)))))
(def format (memoize -format))

(defn format-cell
 [d & {:keys [pattern locale tz]}]
 (let [locale (or locale i18n.locale/supported-user-locale)]
  (j/cell= (format d :locale locale :pattern pattern :tz tz))))

(defn -parse
 [s & {:keys [locale pattern]}]
 {:pre [(string? s) (string? locale)]
  :post [(time.data/date-time? %)]}
 (let [locale (or locale @i18n.locale/supported-user-locale)
       pattern (or pattern default-pattern)]
  (i18n.goog/set-locale! locale)
  (let [d (js/Date.)]
   (.parse
    ((parser)
     pattern)
    s
    d)
   d)))
(def parse (memoize -parse))

(defn parse-cell
 [s & {:keys [pattern locale]}]
 (let [locale (or locale i18n.locale/supported-user-locale)]
  (j/cell= (parse s :locale locale :pattern pattern))))

; TESTS.

(deftest ??locale->symbols
 (is (identical? goog.i18n.DateTimeSymbols_en_AU (locale->symbols "en-AU")))
 (is (identical? goog.i18n.DateTimeSymbols_en (locale->symbols "asdf"))))

(deftest ??format-parse
 ; May 12 1973.
 (let [d (js/Date. 106000000000)
       tests [["en-US" "5/11/73"]
              ["en-AU" "11/5/73"]]
       tests' (shuffle tests)]
  ; Do everything twice to flush out cache issues.
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
     (is (== 11 (.getDate p))))))))
