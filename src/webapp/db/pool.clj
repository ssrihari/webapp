(ns webapp.db.pool
  (:require [hikari-cp.core :as cp]
            [clojure.java.jdbc :as jdbc]
            [clj-time.jdbc]
            [clj-time.core :as t]
            [webapp.config :as config]
            [mount.core :as mount]))

(mount/defstate
  db
  :start {:datasource (cp/make-datasource (config/lookup :db))}
  :stop (cp/close-datasource (:datasource db)))
