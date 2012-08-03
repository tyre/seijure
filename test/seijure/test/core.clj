(ns seijure.test.core
 (:use [seijure.core])
 (:use [clojure.test]))

(deftest simple-tag
 (is (= "a {color: blue;}" (css [:a [:color "blue"]]))))

(deftest tag-with-class
 (is (= "a .clj {color: blue;}" (css [:a :.clj [:color "blue"]]))))

(deftest multiple-property-values
 (is (= "a {padding: 1em 2em;}" (css [:a [:padding "1em" "2em"]]))))