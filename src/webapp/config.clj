(ns webapp.config
  (:require [aero.core :as aero]
            [clojure.java.io :as io]
            [mount.core :as mount]))

(mount/defstate
  config
  :start (aero/read-config (io/resource "config.edn")))

(defn lookup [& ks]
  (get-in config ks))