(ns fprog.core
  (:require [esthatic.core :as es]))

(defn menu [{data :data}]
  [:div
   [:$style
    [:nav.navbar
     [:.navbar-brand
      {:background [:$c :black]
       :display "inline-block"
       :color [:$c :white]
       :font-size [:$v 3]
       :padding {:top [:$v 5] :bottom 0 :left 0 :right 0}}]
     [:a {:color [:$c :light-gray]
          :font-size [:$v 1.5]
          :margin-left [:$v 2]
          :border-top [:$border 4 :transparent]
          :line-height [:$v 2]}
      [:&:hover {:background-color "transparent"
                 :color "white" 
                 :border-top [:$border :orange]}]]]]
   [:$nav
    (get-in data [:texts :brand])
    (for [it (:nav data)]
      [:$nav-item {:href "#"} (:title it)])]])

(defn layout [{data :data :as opts} cnt]
  [:html
   [:head
    [:$cdn-css :bootsrtrap]
    [:$google-font :Exo-2]
    [:$style
     [:body {:padding 0 
             :background-color  [:$c :dark-gray]
             :color "white"
             :font-family "'Exo 2'"}]]]
   [:body
    (menu opts)
    cnt]])

(defn index [{data :data :as opts}]
  [:.container
   [:$style
    [:.moto
     {:position "fixed"
      :text-align "center"
      :color [:$c :white]
      :font-size [:$v 2]
      :border-top [:$border 1 :light-gray]
      :bottom 0
      :left 0
      :right 0
      :background [:$c :black]
      :opacity 0.5
      :padding [:$v 1]}]]
   [:$br]
   [:$svg "logo"]
   [:$br]
   [:.moto "Благородное собрание функциональных программистов"]
   ])

(def routes
  {:GET #'index})

(def styles
  {:$v 18
   :$c {:red "red"
        :white "white"
        :dark-gray "rgba(46,48,58,0.96)"
        :light-gray "#ccc"
        :orange "#D56530"
        :gray "#777"
        :black "black"
        :transparent "transparent"
        :blue "#42A3EE"}})


(comment
  (def stop (es/start {:routes #'routes
                       :styles #'styles
                       :layout #'layout}))
  (stop))

