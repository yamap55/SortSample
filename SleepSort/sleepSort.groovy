import groovyx.gpars.GParsPool
import java.util.concurrent.CopyOnWriteArrayList

def createRandomList = {size ->
  (0..<size).collect {
    (Math.floor(Math.random() * 10) + 1) as int
  }
}

def randomList = createRandomList(10)
println randomList

def sleepSort = {list ->
  def result = [] as CopyOnWriteArrayList
  GParsPool.withPool(list.size()) {pool ->
    list.eachParallel {
      sleep(it * 10)
      result << it
    }
  }
  result
}
println sleepSort(randomList)