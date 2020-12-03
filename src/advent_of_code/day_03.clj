(ns advent-of-code.day-03
  (:require [clojure.java.io :refer [resource]]
            [clojure.string :as string]))

(def data (slurp (resource "day-03.txt")))

(defn count-trees
  ([line dx dy]
   (let [width (count (first line))
         height (count line)
         get-range (map (fn [y x] [y (mod (* x dx) width)])
                        (range 0 height dy)
                        (range))]
     (->> get-range
          (map (fn [[y x]] (nth (nth line y) x)))
          (filter #(= % \#))
          (count))))
  ([line] (count-trees line 3 1)))


(defn part-1
  "Day 03 Part 1"
  [input]
  (->> input
       (string/split-lines)
       (count-trees)))

(defn part-2
  "Day 03 Part 2"
  [input]
  (let [graph (string/split-lines input)]
    (reduce * (map (fn [dx dy] (count-trees graph dx dy))
                   [1 3 5 7 1]
                   [1 1 1 1 2]))))
