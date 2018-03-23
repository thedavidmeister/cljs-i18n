(ns i18n.goog
 (:require
  i18n.data
  [javelin.core :as j]
  [cljs.test :refer-macros [deftest is]]))

(defn locale->symbols-fn
 ([k] (locale->symbols-fn k i18n.data/locales))
 ([k locales]
  {:pre [(keyword? k)]}
  (fn [locale]
   (k (get locales locale (:default locales))))))

(defn format-or-pattern->pattern
 [formats format-or-pattern]
 (get formats format-or-pattern format-or-pattern))

(defn formatter
 [build-fn formats]
 (fn [format-or-pattern]
  (build-fn
   (format-or-pattern->pattern
    formats
    format-or-pattern))))

(let [fs (j/cell #{})
      current-locale (j/cell nil)]
 (defn register-locale-cb! [f]
  (swap! fs conj f))

 (defn deregister-locale-cb! [f]
  (swap! fs disj f))

 (defn set-locale! [locale]
  (when-not (= @current-locale locale)
   (doseq [f @fs] (f locale))
   (reset! current-locale locale))))

; TESTS.

(deftest ??set-locale
 (let [c (j/cell "")
       f #(swap! c str %)
       g #(swap! c str %)]
  ; Without any registered callbacks, c should remain the same.
  (set-locale! "en")
  (is (== "" @c))

  ; When f is registered, c should increase by 1.
  (register-locale-cb! f)
  (set-locale! "en-AU")
  (is (== "en-AU" @c))

  ; Registering f a second time should do nothing.
  (register-locale-cb! f)
  (set-locale! "en-GB")
  (is (== "en-AUen-GB" @c))

  ; Registering g should cause both f and g to execute.
  (register-locale-cb! g)
  (set-locale! "en-IN")
  (is (== "en-AUen-GBen-INen-IN" @c))

  ; We should be able to deregister both f and g.
  (deregister-locale-cb! f)
  (deregister-locale-cb! g)
  (set-locale! "en-US")
  (is (== "en-AUen-GBen-INen-IN" @c))))

(deftest ??locale->symbols-fn
 (let [en :en
       d :d
       ls {"en" {:foo en}
           :default {:foo d}}
       f (locale->symbols-fn :foo ls)]
  (is (identical? en (f "en")))
  (is (identical? d (f "asdf")))))

(deftest ??format-or-pattern->pattern
 (let [fs #{:foo :bar}]
  (is (= :foo (format-or-pattern->pattern fs :foo)))
  (is (= "thing" (format-or-pattern->pattern fs "thing")))))
