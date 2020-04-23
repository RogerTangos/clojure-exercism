(ns series)

; loop-repeat implementation
; (defn slices
;   ([str len] (slices str 0 len))
;   ([str start len]
;    (loop [str str
;           start start
;           len len
;           res #{}]
;      (if (> (+ start len) (count str))
;        (vec res)
;        (recur
;         str
;         (inc start)
;         len
;         (conj res (subs str start (+ start len))))))))

; for implementation
(defn slices
  [str len]
  (->> (for [x (range (inc (- (count str) len)))]
         (subs str x (+ x len)))
       set
       vec))
