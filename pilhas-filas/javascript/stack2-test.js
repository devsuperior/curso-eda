import Stack2 from "./stack2.js";

let stack = new Stack2();

console.log("stack.count(): " + stack.count())
console.log("stack.isEmpty(): " + stack.isEmpty());

stack.push("Maria");
stack.push("Joao");
stack.push("Ana");
console.log("Adicionados: Maria, Joao, Ana");

console.log("stack.count(): " + stack.count())
console.log("stack.isEmpty(): " + stack.isEmpty());
console.log("stack.peek(): " + stack.peek());

console.log("Itens:");
while (!stack.isEmpty()) {
  const item = stack.pop();
  console.log(item);
}
