(ns css)
(use '[clojure.string :only (join)])
(use '[clojure.contrib.string :only (as-str)])

(defmacro unless [condition & body]
  `(when (not ~condition)
   ~@body))


(defn css [vec]
  (def element (first vec))
  (def attributes (second vec))
  (print (str (as-str element) "{ "))
  (doseq [[property values] attributes] ;css properties can take multiple space delimited values
    (print
      (str (as-str property) ":" values ";")))
  (print "}")
)

(css
  [:a {:color "blue"}]) ; => a { color: blue;}

(css
  [:a {:color "blue", :.clj {:font-weight "bold"}}]) ; => a { color: blue;}
                                                  ; => a .clj { font-weight: bold;}