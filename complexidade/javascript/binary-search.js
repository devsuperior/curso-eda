function binarySearch(elem, arr) {
  return binarySearchTailRecursive(elem, arr, 0, arr.length - 1);
}

function binarySearchTailRecursive(elem, arr, start, finish) {
  if (start > finish) {
    return -1;
  }
  
  const middle = Math.floor((start + finish) / 2);
  if (elem == arr[middle]) {
    return middle;
  }
  else if (elem < arr[middle]) {
    return binarySearchTailRecursive(elem, arr, start, middle - 1);
  }
  else {
    return binarySearchTailRecursive(elem, arr, middle + 1, finish);
  }
}

const v = [7, 13, 20, 25, 28, 31, 35, 39, 40, 45, 46, 48, 57, 59, 63, 71];
console.log(binarySearch(39, v));
console.log(binarySearch(46, v));
console.log(binarySearch(22, v));
