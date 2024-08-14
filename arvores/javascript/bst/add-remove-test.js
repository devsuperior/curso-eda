import BinarySearchTreeSet from "./binary-search-tree-set.js";

const list = [52, 17, 67, 11, 33, 55, 83, 14, 31, 46, 23, 26];
const tree = new BinarySearchTreeSet(list);

console.log(tree);

console.log("\nOriginal:");
console.log(tree.toStringFormat());

tree.add(58);

console.log("\nAdd test:");
console.log(tree.toStringFormat());

tree.remove(31);

console.log("\nRemove test:");
console.log(tree.toStringFormat());
