(ns cljtemplate.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]
        [hiccup.core]))

(defn show [title newcontent]
  (html5 {:ng-app "My Template" :lang "en"}
          [:head
           [:title title]
           (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
           (include-js "js/script.js")
           [:body
            newcontent]]))

(defn application [title & content]
  (show title content))

