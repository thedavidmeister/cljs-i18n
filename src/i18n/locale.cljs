(ns i18n.locale
 (:require
  i18n.data
  taoensso.timbre
  [cljs.test :refer-macros [deftest is are]]))

(defn valid-locale?
 [locale]
 (boolean
  (and
   ; only accept singular locales
   (string? locale)
   (or
    ; always validate supported locales, provided they are a string
    (contains? i18n.data/locales locale)
    (and
     (not (clojure.string/index-of locale ","))
     ; only valid split is on `-`
     (let [[lang country] (clojure.string/split locale "-")]
      (and
       ; lang is required and must be lowercase alphabetical
       lang (re-matches #"[a-z]+" lang)
       ; country is optional but must be uppercase alphabetical if set
       (if country
        (re-matches #"[A-Z]+" country)
        true))))))))

(defn fix-locale
 "Attempt to fix common problems with almost-valid locale strings"
 [locale]
 {:pre [(string? locale)]
  :post [(valid-locale? %)]}
 (cond
  (valid-locale? locale)
  locale

  ; Some systems will provide underscores in locales which is non compliant
  ; with the web spec.
  (clojure.string/index-of locale "_")
  (fix-locale (clojure.string/replace locale "_" "-"))

  ; fix casing
  (clojure.string/index-of locale "-")
  (fix-locale
   (let [[lang country] (clojure.string/split locale "-")]
    (str
     (clojure.string/lower-case lang)
     (when country
      (str "-" (clojure.string/upper-case country))))))

  (re-matches #"[A-z]+" locale)
  (fix-locale (clojure.string/lower-case locale))

  ; Throw a soft error if the locale isn't something we can fix. We can
  ; fallback to the default locale and carry on until the bug is fixed.
  :else
  (do
   (taoensso.timbre/warn (str "Can't fix locale: " locale))
   i18n.data/default-locale)))

; https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language
; (def accept-language
;  (let [c (j/cell nil)]
;   (ajax.core/GET
;    (str "//" wire.data/back-host "/i18n/locale/accept-language")
;    {:handler #(reset! c %)})
;   (hoplon.storage-atom.local-storage c ::accept-language)))

(defn accept-language->locales
 "Turns a raw accept-language string into a seq of locales."
 [accept-language]
 {:pre [(or (string? accept-language) (nil? accept-language))]
  :post [(or (nil? %) (coll? %))]}
 (when accept-language
  (->>
   ; Split on , and cleanup each language option.
   (clojure.string/split accept-language #",")
   (map clojure.string/trim)
   (remove #(= % ""))
   ; Normalise the case when q is not provided (1 is the default).
   (map
    (fn [s]
     (if-not (re-find #";q=" s) (str s ";q=1") s)))
   ; Split each string on q.
   (map
    (fn [s]
     (clojure.string/split s #";q=")))
   ; Prepare pairs for sorting and sort to ensure locales are high to low q.
   (map
    (fn [[locale q]]
     [(js/parseFloat q) locale]))
   sort
   reverse
   ; Return just the locales.
   (map second)
   ; Replace the wildcard with our default locales. Don't have a lot of options
   ; at this point.
   (map
    (fn [locale]
     (if (= "*" locale)
      i18n.data/default-locale
      locale)))
   seq)))

(defn supported-locale
 [locale]
 {:pre [(or (string? locale) (sequential? locale) (nil? locale))]
  :post [(valid-locale? %)]}
 (if-not locale
  i18n.data/default-locale
  (let [ls (if (string? locale)
            (accept-language->locales locale)
            locale)
        loop-fn
        (fn [ls]
         (loop [[l & ls'] ls]
          (when (string? l)
           (let [fixed (fix-locale l)]
            (if (contains? i18n.data/locales fixed)
             fixed
             (recur ls'))))))]
   (or
    ; first pass against the full locales
    (loop-fn ls)
    ; second pass against langcodes only, drop countries
    (loop-fn
     (map
      (fn [l]
       (first (clojure.string/split l "-")))
      ls))
    ; fallback to default
    i18n.data/default-locale))))

(defn system-locale
 []
 {:post [(or (nil? %) (coll? %))]}
 (let [navigator (.-navigator js/window)]
  ; https://zzz.buzz/2016/01/13/detect-browser-language-in-javascript/
  (when navigator
   (let [v (js->clj
            (or
             (.-languages navigator)
             (.-language navigator)
             (.-userLanguage navigator)
             (.-browserLanguage navigator)
             (.-systemLanguage navigator)))]
    (if (string? v) [v] v)))))

; TESTS.

(deftest ??valid-locale
 (are [l] (valid-locale? l)
  "en"
  "en-GB"
  ; supported exceptions to the rules
  "sr-Latn"
  "es-419")

 (are [l] (not (valid-locale? l))
  "en_GB"
  "EN-GB"
  "EN_GB"
  "en-gb"
  "en_gb"
  "En-Gb"
  "en, fr;q=0.5"
  ["en" "fr"]
  :default
  "")

 (is (= [:default] (remove valid-locale? (keys i18n.data/locales)))))

(deftest ??fix-locale
 (are [l e] (and
             (= e (fix-locale l))
             (valid-locale? (fix-locale l)))
  ; already valid
  "en" "en"
  "sr-Latn" "sr-Latn"
  "en-GB" "en-GB"

  ; not supported but technically valid
  "asdf" "asdf"
  "a-A" "a-A"

  ; fix
  "en_GB" "en-GB"
  "EN-GB" "en-GB"
  "EN_GB" "en-GB"
  "EN" "en"
  "En" "en"
  "en_gb" "en-GB"))

(deftest ??accept-language->locales
 (are [al e] (= e (accept-language->locales al))
  nil nil
  "" nil
  "en" ["en"]
  "*" [i18n.data/default-locale]
  "fr;q=0.5, en" ["en" "fr"]
  "da, en-gb;q=0.8, en;q=0.7" ["da" "en-gb" "en"]
  "fr-CH, fr;q=0.9, en;q=0.8, de;q=0.7, *;q=0.5" ["fr-CH" "fr" "en" "de" i18n.data/default-locale]
  "fr-CH, fr;q=0.9, de;q=0.7, en;q=0.8, *;q=0.5" ["fr-CH" "fr" "en" "de" i18n.data/default-locale]))

(deftest ??supported-locale
 (are [l e] (= e (supported-locale l))
  ; nils and seqs
  nil i18n.data/default-locale
  [nil] i18n.data/default-locale
  ; basic locale strings
  "en" "en"
  "en-GB" "en-GB"
  "EN" "en"
  "ZH" "zh"
  "ZH-HK" "zh-HK"
  "zh_hk" "zh-HK"
  "zh-HK" "zh-HK"
  ; seq of locale strings
  ["asf" "ZH" "lskf"] "zh"
  ; should be able to pick locales out of accept strings
  "fr;q=0.5, zh;q=0.9" "zh"
  "fr;q=0.6, zh;q=0.3" "fr"
  ; French - Hong Kong doesn't exist, but Chinese - Hong Kong does
  "fr-HK;q=0.6, zh-HK;q=0.3" "zh-HK"
  ; French - Hong Kong doesn't exist, neither does asdf
  "fr-HK;q=0.6, asdf;q=0.3" "fr"
  ; no support for nested structures
  [["fr"]] "en"))
