def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList
// size2の配列に分割
def firstList = randomList.inject([]) {result,value ->
  if (result*.size().sum(0) % 2 == 0) {
    result << [value]
  } else {
    result.last()[0] < value ?  result.last() << value : result.last().add(0,value)
  }
  result
}
//println "2づつに分割してソート : ${firstList}"

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

//assert listMerge([2,4,6],[1,3,5]) == [1,2,3,4,5,6]

// List内のListを2つづつマージ。
def result = {list ->
  def resultList = []
  list.size().times{
    if (list.size()-1 < it*2) {
      return resultList
    } else if(list.size()-1 < it*2+1){
      resultList << (list[(it*2)])
    } else {
      resultList << listMerge(list[(it*2)],list[it*2+1])
    }
  }
  return resultList.size() == 1 ? resultList[0] : call(resultList)
}(firstList)

println result