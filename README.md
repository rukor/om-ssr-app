# om-ssr-app

Lein template for CLJS-OM app with Server Side Rendering based on om-ssr-node

### Usage

To At a shell prompt, type:

```
lein new om-ssr-app example
cd example
lein less once
lein npm install
lein cljsbuild once app server
node resources/index.js
```

Then navigate to http://localhost:3000

To deploy to heroku, type:

```
lein npm pprint | tail -n +3 > tmp && mv tmp package.json # generate the package.json. for some reason it needs the temporary file
lein with-profile prod cljsbuild once app server
```

The app is then ready to deploy to heroku via git push per heroku's instructions. Note that the same applies for other heroku style PaaS like deis and flynn.