(ns i18n.locale
 (:require 
  auth.state
  hoplon.storage-atom
  [javelin.core :as j]
  ajax.core
  wire.data
  i18n.data
  env.data
  wheel.error.core
  [cljs.test :refer-macros [deftest is are]]))

(def default-langcode "en-GB")

(defn valid-langcode?
 [langcode]
 (and (string? langcode)
      ; Many systems try to ship _ instead of - e.g. en_US vs. en-US
      (= -1 (.indexOf langcode "_"))))

(defn fix-langcode
 "Attempt to fix common problems with almost-valid langcodes"
 [langcode]
 (cond
  ; Some systems will provide underscores in langcodes which is non compliant
  ; with the web spec.
  (string? langcode)
  (clojure.string/replace langcode "_" "-")

  ; Somehow we occassionally get a vector like ["en-GB"] which needs to be
  ; unwrapped.
  (and (sequential? langcode) (= 1 (count langcode)))
  (fix-langcode (first langcode))

  ; Throw a soft error if the langcode isn't something we can fix. We can
  ; fallback to the default langcode and carry on until the bug is fixed.
  :else
  (do
   (wheel.error.core/error :error (str "Can't fix non-string langcode: " (pr-str langcode)))
   default-langcode)))

(defn langcodes->supported-langcode
 [langcodes]
 {:pre [(coll? langcodes)]
  :post [(valid-langcode? %)]}
 (some
  #(when (get i18n.data/locales %) %)
  (into (vec langcodes) [default-langcode])))

; https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language
(def accept-language
 (let [c (j/cell nil)]
  (ajax.core/GET
   (str "//" wire.data/back-host "/i18n/locale/accept-language")
   {:handler #(reset! c %)})
  (hoplon.storage-atom.local-storage c ::accept-language)))

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
      default-langcode
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

(defn user-locale-cell
 ([] (user-locale-cell auth.state/user-profile (j/cell= (accept-language->langcodes accept-language))))
 ([profile] (user-locale-cell profile (j/cell= (accept-language->langcodes accept-language))))
 ([profile langcodes]
  (j/with-let [c (j/cell=
                  (map
                   fix-langcode
                   (or (profile->langcodes profile)
                       langcodes
                       (navigator-language)
                       [default-langcode])))]
   (j/cell= (assert (and (coll? c)
                         (every? valid-langcode? c)))))))
(def user-locale (user-locale-cell))
(def supported-user-locale
 (j/cell=
  (if-not env.data/testing?
   (langcodes->supported-langcode user-locale)
   ; Hardcode the locale to en-AU in testing environments so that CI doesn't
   ; become a PITA to configure.
   "en-AU")))

; TESTS.

(deftest ??valid-langcode
 (are [l] (valid-langcode? l)
  "en"
  "en-GB")

 (are [l] (not (valid-langcode? l))
  "en_GB"))

(deftest ??fix-langcode
 (are [l e] (= e (fix-langcode l))
  "en" "en"
  "en-GB" "en-GB"
  "en_GB" "en-GB"
  ["en"] "en"
  ["en-GB"] "en-GB"
  ["en_GB"] "en-GB"))

(deftest ??accept-language-seq
 (are [al e] (= e (accept-language->langcodes al))
  nil nil
  "" nil
  "en" ["en"]
  "*" [default-langcode]
  "fr;q=0.5, en" ["en" "fr"]
  "da, en-gb;q=0.8, en;q=0.7" ["da" "en-gb" "en"]
  "fr-CH, fr;q=0.9, en;q=0.8, de;q=0.7, *;q=0.5" ["fr-CH" "fr" "en" "de" default-langcode]
  "fr-CH, fr;q=0.9, de;q=0.7, en;q=0.8, *;q=0.5" ["fr-CH" "fr" "en" "de" default-langcode]))

(deftest ??user-locale-cell
 (let [p (j/cell nil)
       l (j/cell nil)
       c (user-locale-cell p l)]
  (is (= (or (navigator-language) [default-langcode])
         @c))

  (reset! p {:locale "fr"})
  (is (= ["fr"] @c))

  (reset! p {:locale "en_US"})
  (is (= ["en-US"] @c))

  (reset! p {:locale ["zh"]})
  (is (= ["zh"] @c))

  ; p should take preference over l.
  (reset! l ["da"])
  (is (= ["zh"] @c))

  (reset! p nil)
  (is (= ["da"] @c))

  (reset! l ["en"])
  (is (= ["en"] @c))))
