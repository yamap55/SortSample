def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

def selectionSort = {l, result=[] ->
  def min = l.min()
  result += l.findAll{min == it}
  l -= min
  l ? call(l, result) : result
}
println selectionSort(randomList)