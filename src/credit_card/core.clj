(ns credit-card.core)

(require '[clj-time.core :as t])
(require '[credit_card.db :as n.db])

(defn filter-purchase-by-category [purchases, category]
  (-> (fn [purchase] (= category (:category purchase)))
       (filter purchases)
       ))

(defn get-purchase-price [purchase]
  (:amount purchase))

(defn print-purchase-total-by-category [purchases]
  (println "RESTAURANT")
  (->> (n.db/category :restaurant)
       (filter-purchase-by-category purchases)
       (map get-purchase-price )
       (reduce +)
       (println ))

  (println "SERVICES")
  (->> (n.db/category :services)
       (filter-purchase-by-category purchases)
       (map get-purchase-price )
       (reduce +)
       (println ))

  (println "SUPERMARKET")
  (->> (n.db/category :supermarket)
       (filter-purchase-by-category purchases)
       (map get-purchase-price )
       (reduce +)
       (println ))

  (println "OTHERS")
  (->> (n.db/category :others)
       (filter-purchase-by-category purchases)
       (map get-purchase-price )
       (reduce +)
       (println ))
  )

(println "SUM BY CATEGORY:")
(print-purchase-total-by-category n.db/purchase-list)
(println "\n")

(defn filter-purchase-by-month [purchases month]
  (->
    (fn [purchase] (= (t/month (:date purchase)) month))
    (filter purchases)
    )
  )

(println "MONTHLY BILLED:")
( println "JULY")
(->> (filter-purchase-by-month n.db/purchase-list 7)
     (map get-purchase-price)
     (reduce +)
     (println ))
( println "AUGUST")
(->> (filter-purchase-by-month n.db/purchase-list 8)
     (map get-purchase-price)
     (reduce +)
     (println)
     )
(println "\n")

(defn filter-purchase-by-establishment [purchases establishment]
  (-> (fn [purchase] (= (:establishment purchase) establishment))
      (filter purchases)
      )
  )

(println "SEARCH BY ESTABLISHMENT:")
(println "ESTABLISHMENT 1")
(println (filter-purchase-by-establishment n.db/purchase-list "Establishment1"))
(println "ESTABLISHMENT 2")
(println (filter-purchase-by-establishment n.db/purchase-list "Establishment2"))
(println "\n")

(defn filter-purchase-by-amount [purchases amount]
  (filter (fn [purchase] (= (:amount purchase) amount)) purchases))

(println "SEARCH BY AMOUNT:")
(println "AMOUNT = 100")
(println (filter-purchase-by-amount n.db/purchase-list 100))