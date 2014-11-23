;; http://iloveponies.github.io/120-hour-epic-sax-marathon/looping-is-recursion.html

(ns looping-is-recursion)

(defn recursive-factorial [n]
  (if (zero? n)
    1
    (* n (recursive-factorial (dec n)))))

(defn helper [acc n]
  (if (zero? n)
    acc
    (helper (* acc n) (dec n))))

(defn acc-factorial [n]
  (helper 1 n))

(defn recur-factorial [number]
  (let [helper (fn [acc n]
                 (if (zero? n)
                   acc
                   (recur (* acc n) (dec n))))]
    (helper 1 number)))

(defn power [base exp]
  (let [helper (fn [acc exp]
                 (if (zero? exp)
                   acc
                   (recur (* acc base) (dec exp))))]
    (helper 1 exp)))

(defn last-element [a-seq]
  (let [helper (fn [last a-seq]
                 (if (empty? a-seq)
                   last
                   (recur (first a-seq) (rest a-seq))))]
    (helper nil a-seq)))

(defn seq= [seq1 seq2]
  (let [helper (fn [passed? s1 s2]
                 (cond
                  (= false passed?) false
                  (and (empty? s1) (empty? s2)) true
                  (or (empty? s1) (empty? s2)) false
                  :else (recur (= (first s1) (first s2)) (rest s1) (rest s2))))]
    (helper true seq1 seq2)))

(defn loopy-factorial [down-from]
  (loop [acc 1
         n down-from]
    (if (zero? n)
      acc
      (recur (* acc n) (dec n)))))

(defn find-first-index [pred a-seq]
  (loop [idx 0
         seq a-seq]
    (cond
     (empty? seq) nil
     (pred (first seq)) idx
     :else (recur (inc idx) (rest seq)))))

(defn avg [a-seq]
  (loop [count 0
         sum 0
         seq a-seq]
    (cond
     (empty? a-seq) nil
     (empty? seq) (/ sum count)
     :else (recur (inc count) (+ sum (first seq)) (rest seq)))))

(defn parity [a-seq]
  (let [toggle (fn [a-set elem]
                 (if (contains? a-set elem)
                   (disj a-set elem)
                   (conj a-set elem)))]
    (loop [par-set #{}
           seq a-seq]
      (if (empty? seq)
        result
        (recur (toggle par-set (first seq)) (rest seq))))))

(defn fast-fibo [n]
  (loop [fn-2 0
         fn-1 1
         idx (dec n)]
    (cond
     (zero? n) 0
     (= n 1) 1
     (zero? idx) fn-1
     :else (recur fn-1 (+ fn-2 fn-1) (dec idx)))))

(defn cut-at-repetition [a-seq]
  (loop [seq a-seq
         elems #{}
         cut []]
    (cond
     (empty? seq) cut
     (contains? elems (first seq)) cut
     :else (recur (rest seq) 
                  (conj elems (first seq)) 
                  (conj cut (first seq)))))) 
