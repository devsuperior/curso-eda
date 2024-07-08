function intersection(nums1, nums2) {
  let set1 = new Set(nums1);
  let set2 = new Set(nums2);

  let intersectionSet = new Set([...set1].filter(n => set2.has(n)));
  return Array.from(intersectionSet);
}

let result1 = intersection([1, 2, 2, 1], [2, 2]);
let result2 = intersection([4, 9, 5], [9, 4, 9, 8, 4]);
console.log(result1);  // Output: [2]
console.log(result2);  // Output: [4, 9]
