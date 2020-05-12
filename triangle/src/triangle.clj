(ns triangle)

(defn is-valid? [sides]
  (let [[a b c] (sort sides)]
    (and
     (> (+ a b) c)
     (not (some #{0} [a b c])))))

(defn equilateral? [& sides]
  (and (is-valid? sides) (= 1 (count (distinct sides)))))

(defn isosceles? [& sides]
  (and
   (is-valid? sides) (>= 2 (count (distinct sides)))))

(defn scalene? [& sides]
  (and
   (is-valid? sides) (= 3 (count (distinct sides)))))
