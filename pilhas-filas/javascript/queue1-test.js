import Queue1 from "./queue1.js";

const queue = new Queue1();

console.log("queue.count():", queue.count());
console.log("queue.isEmpty():", queue.isEmpty());

queue.add("Maria");
queue.add("Joao");
queue.add("Ana");
console.log("Adicionados: Maria, Joao, Ana");

console.log("queue.count():", queue.count());
console.log("queue.isEmpty():", queue.isEmpty());
console.log("queue.peek():", queue.peek());

console.log("Itens:");
while (!queue.isEmpty()) {
    console.log(queue.remove());
}
