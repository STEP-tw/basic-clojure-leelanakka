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

