def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

def bogoSort = { l ->
  def sortList = l.clone().sort()
  while (sortList != l) {
    Collections.shuffle(l)
  }
  l
}
println bogoSort(randomList)
