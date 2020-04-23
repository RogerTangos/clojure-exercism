(ns collatz-conjecture)

(defn collatz [num]
  {:pre  [(or (pos-int? num)
              (throw (IllegalArgumentException. "num must be > 0")))]}
  (loop [num num
         cnt 0]
    (if (= num 1)  cnt
        (recur (if (even? num) (/ num 2) (+ (* 3 num) 1))
               (inc cnt)))))
