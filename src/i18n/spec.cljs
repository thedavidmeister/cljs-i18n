(ns i18n.spec
 (:require
  [clojure.spec.alpha :as spec]
  i18n.data
  i18n.locale
  [cljs.test :refer-macros [deftest is]]))

(spec/def :i18n/code i18n.locale/valid-locale?)

(spec/def :i18n/locale
 (spec/keys
  :req [:i18n/number-format-symbols
        :i18n/number-format-symbols-latin
        :i18n/date-time-symbols
        :i18n/code]))

(spec/def :i18n/locales
 (spec/map-of :i18n/code :i18n/locale))

(deftest ??locales
 (let [locales (dissoc i18n.data/locales :default)]
  (is
   (spec/valid? :i18n/locales locales)
   (spec/explain-str :i18n/locales locales))))
