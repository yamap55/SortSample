def createRandomArray = {i ->
  (0..<i).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def ll = createRandomArray(10)
println ll
// size2の配列に分割
def dd = ll.inject([]) {a,i ->
  if (a*.size().sum(0) % 2 == 0) {
    a << [i]
  } else {
    a.last()[0] < i ?  a.last() << i : a.last().add(0,i)
  }
  a
}
println "2づつに分割してソート : ${dd}"

// 2つのListをマージする（渡されているListはマージされている前提）
def f = {a,b->
//  println "マージするList : ${a}, ${b}"
  def ff = {mergeList,c,d->
    if (!c || !d) {
//      println "マージされたList : ${c+d+mergeList}"
      return c+d+mergeList
    }
//    println "mergeList : ${mergeList}, c : ${c}, d : ${d}}"
    def bigValue = (c.last() < d.last() ? d : c).pop()
    mergeList.add(0,bigValue)
    return call(mergeList,c,d)
  }
  return ff([],a,b)
}

//assert f([2,4,6],[1,3,5]) == [1,2,3,4,5,6]

def ffff = {ddd ->
//  println "ffff : ${ddd}"
  def aaaa = []
  ddd.size().times{i->
    if (ddd.size()-1 < i*2) {
//      println "a : ${aaaa}"
      return aaaa
    } else if(ddd.size()-1 < i*2+1){
//      println "b : ${aaaa}"
      aaaa << (ddd[(i*2)])
    } else {
//      println "c : ${aaaa}"
      aaaa << f(ddd[(i*2)],ddd[i*2+1])
    }
  }
//  println "size : ${aaaa.size()}, aaaa : ${aaaa}"
  return aaaa.size() == 1 ? aaaa : call(aaaa)
}(dd)

println ffff[0]