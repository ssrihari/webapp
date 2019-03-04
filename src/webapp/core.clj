(ns webapp.core
  (:require [ring.adapter.jetty :as jetty]
            [bidi.ring :refer (make-handler)]
            [ring.util.response :as res]))

(defn index-handler
  [request]
  (res/response "Homepage"))

(defn article-handler
  [{:keys [route-params]}]
  (res/response (str "You are viewing article: " (:id route-params))))

(def handler
  (make-handler
    ["/" {"index.html"                      index-handler
          ["articles/" :id "/article.html"] article-handler}]))

(defonce server (atom nil))

(defn start []
  (reset! server (jetty/run-jetty handler {:port 3000 :join? false})))

(defn stop []
  (.stop @server))

(comment
  (start)
  (stop))