(ns {{ns-name}}.app.main
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs.core.async :refer [<!]]
            [{{ns-name}}.app.state :refer [app-state]]
            [{{ns-name}}.app.page :refer [main-app]]
            [{{ns-name}}.app.routes :refer [app-routes]]
            [{{ns-name}}.app.util :refer [by-id]]
            [com.firstlinq.om-ssr :refer [redirect-key]]
            [com.firstlinq.om-ssr.api :refer [create-service]]
            [com.firstlinq.om-ssr.log :as log :include-macros true]
            [com.firstlinq.om-ssr.state :refer [get-state hydrate transit-serialiser]]
            [com.firstlinq.om-ssr.routes :refer [create-route-handler]]
            [com.firstlinq.om-ssr.router.silk :refer [silk-router]]
            ))
(defn start
  "Entry point for application"
  []
  (enable-console-print!)
  (log/info "Starting application")
  (let [handler    (create-route-handler app-state)
        service    (create-service app-state)
        router     (silk-router app-routes handler)
        serialiser (transit-serialiser)]
    (hydrate serialiser app-state (by-id "app-state"))
    (om/root main-app app-state
             {:target (by-id "app")
              :opts   {:service service
                       :router  router}})))
