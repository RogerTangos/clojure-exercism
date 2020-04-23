(ns beer-song)

(defn verse [n]
  (case n
    2 "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
    1 "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
    0 "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n" n n (dec n))))

(defn sing
  ([start] (sing start 0))
  ([start end]
   (loop [start start
          end end
          result []]
     (if (not= start (dec end))
       (recur (dec start) end (conj result (verse start)))
       (clojure.string/join "\n" result)))))
