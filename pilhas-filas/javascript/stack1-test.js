import Stack1 from "./stack1.js";

let stack = new Stack1(10);

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
