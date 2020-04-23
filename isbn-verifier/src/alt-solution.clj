(ns isbn-verifier)

(defn mod11 [n] (mod n 11))

(defn isbn? [isbn]
  (boolean
   (some->> (clojure.string/replace isbn "-" "")
            (re-matches #"^\d{9}[\dX]$")
            (map #(if (= \X %) 10 (Character/digit % 10)))
            (map * (range 10 0 -1))
            (reduce +)
            mod11
            zero?)))
