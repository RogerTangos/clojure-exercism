(ns binary-search)

(defn middle [mylist]
  (quot (count mylist) 2))

(defn search-for [target sorted-list]
  (loop [index (middle sorted-list)
         lower 0
         upper (dec (count sorted-list))]
    (let [result (nth sorted-list index)
          half-up (int (Math/ceil (/ (+ upper index) 2)))
          half-down (quot (+ lower index) 2)]
      (cond
        (= result target) index
        (= upper lower index) (throw (Exception. "not found"))
        (> result target) (recur half-down
                                 lower
                                 index)
        (< result target) (recur half-up
                                 index
                                 upper)))))
