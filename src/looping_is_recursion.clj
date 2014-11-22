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
  (let [helper (fn [acc b exp]
                 (if (zero? exp)
                   acc
                   (recur (* acc b) b (dec exp))))]
    (helper 1 base exp)))

(defn last-element [a-seq]
  )

(defn plus [num numb]
  (+ num numb))

(defn seq= [seq1 seq2]
  )

(defn find-first-index [pred a-seq]
  )

(defn avg [a-seq]
  )

(defn parity [a-seq]
  )

(defn fast-fibo [n]
  )

(defn cut-at-repetition [a-seq]
  )
