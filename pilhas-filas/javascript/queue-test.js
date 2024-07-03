let queue = [];

console.log(`queue.size(): ${queue.length}`);
console.log(`queue.isEmpty(): ${queue.length === 0}`);

queue.push("Maria");
queue.push("Joao");
queue.push("Ana");
console.log("Adicionados: Maria, Joao, Ana");

console.log(`queue.size(): ${queue.length}`);
console.log(`queue.isEmpty(): ${queue.length === 0}`);
console.log(`queue.peek(): ${queue[0]}`);

console.log("Itens:");
while (queue.length > 0) {
    console.log(queue.shift()); // Usando shift para remover o primeiro elemento
}
