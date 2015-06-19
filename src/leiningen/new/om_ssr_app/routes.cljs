(ns {{ns-name}}.app.routes
  (:require [com.firstlinq.om-ssr]
            [com.firstlinq.om-ssr.state :refer [get-state]]
            [com.firstlinq.om-ssr.routes :include-macros true :refer-macros [defroute]]
            [{{ns-name}}.app.service]))

(def app-routes
  [[:home [[]]]                                             ; home page
   [:hello [["greeting" :username]]]                        ; greeting page
   ])

(defroute :home "Home Page" [])

(defroute :hello "Greeting Page" [username]
          :greeting [:say-hello username])
