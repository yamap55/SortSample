
IntRange.metaClass.define {
    // 範囲内でランダム
    random {
        int from = delegate.isReverse() ? to : from
        int to   = delegate.isReverse() ? from : to
        int size = to - from + 1
        (Math.floor(Math.random() * size) + from) as int
    }
}

def f = {array ->
  (array.size()-1).times {
    ((array.size()-1)-it).times {
      array[it] < array[it+1] ?: Collections.swap(array, it,it+1)
    }
  }
  array
}

def array = []
10.times {
  array << (1..10).random()
}
println "start : ${array}"
def bk = array.clone()
def afterArray = f(array)
println "end : ${afterArray}"
assert bk.sort() == afterArray