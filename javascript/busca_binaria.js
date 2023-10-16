 /**
 *  Problema: Busca Binária (Iterativa)
 * 
 *  n = number of elements array
 *
 *  time: O(n)
 *  space: O(n)
 */

const busca_binaria = function(nums, key) {
    let low = 0;
    let middle;
    let high = nums.length - 1;

    while (low <= high) {
        middle = Math.floor((low + high) / 2);
        if (key < nums[middle])
            high = middle - 1;
        else if (key > nums[middle])
            low = middle + 1;
        else
            return middle;
    }

    return -1;
};

console.log(busca_binaria([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38], 34)); // 9
console.log(busca_binaria([-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38], 10)); // -1
console.log(busca_binaria([-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431], 11)); // 3