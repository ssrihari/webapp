(ns webapp.db.migrations
  (:require [migratus.core :as migratus]
            [webapp.config :as config]
            [webapp.db.pool :as pool]
            [mount.core :as mount]))

(defn migration-config []
  (assoc
    (config/lookup :migrations)
    :db pool/db))

(mount/defstate
  migrations
  :start (do (migratus/init (migration-config))
             (migratus/migrate (migration-config))))

(comment
  (migratus/create (migration-config) "create-prod-errors"))





