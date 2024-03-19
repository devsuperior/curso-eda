/**
 * @param {number[]} arr
 * @return {void} Do not return anything, modify arr in-place instead.
 */
const duplicateZeros = (arr) => {
    for (let i = 0; i < arr.length - 1; i++) {
        if (arr[i] == 0) {
            for (let j = arr.length - 2; j > i; j--) {
                arr[j + 1] = arr[j];
            }
            arr[i + 1] = arr[i];
            i = i + 1;
        }
    }
};

// const arr = [1,0,2,3,0,4,5,0]
// const arr = [0,0,0,0,0,0,0];
const arr = [0,4,1,0,0,8,0,0,3];
duplicateZeros(arr)
console.log(arr);