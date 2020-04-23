(ns anagram (:require [clojure.string :as str]))

(defn gen-primes "Generates an infinite, lazy sequence of prime numbers"
  []
  (letfn [(reinsert [table x prime]
            (update-in table [(+ prime x)] conj prime))
          (primes-step [table d]
                       (if-let [factors (get table d)]
                         (recur (reduce #(reinsert %1 d %2) (dissoc table d) factors)
                                (inc d))
                         (lazy-seq (cons d (primes-step (assoc table (* d d) (list d))
                                                        (inc d))))))]
    (primes-step {} 2)))

(defn hash-word [word]
  (let [prime-map (zipmap
                   (map char (range 97 123))
                   (take 26 (gen-primes)))]
    (as-> (str/replace word #"[^\w]" "") w
          (replace prime-map w)
          (apply * w))))

(defn anagram? [w1 w2]
  "are two words anagrams?
  Using FTA runs faster than sorted collections, frequencies or sets,
  but does involve generating prime numbers. There's a little issue
  here with re-generating primes for w1... I've just decided it's ok as is
  and won't fix."
  (let [w1 (str/lower-case w1)
        w2 (str/lower-case w2)]
    (and (not= w1 w2)
         (= (hash-word w1) (hash-word w2)))))

(defn anagrams-for [word prospect-list]
  (filter #(anagram? word %) prospect-list))
