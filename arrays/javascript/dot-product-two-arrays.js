// Adaptado: 1570. Dot Product of two sparse vectors
const dotProduct = (nums1, nums2) => {
    let product = 0;
    for (let i = 0; i < nums1.length; i++) {
        product += nums1[i] * nums2[i];
    }
    return product;
};

let nums1 = [1,0,0,2,3];
let nums2 = [0,3,0,4,0];
// = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
console.log(dotProduct(nums1, nums2));

nums1 = [0,1,0,0,0];
nums2 = [0,0,0,0,2];
// = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
console.log(dotProduct(nums1, nums2));

nums1 = [0,1,0,0,2,0,0];
nums2 = [1,0,0,0,3,0,4];
// = 0*1 + 1*0 + 0*0 + 0*0 + 2*3 + 0*0 + 0*4
console.log(dotProduct(nums1, nums2));