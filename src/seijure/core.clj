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

(defn css [style]
 (def css-out "")
  (let [tags (vec (take-while #(keyword? %) style))
        pretties (drop-while #(keyword? %) style)]
  (loop [tags tags]
       (def css-out (str css-out (as-str (first tags)" ")))
      (when (seq (rest tags))
        (recur (rest tags))))
  (for [[property values] pretties]
      (def css-out (str css-out "{" (as-str property) ":" values ";}")))
  )
  css-out
)