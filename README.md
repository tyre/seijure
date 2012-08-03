# Seijure - Clojure to CSS
## Because why the fuck not?

### Goals

A Clojure wrapper to CSS.

CSS is composed of lists of tags/classes/IDs with nested attributes and values (e.g. `color: red;`). Being Turing-complete, Clojure allows all sorts of nicities for complex calculations (with hex or angles, for example.)

### Syntax

Seijure syntax mimics that of css, composed of simple vectors and maps. For example:

`(css[:a {:color "blue"}])` compiles to `a { color: blue; }`

**Seijure. It hurts to think about.**


Thank you to the #clojure IRC for all of their help, especially dnolan and amalloy

