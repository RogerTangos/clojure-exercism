(ns bob)

(defn response-for [s]
  (let [s (clojure.string/trim s)
        alpha-str (apply str (re-seq #"[a-zA-Z\?\!\.]" s))
        chars-alpha (map #(str %) (seq (str alpha-str)))

        last-char (last chars-alpha)
        question (= last-char "?")
        blank (= s "")

        yelling (->>
                 (clojure.string/upper-case alpha-str)
                 (= alpha-str))
        yelling (and yelling
                     (not= "" alpha-str)
                     (not= "" (apply str (re-seq #"[a-zA-Z]" s))))]
    last-char
    (cond
      blank "Fine. Be that way!"
      (and yelling question) "Calm down, I know what I'm doing!"
      yelling "Whoa, chill out!"
      question "Sure."
      :else "Whatever.")))
