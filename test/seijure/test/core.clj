(ns seijure.test.core
 (:use [seijure.core])
 (:use [clojure.test]))

(deftest simple-link
 (is "a {color:blue;}" (css [:a [:color "blue"]])))

(deftest link-with-class
 (is "a .clj {color:blue;}" (css [:a :.clj [:color "blue"]])))