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

console.log("size: " + myTree.size());
console.log("isEmpty: " + myTree.isEmpty());

const pos1 = myTree.find("Livro Azul");
const pos2 = myTree.find("Capítulo 1");
const pos3 = myTree.find("Aplicações");

console.log("\nLivro Azul:");
if (pos1) {
    console.log("Encontrado");
    console.log("isExternal: " + myTree.isExternal(pos1));
    console.log("isRoot: " + myTree.isRoot(pos1));
    const parent = myTree.parent(pos1);
    if (parent != null) {
        console.log("parent: " + parent.element());
    }
}
else {
    console.log("NÃO encontrado");
}

console.log("\nCapítulo 1:");
if (pos2) {
    console.log("Encontrado");
    console.log("isExternal: " + myTree.isExternal(pos2));
    console.log("isRoot: " + myTree.isRoot(pos2));
    const parent = myTree.parent(pos2);
    if (parent != null) {
        console.log("parent: " + parent.element());
    }
}
else {
    console.log("NÃO encontrado");
}

console.log("\nAplicações:");
if (pos3) {
    console.log("Encontrado");
    console.log("isExternal: " + myTree.isExternal(pos3));
    console.log("isRoot: " + myTree.isRoot(pos3));
    const parent = myTree.parent(pos3);
    if (parent != null) {
        console.log("parent: " + parent.element());
    }
}
else {
    console.log("NÃO encontrado");
}

const pos4 = myTree.find("Conceitos");
myTree.replace(pos4, "Conceitos básicos");

console.log("\nPRINT DFS PRE ORDER:");
print(myTree);

console.log("\nPRINT elements():");
for (const elem of myTree.elements()) {
    console.log(elem);
}

console.log("\nPRINT positions():");
for (const pos of myTree.positions()) {
    console.log(pos.element());
}

console.log("\nPRINT BFS:");
printBfs(myTree);

const pos5 = myTree.find("Métodos");
if (pos5) {
    myTree.remove(pos5);
    console.log("\nPRINT remove:");
    console.log("SIZE = " + myTree.size());
    print(myTree);
}

function print(tree) {
    printRecursive(tree.root(), tree, 0);
}

function printRecursive(position, tree, depth) {
    const spaces = "    ".repeat(depth);
    console.log(spaces + position.element());
    for (const child of tree.children(position)) {
        printRecursive(child, tree, depth + 1);
    }    
}

function printBfs(tree) {
    if (tree.isEmpty()) {
        return;
    }
    const queue = [];
    queue.push(tree.root());
    while (queue.length > 0) {
        const position = queue.shift();
        console.log(position.element());
        queue.push(...tree.children(position));
    }
}
