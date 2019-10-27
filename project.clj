(defproject io.axrs.cli-tools/whittle "0.0.1"
  :description "A basic CLJ logger for CLI scripts"
  :license "Eclipse Public License - v 2.0"
  :url "https://github.com/axrs/whittle"
  :source-paths ["src"]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.10.1"]]}}
  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :sign-releases false}]])
