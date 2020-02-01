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
    (is (= nil (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "return :chetan-bhagat"
    (is (= :chetan-bhagat (five-point-someone 4 5))))
  (testing "return :satan-bhagat"
    (is (= :satan-bhagat (five-point-someone 5 9))))
  (testing "return :greece"
    (is (= :greece (five-point-someone 6 4))))
  (testing "return :universe"
    (is (= :universe (five-point-someone 8 8)))))
