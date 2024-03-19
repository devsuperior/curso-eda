/**
 *  Problema: Insertion Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */

const insertion_sort = (nums) => {
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
};

console.log(insertion_sort([20, 9, 86, -2, 16]));
console.log(insertion_sort([5, 4, 3, 2, 1]));
console.log(insertion_sort([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]));