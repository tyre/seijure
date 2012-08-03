(ns seijure.core)
(defn as-str
 ([] "")
 ([x] (if (instance? clojure.lang.Named x)
  (name x)
  (str x)))
 ([x & ys]
  ((fn [#^StringBuilder sb more]
   (if more
    (recur (. sb  (append (as-str (first more)))) (next more))
    (str sb)))
  (new StringBuilder #^String (as-str x)) ys)))

(defn props-to-str [properties]
 (def compiled "{")
 (loop [properties properties]
  (let [ current (first properties)
   prop (first current) values (vec (rest current))]
   (def compiled
    (str compiled
    (as-str prop) ": " (clojure.string/join " " values) ";" ) )
   )
  (when (seq(rest properties))
   (recur (rest properties)))
  )
 (str compiled "}")
 )

(defn css [style]
 (def css-out "")
 (let [tags (vec (take-while #(keyword? %) style))
  properties (first (drop-while #(keyword? %) style))]
  (loop [tags tags]
   (def css-out (str css-out (as-str (first tags) " ")))
   (when (seq (rest tags))
    (recur (rest tags))))
  (def css-out
   (str css-out (props-to-str properties))
   )
  )
 css-out
 )