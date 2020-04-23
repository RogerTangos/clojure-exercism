(ns rna-transcription)

(defn to-rna [dna]
  {:pre [(nil? (re-find #"[^GCTA]" dna))]}
  (let [replacement (clojure.string/replace dna #"G|C|T|A" {"G" "C"
                                                            "C" "G"
                                                            "T" "A"
                                                            "A" "U"})]
    replacement))
