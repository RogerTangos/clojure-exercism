(ns nucleotide-count)

; (defn count-substring [sub txt]
;   (count (re-seq (re-pattern (str sub)) txt)))

; (defn nucleotide-counts [strand]
;   (into {} (for [k [\A \T \C \G]]
;              [k (count-substring k strand)])))

(defn nucleotide-counts [strand]
  (merge {\A 0 \T 0 \C 0 \G 0} (frequencies strand)))

(defn count-of-nucleotide-in-strand [nucleotide strand]
  {:pre [((set "ATCG") nucleotide)]}
  ((nucleotide-counts strand) nucleotide))
