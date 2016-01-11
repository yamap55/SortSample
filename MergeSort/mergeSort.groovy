def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList
// size2�̔z��ɕ���
def firstList = randomList.inject([]) {d,i ->
  if (d*.size().sum(0) % 2 == 0) {
    d << [i]
  } else {
    d.last()[0] < i ?  d.last() << i : d.last().add(0,i)
  }
  d
}
//println "2�Âɕ������ă\�[�g : ${firstList}"

// 2��List���}�[�W����i�n����Ă���List�̓}�[�W����Ă���O��j
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

// List����List��2�Â}�[�W�B
def result = {list ->
  def resultList = []
  list.size().times{i->
    if (list.size()-1 < i*2) {
      return resultList
    } else if(list.size()-1 < i*2+1){
      resultList << (list[(i*2)])
    } else {
      resultList << listMerge(list[(i*2)],list[i*2+1])
    }
  }
  return resultList.size() == 1 ? resultList[0] : call(resultList)
}(firstList)

println result