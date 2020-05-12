(ns perfect-numbers)

(defn factors [n]
  (filter #(zero? (rem n %)) (range 1 n)))

(defn classify [n]
  {:pre  [(or (pos-int? n)
              (throw (IllegalArgumentException. "num must be > 0")))]}
  (let [aliquot-sum (apply + (factors n))]
    (cond
      (= n aliquot-sum) :perfect
      (< n aliquot-sum) :abundant
      (> n aliquot-sum) :deficient)))
