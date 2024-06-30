function quickSort(nums) {
    quickSortTailRecursive(nums, 0, nums.length - 1);
    return nums;
}

function quickSortTailRecursive(nums, left, right) {
    if (left < right) {
        let pivot = partition(nums, left, right);
        quickSortTailRecursive(nums, left, pivot - 1);
        quickSortTailRecursive(nums, pivot + 1, right);
    }
    return nums;
};

function partition(nums, left, right) {
    let pivot = nums[right];
    let i = left;
    for (let j = left; j < right; j++) {
        if (nums[j] <= pivot) {
            swap(nums, j, i);
            i = i + 1;
        }
    }
    swap(nums, i, right);
    return i;
};

function swap(nums, a, b) {
    const aux = nums[a];
    nums[a] = nums[b];
    nums[b] = aux;
};

console.log(quickSort([20, 9, 86, -2, 16]));
console.log(quickSort([30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4]));
console.log(quickSort([1, 1, 1, 2, 2, 4, 8, 8, 16, 32]));
