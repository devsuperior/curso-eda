import BinarySearchTreeSet from "./binary-search-tree-set.js";

const A = new BinarySearchTreeSet([1, 2, 3, 4, 5]);
const B = new BinarySearchTreeSet([4, 5, 6, 7, 8]);

console.log("Conjunto A: " + A);
console.log("Conjunto B: " + B);

A.add(9);
console.log("Conjunto A após adicionar 9: " + A);

A.remove(9);
console.log("Conjunto A após remover 9: " + A);

console.log("5 pertence ao conjunto A? " + A.contains(5));

console.log("Conjunto A está vazio? " + A.isEmpty());

console.log("Tamanho do conjunto A: " + A.size());

let C = A.union(B);
console.log("União dos conjuntos A e B (Conjunto C): " + C);

C = A.intersection(B);
console.log("Interseção dos conjuntos A e B (Conjunto C): " + C);

C = A.difference(B);
console.log("Diferença entre os conjuntos A e B (Conjunto C): " + C);
