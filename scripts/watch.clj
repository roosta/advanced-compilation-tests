(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'advanced-compilation-tests.core
   :output-to "out/advanced_compilation_tests.js"
   :output-dir "out"})
