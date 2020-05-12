(ns space-age)

(defn on-earth [secs] (/ secs 31557600))

(defn on-mercury [secs] (/ (on-earth secs) 0.2408467))

(defn on-venus [secs] (/ (on-earth secs) 0.61519726))

(defn on-mars [secs] (/ (on-earth secs) 1.8808158))

(defn on-jupiter [secs] (/ (on-earth secs)  11.862615))

(defn on-saturn [secs] (/ (on-earth secs) 29.447498))

(defn on-neptune [secs] (/ (on-earth secs) 164.79132))

(defn on-uranus [secs] (/ (on-earth secs) 84.016846))
