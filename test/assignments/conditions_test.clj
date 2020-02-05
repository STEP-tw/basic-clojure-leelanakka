(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
           (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
           (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
           (is (= 5 (informative-divide 10 2))))
  (testing "zero denominator"
           (is (= :infinite? (informative-divide 2 0)))))

(deftest harishchandra-test
  (testing "truthy values to return themselves"
           (is (= 2 (harishchandra 2))))
  (testing "falsy values to return nil"
           (is (nil? (harishchandra false)))
           (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "truthy values to return themselves"
           (is (= 2 (yudishtira 2))))
  (testing "falsy values to return nil"
           (is (= :ashwathama (yudishtira false)))
           (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-test
  (testing "non empty coll"
           (is (= [1 1 2] (duplicate-first [1 2]))))
  (testing "empty coll"
           (is (= nil (duplicate-first []))))
  (testing "list with first as nil"
           (is (= [nil nil 1 2] (duplicate-first [nil 1 2])))))

(deftest five-point-someone-test
  (testing "return :chetan-bhagat"
           (is (= :chetan-bhagat (five-point-someone 4 5))))
  (testing "return :satan-bhagat"
           (is (= :satan-bhagat (five-point-someone 5 9))))
  (testing "return :greece"
           (is (= :greece (five-point-someone 6 4))))
  (testing "return :universe"
           (is (= :universe (five-point-someone 8 8)))))

(deftest repeat-and-truncate-test
  (testing "for false repeat and false truncate"
           (is (= [2 3] (repeat-and-truncate [2 3] false false 4))))
  (testing "should truncate only for repeat"
           (is (= [2 3 2 3] (repeat-and-truncate [2 3] true false 4))))
  (testing "should not repeat but should truncate"
           (is (= [1 2 3] (repeat-and-truncate [1 2 3 4 5] false true 3))))
  (testing "should repeat and truncate together"
           (is (= [1 2 3 1 2] (repeat-and-truncate [1 2 3] true true 5)))))

(deftest order-in-words-test
  (testing "for x > y and y > z"
           (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "for x > y and z > x "
           (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "for z > x"
           (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest zero-aliases-test
  (testing "zero 0"
           (is (= :zero (zero-aliases 0))))
  (testing "empty vector"
           (is (= :empty (zero-aliases []))))
  (testing "empty list"
           (is (= :empty (zero-aliases '()))))
  (testing "empty set"
           (is (= :empty-set (zero-aliases #{}))))
  (testing "empty string"
           (is (= :empty-string (zero-aliases ""))))
  (testing "not empty"
           (is (= :non-zero (zero-aliases 1)))))

(deftest zero-separated-palindrome-test
  (testing "empty collection"
           (is (= [0] (zero-separated-palindrome []))))
  (testing "non-empty collection"
           (is (= [4 3 2 0 2 3 4] (zero-separated-palindrome [1 2 3])))))

(deftest conditions-apply-test
  (testing "collection has a single occurrence of 1 and 3 in that order"
    (is (= :wonder-woman (conditions-apply [0 1 0 3]))))
  (testing "collection has a single occurrence of :a :b and :c in that order"
    (is (= :durga (conditions-apply [:a :b :e :c]))))
  (testing "collection has a single occurrence of [2 3] and [4 5] in that order"
    (is (= :cleopatra (conditions-apply [[0 0] [2 3] [1 1] [4 5] [5 6]]))))
  (testing "none of the conditions apply"
    (is (= :tuntun (conditions-apply [7 8 9]))))
  (testing "collection has two occurrence of 1 and 3 in that order"
    (is (= :tuntun (conditions-apply [0 1 3 1 3])))))
