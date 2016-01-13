def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println "start : ${randomList}"

// 2つのListをマージする（渡されているListはマージされている前提）
def listMerge = {mergeList, list1, list2->
    if (!list1 || !list2) {
      return list1 + list2 + mergeList
    }
    def bigValue = (list1.last() < list2.last() ? list2 : list1).pop()
    mergeList.add(0,bigValue)
    call(mergeList, list1, list2)
}

def mergeSort = {
  if (it.size() == 1) {
    return it
  }
  def i = it.size() / 2 as int
  def left = call(it[0..i-1])
  def right = call(it[i..it.size()-1])
  listMerge([], left, right)
}

println "end   : ${mergeSort(randomList)}"