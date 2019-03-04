(ns webapp.utils)

(extend-protocol cheshire.generate/JSONable
  org.joda.time.DateTime
  (to-json [dt gen]
    (cheshire.generate/write-string gen (str dt))))