(ns say (:require [clojure.pprint :as pprint]))

(defn number [num]
  {:pre  [(or (<= 0 num 999999999999)
              (throw (IllegalArgumentException. "out of range")))]}
  (clojure.string/replace (pprint/cl-format nil "~R" num) "," ""))
