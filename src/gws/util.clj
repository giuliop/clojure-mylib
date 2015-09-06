(ns gws.util)

(defmacro name-it [exp]
  "Return the name of a symbol or a "
  [exp]
  (:name (meta (resolve exp))))

(defmacro time-func
  "Get a dict with :val and execution time :msecs of supplied exp"
  [exp]
  `(let [start# (. System nanoTime)
         val# ~exp
         end# (. System nanoTime)]
     {:msecs (/ (- end# start#) 1000000.0)
      :val val#}))

