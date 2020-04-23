(ns armstrong-numbers
  {:doc "determine if the num input is an armstrong number.
https://en.wikipedia.org/wiki/Narcissistic_number"
   :author "RogerTangos"})

(defn exp [x n]
  (reduce * (repeat n x)))
  ; sadly cannot use Math/pow, due to out of range err
  ; (int (Math/pow x n)))

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s)))

(defn armstrong? [a-num]
  (let [digits (map #(parse-int (str %)) (str a-num))
        num-len (count digits)
        sums (map #(exp % num-len) digits)
        total (apply + sums)]
    (= total a-num)))
