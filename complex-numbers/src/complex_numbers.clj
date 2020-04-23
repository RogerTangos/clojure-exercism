(ns complex-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn real [[a _]]
  a)

(defn imaginary [[_ b]]
  b)

(defn abs [[a b]]
  (->> (+ (exp a 2) (exp b 2))
       (math/sqrt)
       double))

(defn conjugate [[a b]]
  [a (* -1 b)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* b c) (* a d))])

(defn div [[a b] [c d]]
  ; (math/expt c 2))
  (->> [(/ (+ (* a c) (* b d)) (+ (exp c 2) (exp d 2)))
        (/ (- (* b c) (* a d)) (+ (exp c 2) (exp d 2)))]
       (map double)
       (into [])))
