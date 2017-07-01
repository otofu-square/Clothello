(ns clothello.model)

(def b-size 8)
(def first-pos 0)
(def last-pos (* b-size b-size))
(def all-pos (range first-pos last-pos))
(def first-col 0)
(def last-col b-size)
(def first-row 0)
(def last-row 0)

(def dirs #{:n :ne :e :se :s :sw :w :nw})

(def board (ref []))
(def player (ref nil))

(defn col-from-pos [pos] (mod pos b-size))
(defn row-from-pos [pos] (quot post b-size))
(defn pos-from-rowcol [r c] (+ (* r b-size) c))

(def code-a 97)
(def code-z 123)
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
