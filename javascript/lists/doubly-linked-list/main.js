import DoublyLinkedList from "./doubly-linked-list.js";

// const display = (list) => {
//     list.forEach((item) => {
//         console.log(item);
//     });
// };

const list = new DoublyLinkedList();

// 1 - Add at start
list.addAtStart(2);
list.addAtStart(9);
console.log(list.toArray());

list.clear();

// 2 - Add at end
list.addAtEnd(2);
list.addAtEnd(4);
list.addAtEnd(8);
list.addAtEnd(32);
list.addAtEnd(128);
console.log(list.toArray());

// 3 - Obter o tamanho da lista
console.log(`Tamanho da lista igual a: ${list.getSize()}`);

// 4 - Add at position
list.addAtPosition(3, 16);
console.log(list.toArray());

list.addAtPosition(5, 64);
console.log(list.toArray());

// 5 - Remove head
let node = list.removeHead();
console.log(`Removendo do inicio, elemento ${node.value} da lista`);
console.log(list.toArray());

// 6 - Remove tail
node = list.removeTail();
console.log(`Removendo do final, elemento ${node.value} da lista`);
console.log(list.toArray());

// 7 - Remove at position
// let index = 4;
// const item = list.removeAtPosition(index);
// if (item) {
//     console.log(`Removendo elemento ${item} da posicao ${index}`);
// } else {
//     console.log(`Erro ao remover elemento da posicao ${index}`);
// }

// console.log(list.toArray());

// 8 - Remove
// list.remove(32);
// list.remove(4);
// console.log(list.toArray());

// 9 - Reverse list
list.reverse();
console.log(list.toArray());