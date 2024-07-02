import DoublyLinkedList from "./doubly-linked-list.js";

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
console.log("Adicionado 16 à posição 3:");
console.log(list.toArray());

list.addAtPosition(5, 64);
console.log("Adicionado 64 à posição 5:");
console.log(list.toArray());

// 5 - Remove head
list.removeHead();
console.log("Removido primeiro elemento:");
console.log(list.toArray());

// 6 - Remove tail
list.removeTail();
console.log("Removido último elemento:");
console.log(list.toArray());

// 7 - Remove at position
list.removeAtPosition(4);
console.log("Removido elemento da posição 4:");
console.log(list.toArray());

// 8 - Remove
list.remove(32);
console.log("Removido elemento 32:");
console.log(list.toArray());
list.remove(4);
console.log("Removido elemento 4:");
console.log(list.toArray());

// 9 - Reverse list
list.reverse();
console.log("Lista reversa:");
console.log(list.toArray());
