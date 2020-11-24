(ns clickbait.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(println "Hello world!")

(defn counting-component [state]
  [:div
   "The atom " [:code "click-count"] " has value: "
   @state ". "
   [:input {:type     "button" :value "Click me!"
            :on-click #(swap! state inc)}]])

(defn ^:export run [parent]
  (let [state (r/atom 0)]
    (rdom/render [counting-component state] parent)))

(run (js/document.getElementById "c1"))
(run (js/document.getElementById "c2"))