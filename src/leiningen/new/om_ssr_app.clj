(ns leiningen.new.om-ssr-app
    (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files]]))

(def render (renderer "om-ssr-app"))

(defn om-ssr-app
      [name]
      (let [data {:name      name
                  :ns-name   (sanitize-ns name)
                  :sanitized (name-to-path name)}]
           (->files data
                    ["project.clj" (render "project.clj" data)]
                    [".gitignore" (render ".gitignore" data)]
                    ["Procfile" (render "Procfile" data)]
                    ["src/app/{{sanitized}}/app/state.cljs" (render "state.cljs" data)]
                    ["src/app/{{sanitized}}/app/routes.cljs" (render "routes.cljs" data)]
                    ["src/server/{{sanitized}}/server/core.cljs" (render "core.cljs" data)]
                    ["src/app/{{sanitized}}/app/util.cljs" (render "util.cljs" data)]
                    ["src/app/{{sanitized}}/app/main.cljs" (render "main.cljs" data)]
                    ["src/app/{{sanitized}}/app/page.cljs" (render "page.cljs" data)]
                    ["src/app/{{sanitized}}/app/service.cljs" (render "service.cljs" data)]
                    ["resources/include.js" (render "include.js")]
                    ["src/less/styles.less" (render "styles.less")]
                    ["resources/public/css/styles.css" (render "styles.css")]
                    ["resources/index.html" (render "index.html" data)]
                    )))
