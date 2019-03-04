(ns webapp.prod-error
  (:require [clojure.java.jdbc :as jdbc]
            [webapp.db.pool :as pool]
            [clj-time.core :as t]
            [honeysql.core :as sql]
            [honeysql.helpers :as helpers]
            [clj-time.core :as time]
            [clj-time.predicates :as tp]))

(defn add-production-errors [errors]
  (jdbc/insert-multi! pool/db
                      :production_errors
                      errors))

(defn find-by-id [error-id]
  (->> (sql/format {:select [:*]
                    :from   [:production_errors]
                    :where  [:= :id error-id]})
       (jdbc/query pool/db)
       first))

(defn yesterday-error? [error-id]
  (let [{start-time :start_time} (find-by-id error-id)]
    (prn start-time (time/today))
    (tp/march? start-time)))


(comment
  (let [id (java.util.UUID/fromString "a49db426-f5dd-4cb1-9f53-3ffff13870c6")]
    #_(add-production-errors
        [{:id         id
          :problem    "something 1"
          :start_time (t/now)
          :end_time   (t/now)
          :summary    "some summary here"}])
    (find-by-id id)
    (yesterday-error? id)))
