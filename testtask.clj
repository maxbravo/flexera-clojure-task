(ns flexiana.server.testtask)

(defn initial-string
  "convert the str1 in a map and count the occurence per character"
  [str]
  (reduce (fn [ret c]
            (if (contains? ret c)
              (update ret c inc)
              (assoc ret c 1)))
          {} (seq str)))

(defn char-consumption
  "if there is a coincidence of the str2 in str1, the number of occurence will be discounted otherwise returns null"
  [table X]
  (when (and (contains? table X)
             (pos? (get table X)))
    (update table X dec)))

(defn scramble?
  "user must enter 2 strings, the functions will be call in a recursive mode"
  [str1 str2]
  (loop [ret (initial-string str1) [fc & rc] str2]
    (if (and ret fc)
      (recur (char-consumption ret fc) rc)
      ret)))