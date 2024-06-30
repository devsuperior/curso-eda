function insertionSort(nums) {
  const N = nums.length;
  for (let i = 1; i < N; i++) {
    let aux = nums[i];
    let j = i - 1;
    while (j >= 0 && nums[j] > aux) {
      nums[j + 1] = nums[j];
      j -= 1;
    }
    nums[j + 1] = aux;
  }
  return nums;
}

console.log(insertionSort([20, 9, 86, -2, 16]));
console.log(insertionSort([5, 4, 3, 2, 1]));
console.log(insertionSort([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]));
