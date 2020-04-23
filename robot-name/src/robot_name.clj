(ns robot-name)

(def robot-map (ref {}))

(defn rand-robot-name []
  (let [A #(char (+ (rand 26) 65))
        D #(rand-int 9)]
    (apply str ((juxt A A D D D)))))

(defn new-robot-index [source]
  "look at the provided source and increment a key.
   If no keys are present, start with 0"
  (->> (keys source)
       ((fnil identity '(-1)))
       (apply max)
       (inc)))

(defn robot []
  (dosync
   (let [new-index (new-robot-index @robot-map)]
     (alter robot-map #(assoc % new-index (rand-robot-name)))
     new-index)))

(defn robot-name [r]
  (@robot-map r))

(defn reset-name [r]
  (dosync (alter robot-map #(assoc % r (rand-robot-name))))
  r)
