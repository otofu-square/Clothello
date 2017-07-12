(ns clothello.view
  (:use
   clothello.model
   [clojure.string :only (join)]))

(def col-headers
  (take b-size
        (map (comp str char)
             (range code-a code-z))))

(def col-headers-str
  (str "  " (join " " col-headers)))

(defn- st-str
  [st]
  (condp = st
    :b "x"
    :w "o"
    " "))

(defn- board-strs
  [brd]
  (for [row (partition b-size brd)]
    (join " " (map st-str row))))

(defn- board-strs-with-row
  [brd]
  (map str
       (range (inc first-row) (inc last-row))
       (repeat b-size " ")
       (board-strs brd)))
