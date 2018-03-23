(def project 'thedavidmeister/cljs-i18n)
(def version "0.3.0")
(def description "Wrapper around goog.i18n for cljs")
(def github-url "https://github.com/thedavidmeister/cljs-i18n")

(set-env!
 :source-paths #{"src"}
 :dependencies
 '[; scaffolding...
   [org.clojure/clojure "1.10.0-alpha4"]
   [org.clojure/clojurescript "1.9.946"]
   [adzerk/boot-cljs "2.1.4"]
   [crisptrutski/boot-cljs-test "0.3.5-SNAPSHOT"]
   [adzerk/bootlaces "0.1.13"]

   ; transitive deps...
   [doo "0.1.8"]

   ; everything else...
   [com.taoensso/timbre "4.10.0" :scope "test"]])

(task-options!
 pom {:project project
      :version version
      :description description
      :url github-url
      :scm {:url github-url}})

(require
 '[adzerk.bootlaces :refer :all]
 '[crisptrutski.boot-cljs-test :refer [test-cljs]])

(bootlaces! version)

(deftask deploy-clojars
 []
 (comp
  (build-jar)
  (push-release)))

(defn cljs-compiler-options
 [opts]
 (merge
  {
   :parallel-build true
   :load-tests false}
  opts))

(def test-cljs-compiler-options
 (partial cljs-compiler-options
  {:load-tests true
   :process-shim false}))

(deftask tests-cljs
 "Run all the CLJS tests"
 [w watch? bool "Watches the filesystem and reruns tests when changes are made."
  o optimizations OPTIMIZATIONS str "Sets the optimizations level for cljs"]
 ; Run the JS tests
 (comp
  (if watch?
   (comp
    (watch)
    (speak :theme "woodblock"))
   identity)
  (test-cljs
   :exit? (not watch?)
   ; :js-env :chrome
   :optimizations (or (keyword optimizations) :none)
   :cljs-opts (test-cljs-compiler-options)
   :namespaces [#".*"])))
