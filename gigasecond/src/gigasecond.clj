(ns gigasecond
  (:require [clj-time.core :as t]
            [clj-time.format :as f]
            [clojure.string :as str]))

(defn from [year month day]
  (as-> (t/seconds 1000000000) d
        (t/plus (t/date-time year month day) d)
        (f/unparse (f/formatters :year-month-day) d)
        (str/split d #"-")
        (map #(Integer/parseInt %) d)))

(defn alt-from [y m d]
  (-> (java.time.LocalDateTime/of y m d 0 0)
      (.plusSeconds 1000000000)
      ((juxt #(.getYear %) #(.getMonthValue %) #(.getDayOfMonth %)))))
