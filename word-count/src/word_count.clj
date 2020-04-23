(ns word-count  (:require [clojure.string :as str]))

(defn word-count [mystr]
  (->> mystr
       (str/lower-case)
       (re-seq #"\w+")
       (frequencies)))

(defn word-count-0 [mystr]
  (-> mystr
      (str/replace #"[^\w\d\ ]" "")
      (str/lower-case)
      (str/split #"\s+")
      (frequencies)))

(defn word-count-1 [mystr]
  (as-> (str/lower-case mystr) s
        (str/replace s #"[^a-z0-9\ ]" "") s
        (str/split s #"\s+")
        (frequencies s)))
