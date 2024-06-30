function binarySearch(nums, key) {
    return binarySearchTailRecursive(nums, key, 0, nums.length - 1);
}

function binarySearchTailRecursive(nums, key, low, high) {

    if (low > high) {
        return -1;
    }
    
    const middle = Math.floor((low + high) / 2);
    if (key === nums[middle]) {
        return middle;
    } 
    else if (key < nums[middle]) {
        return binarySearchTailRecursive(nums, key, low, middle - 1);
    }
    else {
        return binarySearchTailRecursive(nums, key, middle + 1, high);
    }
};

console.log(binarySearch([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38], 34)); // 9
console.log(binarySearch([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38], 10)); // -1
console.log(binarySearch([-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431], 11)); // 3
