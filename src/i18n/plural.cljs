(ns i18n.plural
  (:require
     [cljs.pprint :refer [cl-format]]
     [cljs.test :refer-macros [deftest is are]]
     [goog.i18n.pluralRules]
     [i18n.data]
     [i18n.wrap-goog]
     [taoensso.timbre]))

(def zero "zero"),
(def one "one"),
(def two "two"),
(def few "few"),
(def many "many"),
(def other "other")


(def locale->symbols
  (i18n.wrap-goog/locale->symbols-fn :i18n/plural-rules))

(defn plural-rule [n]
  {:pre  [(int? n)]
   :post [#{zero one two few many other}]}
  (goog.i18n.pluralRules/select n))

(defn plural [n & {:keys [locale plurals]}]
  {:pre [(int? n)]}
  (i18n.wrap-goog/set-locale! (or locale i18n.data/default-locale))
  (or (-> plurals (get (plural-rule n)))
     (taoensso.timbre/warn (cl-format nil "Can't find a plural rule ~A for ~A locale among ~A" (plural-rule n) locale (vals plurals)))))

(i18n.wrap-goog/register-locale-cb!
  (fn [locale]
     (set! goog.i18n.pluralRules.select (locale->symbols locale))))

; ----------------------------------------------------------------------------------------------------------------------
(deftest plural-rule-test
  (i18n.wrap-goog/set-locale! "ru")
  (is (= many (plural-rule 0)))
  (is (= one (plural-rule 1)))
  (is (= few (plural-rule 2)))
  (is (= many (plural-rule 5))))


(deftest user-plural-test
  (let [plurals-ru {zero "тетрадей"
                    one  "тетрадь"
                    few  "тетради"
                    many "тетрадей"}]
     (are [n r] (= r (plural n :locale "ru" :plurals plurals-ru))
              0 "тетрадей"
              1 "тетрадь"
              2 "тетради"
              5 "тетрадей"
              7 "тетрадей"
              22 "тетради"))

  (let [plurals-en {one   "book"
                    other "books"}]
     (are [n r] (= r (plural n :locale "en" :plurals plurals-en))
              0 "books"
              1 "book"
              2 "books"
              5 "books"
              7 "books"
              22 "books")))
