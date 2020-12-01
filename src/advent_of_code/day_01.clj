(ns advent-of-code.day-01
  (:require [clojure.java.io :refer [resource]]
            [clojure.string :as string]))

(def data (string/split-lines (slurp (resource "day-01.txt"))))

(def rd-data (map read-string data))

(defn part-1
  "Day 01 Part 1"
  [input]
  (->> (for [num1 input
           num2 input
           :when (= (apply + [num1 num2]) 2020)]
        [num1 num2])
      first
      (reduce *)))

(defn part-2
  "Day 01 Part 2"
  [input]
  (->> (for [num1 input
             num2 input
             num3 input
             :when (= (apply + [num1 num2 num3]) 2020)]
         [num1 num2 num3])
       first
       (reduce *)))
