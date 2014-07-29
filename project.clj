(defproject cljtemplate "0.1.0-SNAPSHOT"
  :description "It is no measure of health to be well adjusted to a profoundly sick society"
  :url "http://github.com/saiberz"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-jetty-adapter "1.3.0"]
                 [ring/ring-core "1.3.0"]
                 [http-kit "2.1.18"]
                 [enlive "1.1.5"]
                 [cljs-ajax "0.2.6"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot cljtemplate.app )


