(ns isbn-verifier (:require [clojure.string :as str]))

(defn mod11 [n]
  (mod n 11))

(defn isbn? [isbn]
  (boolean (some->> (str/replace isbn "-" "")
                    (re-matches #"\d{9}[\dX]")
                    (map #(if (= \X %) 10 (Character/digit % 10)))
                    (map * (range 10 0 -1))
                    (reduce +)
                    (mod11)
                    (zero?))))

; (defn numeric? [s]
;   (if-let [s (seq s)]
;     (let [s (if (= (first s) \-) (next s) s)
;           s (drop-while #(Character/isDigit %) s)
;           s (if (= (first s) \.) (next s) s)
;           s (drop-while #(Character/isDigit %) s)]
;       (empty? s))))
;
; (defn proper-format? [str-seq]
;   (let [all-but-last (butlast str-seq)
;         last-str (last str-seq)
;         last-is-x (= last-str "x")
;         last-is-num (not= nil (re-find  #"\d" (str last-str)))
;         non-last-str-nums (map #(numeric? %) all-but-last)
;         all-int-last-chars (not (some false? non-last-str-nums))
;         proper-len (= 10 (count str-seq))]
;     (and
;      (or last-is-num last-is-x)
;      all-int-last-chars
;      proper-len)))
;
; (defn isbn-0? [isbn]
;   (let [isbn (as-> isbn i
;                    (clojure.string/lower-case i) i
;                    (map str (seq i)) i
;                    (remove #{"-"} i))
;         proper-format (proper-format? isbn)
;         isbn (if proper-format isbn '("9"))
;         x-replaced-isbn (map #(Integer/parseInt %) (replace {"x" "10"} isbn))
;         my-range (->> isbn
;                       count
;                       range
;                       (map #(+ 1 %))
;                       reverse)
;         res (as-> (map * my-range x-replaced-isbn) i
;                   (reduce + i) i
;                   (mod i 11))]
;     (= res 0)))
