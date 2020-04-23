(ns phone-number)

(defn number [num-str]
  (let [digit-str (as-> (filter #(Character/isDigit %) num-str) n
                        (apply str n)
                        (if (and (not= (count n) 10)
                                 (= (first n) \1))
                          (apply str (rest n))
                          n))]
    (if (= (count digit-str) 10)
      digit-str
      "0000000000")))

(defn area-code [num-string]
  (subs (number num-string) 0 3))

(defn pretty-print [num-str]
  (let [digit-str (number num-str)
        area-code (area-code num-str)
        exchange-code (subs digit-str 3 6)
        subscriber-num (subs digit-str 6 10)]

    (str
     "(" area-code ") " exchange-code "-" subscriber-num)))
