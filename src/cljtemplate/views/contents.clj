(ns cljtemplate.views.contents
  (:use [hiccup.form]))

(defn home []
   [:h1 "Happy hacking saiberz!"])

(defn profile [id]
  [:h1 (str id "'s profile") ])

(defn settings [id]
  [:h1 (str id "'s settings") ])
