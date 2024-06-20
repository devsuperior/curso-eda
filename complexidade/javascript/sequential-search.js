function sequentialSearch(elem, arr) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] == elem) {
      return i;
    }
  }
  return -1;
}

const result = sequentialSearch(32, [15, 82, 79, 32, 41, 28]);
console.log(result);
