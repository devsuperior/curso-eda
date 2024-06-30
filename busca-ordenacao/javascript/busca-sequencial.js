function sequentialSearch(nums, key) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == key)
            return i;
    }
    return -1;
};

console.log(sequentialSearch([28, 6, -2, 9, 16, 20, 23, 8], 20)); // 5
console.log(sequentialSearch([4, 6, -3, 21, 55, 91, 2], 11)); // -1
