(ns etl)

(defn transform [source]
  ; create a function, transformer, that produces
  ; a nested vec with v_1 k... v_n k items
  ; then flatten the result and turn them into a hash map.
  (let [transformer #(interleave
                      (map
                       clojure.string/lower-case
                       (second %))
                      (repeat
                       (count (second %))
                       (first %)))]
    (->> (map transformer source)
         (flatten)
         (apply hash-map))))
