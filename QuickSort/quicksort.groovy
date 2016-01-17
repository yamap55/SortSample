def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

def quickSort = {result, list ->
  if (list.every{list[0] == it}) {
    result.addAll(list)
    return result
  }
  def pivot = list.pop()
  def small = list.findAll{it < pivot}
  def big = list.findAll{it >= pivot}
  big.add(0,pivot)
  call(result, small)
  call(result,big)
}
println quickSort([],randomList)