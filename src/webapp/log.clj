(ns webapp.log
  (:require [taoensso.timbre :as timbre]
            [taoensso.timbre.appenders.core :as appenders]
            [mount.core :as mount]
            [webapp.config :as config]))

(mount/defstate
  log
  :start
  (timbre/merge-config!
    (merge {:appenders {:spit (appenders/spit-appender
                                {:fname (config/lookup :log :filename)})
                        :println nil}}
           (config/lookup :log))))