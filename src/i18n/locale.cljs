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
 {:pre [(string? locale)]}
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

(defn normalize-locale
 [locale]
 (if (valid-locale? locale)
  locale
  (fix-locale locale)))

(defn langcodes->supported-langcode
 [langcodes]
 {:pre [(coll? langcodes)]
  :post [(valid-locale? %)]}
 (some
  #(when (get i18n.data/locales %) %)
  (into (vec langcodes) [i18n.data/default-locale])))

; https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language
; (def accept-language
;  (let [c (j/cell nil)]
;   (ajax.core/GET
;    (str "//" wire.data/back-host "/i18n/locale/accept-language")
;    {:handler #(reset! c %)})
;   (hoplon.storage-atom.local-storage c ::accept-language)))

(defn accept-language->langcodes
 "Turns a raw accept-language string into a seq of langcodes."
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
   ; Prepare pairs for sorting and sort to ensure langcodes are high to low q.
   (map
    (fn [[langcode q]]
     [(js/parseFloat q) langcode]))
   sort
   reverse
   ; Return just the langcodes.
   (map second)
   ; Replace the wildcard with our default langcode. Not sure if this is the
   ; right thing to do here.
   (map
    (fn [langcode]
     (if (= "*" langcode)
      i18n.data/default-locale
      langcode)))
   seq)))

(defn navigator-language
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

(defn profile->langcodes
 [profile]
 {:post [(or (nil? %) (coll? %))]}
 (let [locale (:locale profile)]
  (if (string? locale) [locale] locale)))

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

(deftest ??accept-language-seq
 (are [al e] (= e (accept-language->langcodes al))
  nil nil
  "" nil
  "en" ["en"]
  "*" [i18n.data/default-locale]
  "fr;q=0.5, en" ["en" "fr"]
  "da, en-gb;q=0.8, en;q=0.7" ["da" "en-gb" "en"]
  "fr-CH, fr;q=0.9, en;q=0.8, de;q=0.7, *;q=0.5" ["fr-CH" "fr" "en" "de" i18n.data/default-locale]
  "fr-CH, fr;q=0.9, de;q=0.7, en;q=0.8, *;q=0.5" ["fr-CH" "fr" "en" "de" i18n.data/default-locale]))
