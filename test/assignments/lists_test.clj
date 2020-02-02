(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))))

(deftest filter-test
  (testing "even?"
           (is (= [1 3 3] (filter' odd? [1 2 3 4 6 3]))))
  (testing "odd?"
           (is (=  [2 4] (filter' even? [1 2 3 4])))))

(deftest count-test
  (testing "with empty list"
           (is (zero? (count' []))))
  (testing "with integer elements in list"
           (is (= 5 (count' [42 21 90 20 65]))))
  (testing "list containing multiple data types"
           (is (= 5 (count' [1 \a "string" [1 2] {:foo :bar}])))))

(deftest reverse-test
  (testing "with empty list"
           (is (= () (reverse' []))))
  (testing "with elements in list"
           (is (= '(3 2 1) (reverse' [1 2 3]))))
  (testing "with string"
           (is (= '(\e \r \u \j \o \l \c) (reverse' "clojure"))))
  (testing "with non-seqable"
           (is (nil? (reverse' true)))))

(deftest every?-test
  (testing "with empty list"
           (is (true? (every?' odd? []))))
  (testing "odd? with odd value"
           (is (true? (every?' odd? [1 3 5]))))
  (testing "odd? with one even value in list"
           (is (false? (every?' odd? [1 2 3])))))

(deftest some?-test
  (testing "with empty list"
           (is (nil? (some?' odd? []))))
  (testing "odd? with odd value"
           (is (true? (some?' odd? [1 3 5]))))
  (testing "odd? with one even value in list"
           (is (true? (some?' odd? [1 2 3]))))
  (testing "even? with no even values in list"
           (is (nil? (some?' even? [1 3 5])))))

(deftest ascending?-test
  (testing "with correct sequence"
           (is (true? (ascending? [1 2 3]))))
  (testing "with wrong sequence"
           (is (false? (ascending? [1 4 3])))))

(deftest transpose-test
  (testing "with empty sequence"
           (is (= [] (transpose [[] []]))))
  (testing "with 2 rows"
           (is (= [[1 4] [2 5] [3 6]] (transpose [[1 2 3] [4 5 6]])))))

(deftest cross-product-test
  (testing "with empty sequence"
           (is (= [] (cross-product [] []))))
  (testing "with 2 sequences"
           (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]]
                  (cross-product [1 2 3] [4 3 5])))))

(deftest double-up-test
  (testing "with empty sequence"
           (is (= [] (double-up []))))
  (testing "with integer sequence"
           (is (= [1 1 2 2 3 3] (double-up [1 2 3]))))
  (testing "with string sequence"
           (is (= ["I" "I" "love" "love" "clojure" "clojure"]
                  (double-up ["I" "love" "clojure"])))))

(deftest third-or-fifth-test
  (testing "with single item"
           (is (= [] (third-or-fifth ["I"]))))
  (testing "with collection containing 4 items - last index is 3"
           (is (= [4] (third-or-fifth [1 2 3 4]))))
  (testing "with collection containing 6 items - last index is 5"
           (is (= [4 6] (third-or-fifth [1 2 3 4 5 6])))))

(deftest sum-of-adjacent-digits-test
  (testing "with empty collection and single collection"
           (are [x y] (= x y)
                [] (sum-of-adjacent-digits [])
                [] (sum-of-adjacent-digits [1])))
  (testing "with collection containing more than single element"
           (is (= [1 4 3] (sum-of-adjacent-digits [0 1 3 0])))))

(deftest difference-test
  (testing "with empty collection"
           (is (= [] (difference [] []))))
  (testing "with 2nd collection that are present is 1st collection"
           (is (= [] (difference [1 2 3] [2 3]))))
  (testing "with 2nd collection having elements after difference"
           (is (= [4] (difference [1 2 3] [2 3 4])))))


