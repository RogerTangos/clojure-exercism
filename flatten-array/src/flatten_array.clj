(ns flatten-array)

(defn flatten [arr]
  (->> (clojure.core/flatten arr)
       (remove nil?)))
