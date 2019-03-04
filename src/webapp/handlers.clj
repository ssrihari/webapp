(ns webapp.handlers
  (:require [ring.util.response :as res]
            [webapp.prod-error :as prod-error])
  (:import (java.util UUID)))

(defn index
  [request]
  (res/response "Homepage"))

(defn get-error
  [{:keys [route-params]}]
  (let [id (UUID/fromString (:id route-params))]
    (res/response (prod-error/find-by-id id))))
