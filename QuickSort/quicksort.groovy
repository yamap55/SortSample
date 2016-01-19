def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

def quickSort = {list, result=[] ->
  if (list.every{list[0] == it}) {
    return result + list
  }
  def pivot = list.pop()
  def small = list.findAll{it < pivot}
  def big = list.findAll{it >= pivot}
  
  big.add(0,pivot)
  result = call(small, result)
  call(big, result)
}
println quickSort(randomList)