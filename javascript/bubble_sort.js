 /**
 *  Problema: Bubble Sort
 * 
 *  n = number of elements array
 *
 *  tempo: O(nˆ2)
 *  espaço: O(1)
 */

const bubble_sort = (nums) => {
    const N = nums.length;
    for (let i = 0; i < N; i++) {
        let swapped = false;
        for (let j = 0; j < N - 1 - i; j++) {
            if (nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1);
                swapped = true;
            }
        }
        if (!swapped) {
            break;
        }
    }
    return nums;
};

const swap = (nums, a, b) => {
    const aux = nums[a];
    nums[a] = nums[b];
    nums[b] = aux;
};

console.log(bubble_sort([23, 4, 67, -8, 21]));
console.log(bubble_sort([5, 4, 3, 2, 1]));