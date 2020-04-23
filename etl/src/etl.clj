(ns etl)

(def foo {1 [:foo :bar], 2 [:fizz :buzz]})

(defn transform [source]); (into [] (clojure.set/map-invert foo))
  ;
  ;
  ; (let [new-keys (flatten (vals source))])
  ;
  ;
  ;
  ; (->> (clojure.set/map-invert source)
  ;      ()))

; use all items in values of

  ; (clojure.set/map-invert source))
  ; (println (keys source))
  ; (println (set (vals source))))


; create empty map with each key
; go over the map, and assoc
