(set-env!
  :resource-paths #{"src"}
  :dependencies '[
                  [hoplon/boot-hoplon                       "0.1.13"            :scope "test"]
                  [adzerk/boot-cljs                         "1.7.170-3"         :scope "test"]
                  [adzerk/env                               "0.2.0"]
                  [adzerk/cljs-console                      "0.1.1"]])

(require
  '[adzerk.env               :as    env]
  '[adzerk.boot-cljs         :refer [cljs]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]])


(task-options!
  pom    {:project 'coci/coci-prismic-api
          :version "0.1.8"
          :description "prismic api for chabad on campus content projects"}
  push   {:repository "clojars-upload"}
  hoplon {:manifest true})

(deftask build-jar
 "build the jar"
 []
 (comp
   (hoplon)
   (pom)
   (jar)))

(deftask install-jar
  "install the jar"
  []
  (comp
    (build-jar)
    (install)))
