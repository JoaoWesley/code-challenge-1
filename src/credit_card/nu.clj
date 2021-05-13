(ns credit_card.nu)

(require '[clj-time.core :as t])

(def category {:restaurant "RESTAURANT" :services "SERVICES" :supermarket "SUPERMARKET", :others "OTHERS"})

(def client1 {:id :1 :name "somename" :cpf "467.080.150-30" :email "someemail@gmail.com"})
(def client2 {:id :2 :name "someothername" :cpf "572.080.150-30" :email "someotheremail@gmail.com"})

(def credit-card1 {:id 1 :number 5200994615553840 :cvv 430 :expiration-date "11/07/2022" :limit 1000})
(def credit-card2 {:id 2 :number 5311994615553840 :cvv 430 :expiration-date "11/07/2022" :limit 1000})

(def purchase1 {:client-id (:id client1)
                :credit-card-id (:id credit-card1)
                :date (t/date-time 2021 7 11)
                :amount 100
                :establishment "Establishment1"
                :category (category :restaurant)
                })
(def purchase2 {
                :client-id (:id client1)
                :credit-card-id (:id credit-card1)
                :date (t/date-time 2021 7 11)
                :amount 100
                :establishment "Establishment1"
                :category (category :services)
                })
(def purchase3 {
                :client-id (:id client2)
                :credit-card-id (:id credit-card2)
                :date (t/date-time 2021 8 11)
                :amount 100
                :establishment "Establishment2"
                :category (category :supermarket)
                })
(def purchase4 {
                :client-id (:id client2)
                :credit-card-id (:id credit-card2)
                :date (t/date-time 2021 8 11)
                :amount 100
                :establishment "Establishment2"
                :category (category :others)
                })

(def purchase-list [purchase1 purchase2 purchase3 purchase4])