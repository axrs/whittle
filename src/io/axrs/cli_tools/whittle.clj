(ns io.axrs.cli-tools.whittle)

(def ^:dynamic *logger* prn)
(def ^:dynamic *log-levels* nil)

(def levels #{:debug :info :warn :error})

(defn- assoc-some
  ([m] m)
  ([m k v] (if-not (nil? v)
             (assoc m k v)
             m))
  ([m k v & kvs]
   (let [ret (assoc-some m k v)]
     (if kvs
       (if (next kvs)
         (recur ret (first kvs) (second kvs) (nnext kvs))
         (throw (IllegalArgumentException.
                  "assoc-some expects even number of arguments after map/vector, found odd number")))
       ret))))

(defn levels-for [level-k]
  (case level-k
    :debug levels
    :info (disj levels :debug)
    :warn (disj levels :debug :info)
    :error (disj levels :debug :info :warn)
    nil))

(defn log [program level desc & kwargs]
  (when (and *logger*
             (contains? *log-levels* level))
    (let [body {:level       level
                :program     program
                :description desc}]
      (*logger* (if (seq kwargs)
                  (apply assoc-some body kwargs)
                  body)))))
