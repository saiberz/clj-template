(ns cljtemplate.app
  (:require [cljtemplate.views.layout :as layout]
            [cljtemplate.views.contents :as contents]
            [ring.adapter.jetty :as jetty]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [net.cgrand.enlive-html :as html]
            [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET context ]]))


(defroutes handler
  (GET "/" []
       (layout/application "Inicio" (contents/home)) )

  (context "/user/:id" [id]
           (GET "/profile" []
                (layout/application "Profile" (contents/profile id)))
           (GET "/settings" []
                (layout/application "Settings" (contents/settings id)))))

(defn -main []
  (jetty/run-jetty #'handler
                   {:port (Integer. (or (System/getenv "PORT") "8080"))
                    :join? false}))


(def server (jetty/run-jetty #'handler {:port 8080 :join? false}))

(.start server)
(.stop server)
