var createRandomArray = function(size) {
  var result = [];
  for(var i = 0; i < size; i++) {
    result.push(Math.floor(Math.random() * 10) + 1);
  }
  return result;
};

var bubbleSort = function(array) {
  for (var i = 0; i < array.length -1; i++) {
    for (var j = 0; j < array.length -1 - i; j++) {
      if (!(array[j] < array[j+1])) {
        var tmp = array[j];
        array[j] = array[j+1];
        array[j+1] = tmp;
      }
    }
  }
  return array;
}

var list = createRandomArray(10);
console.log(list);
list = bubbleSort(list);
console.log(list);