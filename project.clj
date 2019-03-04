(defproject webapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[org.clojure/clojure "1.10.0"]
   [ring "1.7.1"]                                           ;; middleware
   [ring/ring-json "0.4.0"]                                 ;; json middleware
   [bidi "2.1.5"]                                           ;; routing
   [hikari-cp "2.7.0"]                                      ;; db conn pool
   [org.clojure/java.jdbc "0.7.9"]                          ;; jdbc
   [org.postgresql/postgresql "42.2.5"]                     ;; postgres driver
   [honeysql "0.9.4"]                                       ;; sql building
   [nilenso/honeysql-postgres "0.2.5"]                      ;; postgresql building
   [clj-time "0.15.0"]                                      ;; time library
   [cheshire "5.8.1"]                                       ;; json parser
   [aero "1.1.3"]                                           ;; configuration management
   [migratus "1.2.2"]                                       ;; db migrations
   [mount "0.1.16"]                                         ;; app state management

   [com.taoensso/timbre "4.10.0"]                           ;; logging
   [com.fzakaria/slf4j-timbre "0.3.12"]                     ;; slf4j mapping for timbre
   [org.slf4j/log4j-over-slf4j "1.7.14"]                    ;; log4j to slf4j
   [org.slf4j/jul-to-slf4j "1.7.14"]                        ;; slf4j wrapper
   [org.slf4j/jcl-over-slf4j "1.7.14"]])                    ;; slf4j wrapper

