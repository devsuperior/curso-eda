/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let memo;

    const robUtil = (nums, i) => {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        let result = Math.max(robUtil(nums, i - 2) + nums[i], robUtil(nums, i - 1));
        memo[i] = result;
        return result;
    };

    memo = new Array(nums.length + 1).fill(-1);
    return robUtil(nums, nums.length - 1);
};

console.log(rob([1, 2, 3, 1]));
console.log(rob([2, 7, 9, 3, 1]));