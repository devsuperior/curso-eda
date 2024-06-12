function isSorted(list) {
  if (list.length <= 1) {
    return true;
  }

  if (list[0] > list[1]) {
    return false;
  }

  const tail = list.slice(1);

  return isSorted(tail);
}

console.log(isSorted([]));
console.log(isSorted([15, 20, 22, 31, 40]));
console.log(isSorted([15, 20, 22, 21, 40]));
