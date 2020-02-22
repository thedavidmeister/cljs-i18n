(ns i18n.spec
	(:require
		[clojure.spec.alpha :as spec]
		i18n.data
		i18n.locale
		[cljs.test :refer-macros [deftest is testing]]))

(spec/def :i18n/code i18n.locale/valid-locale?)
(spec/def :i18n/description (spec/and string? seq))

(spec/def :i18n/locale
	(spec/keys
		:req [:i18n/description
			  :i18n/number-format-symbols
			  :i18n/number-format-symbols-latin
			  :i18n/number-format-symbols-compact
			  :i18n/date-time-symbols
			  :i18n/date-time-patterns
			  :i18n/code]))

(spec/def :i18n/locales
	(spec/map-of :i18n/code :i18n/locale))

(deftest ??locales
	(let [locales (dissoc i18n.data/locales :default)]
		(is
			(spec/valid? :i18n/locales locales)
			(spec/explain-str :i18n/locales locales))

		(testing "all language descriptions are distinct"
			(let [descriptions (->> locales vals (map :i18n/description))]
				(is (= (sort (distinct descriptions))
					   (sort descriptions)))))))
