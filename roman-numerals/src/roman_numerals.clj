(ns roman-numerals)

(def numeral-vec [[1000 "M"]
                  [900 "CM"]
                  [500 "D"]
                  [400 "CD"]
                  [100 "C"]
                  [90 "XC"]
                  [50 "L"]
                  [40 "XL"]
                  [10 "X"]
                  [9 "IX"]
                  [5 "V"]
                  [4 "IV"]
                  [1 "I"]])

(defn numerals [num]
  (loop [numeral []
         search-index 0
         remaining num]
    (if (zero? remaining)
      (apply str numeral)
      (let [search-num (first (nth numeral-vec search-index))
            search-numeral (second (nth numeral-vec search-index))
            quotient (quot remaining search-num)
            remainder (rem remaining search-num)
            new-numeral (repeat quotient search-numeral)]
        (recur (concat numeral new-numeral)
               (inc search-index)
               remainder)))))
