(def project 'thedavidmeister/cljs-i18n)
(def version "0.1.0")
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
   [adzerk/bootlaces "0.1.13"]])

(task-options!
 pom {:project project
      :version version
      :description description
      :url github-url
      :scm {:url github-url}})

(require
 '[adzerk.bootlaces :refer :all])

(bootlaces! version)

(deftask deploy-clojars
 []
 (comp
  (build-jar)
  (push-release)))
