def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

def quickSort = {list ->
  if (list.every{list[0] == it}) {
    return list
  }
  def pivot = list.pop()
  def small = list.findAll{it < pivot}
  def big = list.findAll{it >= pivot}
  
  call(small) + pivot + call(big)
}
println quickSort(randomList)