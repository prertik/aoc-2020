(ns advent-of-code.day-02
  (:require [clojure.java.io :refer [resource]]
            [clojure.string :as string]))

(def data (slurp (resource "day-02.txt")))

(defn is-valid? [line]
  (let [[num c pass] (string/split line #" ")
        [min max] (map #(Integer/parseInt %) (string/split num #"-"))]
    (<= min (get (frequencies pass) (first c) 0) max)))

(defn part-1
  "Day 02 Part 1"
  [input]
  (->> input
       (string/split-lines)
       (filter is-valid?)
       count))

(defn pos-char [s idx]
  (when (< idx (count s)) (.charAt s idx)))

(defn is-it-valid? [line]
  (let [[num c pass] (string/split line #" ")
        [idx1 idx2] (map #(Integer/parseInt %) (string/split num #"-"))
        c1 (pos-char pass (dec idx1))
        c2 (pos-char pass (dec idx2))]
    (or
     (and (= c1 (first c)) (not= c2 (first c)))
     (and (= c2 (first c)) (not= c1 (first c))))))

(defn part-2
  "Day 02 Part 2"
  [input]
  (->> input
       (string/split-lines)
       (filter is-it-valid?)
       count))
