(ns advanced-compilation-tests.core
  (:require [clojure.browser.repl :as repl]
            [reagent.core :as r]
            ))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(println "Hello world!")

(defn app
  []
  [:h2 "heloo"] 
  )

(defn mount-app []
  (r/render [app]
            (. js/document (getElementById "app"))))

