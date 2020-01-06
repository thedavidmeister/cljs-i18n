(ns i18n.plural
	(:require
		[cljs.test :refer-macros [deftest is are]]
		[goog.i18n.pluralRules]
		[i18n.data]
		[i18n.goog]))

(def zero "zero"),
(def one "one"),
(def two "two"),
(def few "few"),
(def many "many"),
(def other "other")


(def locale->symbols
	(i18n.goog/locale->symbols-fn :i18n/plural-rules))

(defn plural [n]
	  (goog.i18n.pluralRules/select n))

(i18n.goog/register-locale-cb!
	(fn [locale]
		(set! goog.i18n.pluralRules.select (locale->symbols locale))))


(deftest plural-test
		 (i18n.goog/set-locale! "ru")
		 (is (= many (plural 0)))
		 (is (= one (plural 1)))
		 (is (= few (plural 2)))
		 (is (= many (plural 5))))