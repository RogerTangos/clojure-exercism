(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (let [letters (dedupe plain-text)
        counts (->> plain-text
                    (partition-by identity)
                    (map count))
        encoding (interleave counts letters)
        filtered (filter #(not= 1 %) encoding)]
    (apply str filtered)))

(def re-num-letters #"(\d*)([a-zA-Z\s]{1})")

(defn prepend-1-if-first-not-num
  "given a number n and a letter x, return (n x). If n is '', return as n = 1"
  [[n x]]
  (list
   (if (= n "")
     1
     (Integer/parseInt n))
   x))

(defn run-length-decode
  "de-codes run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq re-num-letters) ; break into two length segments of number and text
       (map rest) ; remove the residual last bit)
       (map prepend-1-if-first-not-num)
       (map #(repeat (first %) (last %)))
       (flatten)
       (apply str)))
