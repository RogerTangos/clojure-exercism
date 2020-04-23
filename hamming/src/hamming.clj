(ns hamming)

; (defn distance [strand1 strand2]
;   (if (= (count strand1) (count strand2))
;     (->> (map vector strand1 strand2)
;          (map #(not= (first %) (second %)))
;          (filter identity)
;          (count))
;     nil))

; basically the same thing, but using partial and reduce
; (defn distance [strand1 strand2]
;   (if (= (count strand1) (count strand2))
;     (->> (map vector strand1 strand2)
;          (map (partial reduce not=))
;          (filter identity)
;          (count))
;     nil))

; use when to auto-return nil
; and then treat the strands as collections themselves
(defn distance [strand1 strand2]
  (when (= (count strand1) (count strand2))
    (->> (map = strand1 strand2)
         (filter false?)
         (count))))
