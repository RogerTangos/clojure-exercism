(ns grade-school)

(defn grade [school grade]
  (school grade []))

(defn add [school name grade]
  (merge-with into school {grade [name]}))

(defn sorted [school]
  (->> school
       (map #(hash-map (first %) (sort (second %))))
       (into (sorted-map))))
