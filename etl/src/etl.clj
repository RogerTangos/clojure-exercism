(ns etl)

(defn transform [source]
  ; create a function, transformer, that produces
  ; a nested vec with v_1 k... v_n k items
  (let [transformer #(interleave
                      (map
                       clojure.string/lower-case
                       (second %))
                      (repeat
                       (count (second %))
                       (first %)))]
    (apply hash-map (mapcat transformer source))))
