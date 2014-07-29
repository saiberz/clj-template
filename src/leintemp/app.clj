(ns leintemp.app
  (:require [leintemp.views.layout :as layout]
            [leintemp.views.contents :as contents]
            [ring.adapter.jetty :as jetty]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [net.cgrand.enlive-html :as html]
            [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET context ]]
            ))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})
(run-server app {:port 8080})

(defn show-landing-page [req] ;; ordinary clojure function, accepts a request map, returns a response map
  ;; return landing page's html string. Using template library is a good idea:
  ;; mustache (https://github.com/shenfeng/mustache.clj, https://github.com/fhd/clostache...)
  ;; enlive (https://github.com/cgrand/enlive)
  ;; hiccup(https://github.com/weavejester/hiccup)
  )

(defn update-userinfo [req]          ;; ordinary clojure function
  (let [user-id (-> req :params :id)    ; param from uri
        password (-> req :params :password)] ; form param
    (str "hola" "mundo")
    ))

(defroutes all-routes
  (GET "/" [] show-landing-page)
) ;; all other, return 404




(defroutes handler
  (GET "/" []
       (layout/application "Inicio" (contents/index)) )

  (GET "/mi" []
       (html))

  (context "/user/:id" [id]
           (GET "/profile" []
                (layout/application "Perfil" (contents/profile id)))
           (GET "/settings" []
                (layout/application "Settings" (contents/settings id)))))

(defn -main []
  (jetty/run-jetty #'handler
                   {:port (Integer. (or (System/getenv "PORT") "8090"))
                    :join? false}))



(def server (jetty/run-jetty #'handler {:port 8082 :join? false}))

(.start server)
(.stop server)
