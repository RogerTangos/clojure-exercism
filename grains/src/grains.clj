(ns grains)

(defn square [x]
  (reduce * (repeat (dec x) (bigint 2))))

(defn total []
  (dec (square 65)))
