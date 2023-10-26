/**
 *  Problema: Merge Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(n log n)
 *  espaço: O(1)
 */

const merge_sort = (nums, left, right) => {
    if (left < right) {
        let middle = Math.floor((left + right) / 2);
        merge_sort(nums, left, middle);
        merge_sort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }
    return nums;
};

const merge = (nums, left, middle, right) => {
    const result = [];
    let length = right - left + 1;
    let i = left;
    let j = middle + 1;
    let k = 0;

    while (i <= middle && j <= right) {
        if (nums[i] < nums[j]) {
            result[k++] = nums[i++];
        } else {
            result[k++] = nums[j++];
        }
    }

    while (i <= middle) {
        result[k++] = nums[i++];
    }

    while (j <= right) {
        result[k++] = nums[j++];
    }

    for (let i = 0; i < length; i++) {
        nums[left + i] = result[i];
    }
};

console.log(merge_sort([20, 9, 86, -2, 16], 0, 4));
console.log(merge_sort([30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4], 0, 10));
console.log(merge_sort([1, 1, 1, 2, 2, 4, 8, 8, 16, 32], 0, 9));