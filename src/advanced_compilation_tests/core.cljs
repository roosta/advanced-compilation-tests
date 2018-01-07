(ns advanced-compilation-tests.core
  (:require [clojure.browser.repl :as repl]
            [reagent.core :as r]
            ))


(set! *warn-on-infer* true)

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(def js-object ^js/Object (clj->js {:foo "foo-value"
                         :fiz "fiz-value"
                         :baz {:qux "qux-value"}}))

(defn app
  []
  [:div
   [:h5 (str "(.. js/window -Document -name) -> " (pr-str (.. js/window -Document -name)))]
   [:h5 (str "(.. js-object -baz -qux) -> " (pr-str (.. js-object -baz -qux)))]
   [:h5 (str "(.-foo js-object) -> " (pr-str (.-foo js-object)))]
   [:h5 (str "(set! (.. js-object -baz -qux) \"new-qux-value\") -> " (do 
                                                                    (set! (.. js-object -baz -qux) "new-qux-value")
                                                                    (pr-str (.. js-object -baz -qux))))]
   [:div (pr-str js-object)]
   ]) 

(defn mount-app []
  (r/render [app] (.getElementById js/document "app")))

(mount-app)
