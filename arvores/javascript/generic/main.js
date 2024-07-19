import GenericTree from "./generic-tree.js";

const myTree = new GenericTree();
const root = myTree.add("Livro Azul", null);

const intro = myTree.add("Introdução", root);
const cap1 = myTree.add("Capítulo 1", root);
const cap2 = myTree.add("Capítulo 2", root);

myTree.add("Para quem é este livro", intro);
myTree.add("Agradecimentos", intro);

myTree.add("Conceitos", cap1);
myTree.add("Aplicações", cap1);

const cap2Sec1 = myTree.add("Métodos", cap2);
myTree.add("Problema terreno", cap2);
myTree.add("Problema carros", cap2);

myTree.add("Método recursivo", cap2Sec1);
myTree.add("Método imperativo", cap2Sec1);

console.log("Size = " + myTree.size());
console.log("isEmpty = " + myTree.isEmpty());

console.log("\nManual print:");
print(myTree);

let pos1 = myTree.findBfs("Métodos");
if (pos1) {
  myTree.remove(pos1);
  console.log("\nSize após remoção = " + myTree.size());
  console.log("\nManual print:");
  print(myTree);
}

let pos2 = myTree.findBfs("Para quem é este livro");
if (pos2) {
  myTree.replace(pos2, "Público alvo");
  console.log("\nManual print depois de replace:");
  print(myTree);
}

let pos3 = myTree.findBfs("Livro Azul");
let pos4 = myTree.findBfs("Capítulo 1");
let pos5 = myTree.findBfs("Aplicações");

console.log("\nLivro Azul isExternal: " + myTree.isExternal(pos3));
console.log("Livro Azul isRoot: " + myTree.isRoot(pos3));
console.log("Capítulo 1 isExternal: " + myTree.isExternal(pos4));
console.log("Capítulo 1 isRoot: " + myTree.isRoot(pos4));
console.log("Aplicações isExternal: " + myTree.isExternal(pos5));
console.log("Aplicações isRoot: " + myTree.isRoot(pos5));

console.log("\nBFS:");
myTree.elementsBfs().forEach((element) => console.log(element));

console.log("\nDFS:");
myTree.elementsDfs().forEach((element) => console.log(element));

function print(tree) {
  printRecursive(tree, tree.root(), 0);
}

function printRecursive(tree, pos, depth) {
  const spaces = "   ".repeat(depth);
  console.log(spaces + pos.element());
  tree.children(pos).forEach((child) => printRecursive(tree, child, depth + 1));
}
