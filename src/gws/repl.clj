(ns gws.repl)

(defn classpath
  "Get the classpath as a list of java.net.URL objects"
  []
  (seq (.getURLs (java.lang.ClassLoader/getSystemClassLoader))))

(defn print-classpath []
  (doseq [x (classpath)] (println (. x getPath))))

(defn reset-ns
  ([]
   (reset-ns *ns*))
  ([_ns]
   (in-ns 'user)
   (remove-ns _ns)
   (require _ns :reload)
   (in-ns _ns)))

