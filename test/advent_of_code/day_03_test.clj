(ns advent-of-code.day-03-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day-03 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]))

(deftest part1
  (let [expected 294]
    (is (= expected (part-1 (slurp (resource "day-03.txt")))))))

(deftest part2
  (let [expected 5774564250]
    (is (= expected (part-2 (slurp (resource "day-03.txt")))))))
