(ns gws.repl)

(defn classpath
  "Get the classpath as a list of java.net.URL objects"
  []
  (seq (.getURLs (java.lang.ClassLoader/getSystemClassLoader))))

(defn print-classpath []
  (doseq [x (classpath)] (println (. x getPath))))
