(defproject looping-is-recursion "1.0.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [iloveponies.tests/looping-is-recursion "0.1.0-SNAPSHOT"]]
  :profiles {:dev {:plugins [[cider/cider-nrepl "0.8.1"][lein-midje "3.1.1"]]}})
