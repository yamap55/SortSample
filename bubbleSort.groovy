
IntRange.metaClass.define {
    // ”ÍˆÍ“à‚Åƒ‰ƒ“ƒ_ƒ€
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
     array[it..it+1] = {a ->a[0] < a[1] ? a : a.reverse()}(array[it..it+1])
    }
  }
  array
}

def array = []
10.times {
  array << (1..10).random()
}
println "start : ${array}"
def afterArray = f(array)
println "end : ${afterArray}"
assert array.sort() == afterArray