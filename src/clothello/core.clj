(ns clothello.core
  (:use
   clothello.view
   clothello.model
   [clojure.core.match :refer [match]]))

(defn on-command
  [cmdline]
  (let [cmd (first cmdline)
        pos (second cmdline)]
    (condp = cmd
      :move (play-move pos)
      :exit (System/exit 0)
      nil)))

(defn -main
  [& args]
  (init-view on-command)
  (init-game on-state-changed)
  (start-ui))
