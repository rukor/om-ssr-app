# om-ssr-app

Lein template for CLJS-OM app with Server Side Rendering based on om-ssr-node

### Usage

At a shell prompt, type:

```
lein new om-ssr-app example
cd example
lein less once
lein npm install
lein cljsbuild once app server
node resources/index.js
```

Then navigate to http://localhost:3000
