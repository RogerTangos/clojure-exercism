(ns robot-name)

(def robot-map (atom {}))

(defn rand-robot-name []
  (let [A #(char (+ (rand 26) 65))
        D #(rand-int 9)]
    (apply str ((juxt A A D D D)))))

(defn robot []
  ; new-robot-index: increment of the max key in robot-map atom
  ; swap the robot map with an updated version
  ; return the robot index
  (let [new-robot-index (->> (keys @robot-map)
                             ((fnil identity '(-1)))
                             (apply max)
                             (inc))]
    (swap! robot-map #(assoc % new-robot-index (rand-robot-name)))
    new-robot-index))

(defn robot-name [r]
  (@robot-map r))

(defn reset-name [r]
  (swap! robot-map #(assoc % r (rand-robot-name)))
  r)
