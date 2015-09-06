(ns gws.util)

(defmacro time-it-with-value
  "Get a dict with :val and execution time :msecs of supplied exp"
  [exp]
  `(let [start# (. System nanoTime)
         val# ~exp
         end# (. System nanoTime)]
     {:msecs (/ (- end# start#) 1000000.0)
      :val val#}))

(defmacro time-it
  "Get execution time in msecs of supplied exp"
  [exp]
  (:msecs (time-it-with-value exp)))

(defn delta [n1 n2]
  (* 100 (- (/ n1 n2) 1)))

(defmacro compare-times
  "Compare execution times of two expressions"
  [e1 e2]
  `(let [t1# (time-it ~e1)
         t2# (time-it ~e2)]
     (if (< t1# t2#)
       (str '~e1 " is " (format "%.2f" (* -1 (delta t1# t2#))) "% faster than " '~e2)
       (str '~e2 " is " (format "%.2f" (* -1 (delta t2# t1#))) "% faster than " '~e1))))
