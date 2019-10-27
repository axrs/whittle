(ns io.axrs.cli-tools.whittle-test
  (:require
    [clojure.test :refer :all]
    [io.axrs.cli-tools.whittle :as whittle]))

(def assoc-some #'whittle/assoc-some)

(deftest assoc-some-test

  (testing "assoc-some"

    (testing "no key/vals"
      (is (= {} (assoc-some {})))
      (is (= {} (apply assoc-some {} []))))

    (testing "single key/value"
      (is (= {} (assoc-some {} :a nil)))
      (is (= {:a 1} (assoc-some {} :a 1)))
      (is (= {:b 2} (assoc-some {:b 2} :a nil))))

    (testing "multiple key/values"
      (is (= {:a 1 :c 3 :e 5}
             (assoc-some {:a 1}
               :b nil
               :c 3
               :d nil
               :e 5))))))
