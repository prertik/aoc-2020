(ns advent-of-code.day-01-test
  (:require [clojure.test :refer [deftest testing is]]
            [advent-of-code.day-01 :refer [part-1 part-2]]
            [clojure.java.io :refer [resource]]
            [clojure.string :as string]))

(defn obtain-format
  [file]
  (map read-string (string/split-lines (slurp (resource file)))))

(deftest part1
  (let [expected 1018944]
    (is (= expected (part-1 (obtain-format "day-01.txt"))))))

(deftest part2
  (let [expected 8446464]
    (is (= expected (part-2 (obtain-format "day-01.txt"))))))
