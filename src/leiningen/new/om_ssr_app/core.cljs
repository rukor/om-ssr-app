(ns {{ns-name}}.server.core
  (:require [cljs.nodejs :as node]
            [com.firstlinq.om-ssr.server :as server]
            [com.firstlinq.om-ssr.router.silk :refer [create-request->state silk-router]]
            [com.firstlinq.om-ssr.util :refer [make-om-renderer]]
            [{{ns-name}}.app.page :as app]
            [{{ns-name}}.app.routes :refer [app-routes]]))

(node/enable-util-print!)

(defn -main []
  (let [env-docroot (-> node/process .-env .-DOCROOT)       ; read docroot from env
        env-port    (-> node/process .-env .-PORT)
        docroot     (if (nil? env-docroot) "resources/public" env-docroot)
        port        (if (nil? env-port) "3000" env-port)]
    (server/start :docroot docroot
                  :port port
                  :template-file "resources/index.html"
                  :renderer (make-om-renderer app/main-app (silk-router app-routes))
                  :request->state (create-request->state app-routes))))

(set! *main-cli-fn* -main)
