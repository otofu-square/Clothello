(ns clothello.core
  (:use
   clothello.view
   clothello.model))

(defn on-command
  [cmdline]
  (let [cmd (first cmdline)
        pos (second cmdline)]
    (cond
      (= cmd :move) (play-move pos)
      (= cmd :exit) (System/exit 0)
      :else nil)))

(defn -main
  [& args]
  (init-view on-command)
  (init-game on-state-changed)
  (start-ui))
