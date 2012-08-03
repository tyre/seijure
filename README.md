# Seijure - Clojure to CSS
## Because why the fuck not?

### Goals

A Clojure wrapper to CSS.

CSS is composed of lists of tags/classes/IDs with nested attributes and values (e.g. `color: red;`). Being Turing-complete, Clojure allows all sorts of nicities for complex calculations (with hex or angles, for example.)

### Syntax

Seijure syntax mimics that of css, composed of simple vectors and maps. For examples (copied and pasted text):

```clojure

(deftest simple-tag
 (is (= "a {color: blue;}" (css [:a [[:color "blue"]]]))))

(deftest tag-with-class
 (is (= "a .clj {color: blue;}" (css [:a :.clj [[:color "blue"]]]))))

(deftest multiple-property-values
 (is (= "a {padding: 1em 2em;}" (css [:a [[:padding "1em" "2em"]]]))))

(deftest multiple-properties
 (is (= "a {padding: 1em;display: none;}" (css [:a [[:padding "1em"][:display "none"]]]))))

```

**Seijure. It hurts to think about.**


Thank you to the #clojure IRC for all of their help, especially dnolan and amalloy

