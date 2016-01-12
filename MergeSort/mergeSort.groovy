def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

// 2つのListをマージする（渡されているListはマージされている前提）
def listMerge = {list1,list2->
  return {mergeList,l1,l2->
    if (!l1 || !l2) {
      return l1+l2+mergeList
    }
    def bigValue = (l1.last() < l2.last() ? l2 : l1).pop()
    mergeList.add(0,bigValue)
    return call(mergeList,l1,l2)
  }([],list1,list2)
}

def mergeSort = {
  if (it.size() == 1) {
    return it
  }
  def i = it.size() / 2 as int
  def left = call(it[0..i-1])
  def right = call(it[i..it.size()-1])
  listMerge(left, right)
}

println mergeSort(randomList)