(ns webapp.server
  (:require [ring.adapter.jetty :as jetty]
            [webapp.log]
            [webapp.db.migrations]
            [webapp.utils]
            [bidi.ring :as br]
            [webapp.handlers :as h]
            [mount.core :as mount]
            [webapp.config :as config]
            [ring.middleware.json :as rmj]
            [ring.middleware.keyword-params :as rmkp]
            [ring.util.response :as res]
            [taoensso.timbre :as timbre]))

(def routes
  ["/" {""              (fn [_] {:body "hm?"})
        "favicon.ico"   (fn [_] (res/response nil))
        "index.html"    h/index
        ["errors/" :id] h/get-error}])

(defn log-requests-mw [handler]
  (fn [req]
    (let [res (handler req)]
      (timbre/info :request req :response res)
      res)))

(def app
  (-> routes
      br/make-handler
      log-requests-mw
      rmj/wrap-json-params
      rmj/wrap-json-response
      (rmj/wrap-json-body {:keywords? true :bigdecimals? true})
      rmkp/wrap-keyword-params))

(mount/defstate
  server
  "HTTP Server"
  :start (jetty/run-jetty app (config/lookup :server))
  :stop (.stop server))

(comment
  (mount/stop)
  (mount/start))
