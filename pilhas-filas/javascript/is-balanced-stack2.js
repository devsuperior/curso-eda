import Stack2 from "./stack2.js";

function isBalanced(text) {
  let stack = new Stack2();
  for (let char of text) {
    if (char === "(") {
      stack.push(char);
    } else if (char === ")") {
      if (stack.isEmpty()) {
        return false;
      }
      stack.pop();
    }
  }
  return stack.isEmpty();
}

console.log(isBalanced("(())()")); // true
console.log(isBalanced("())(")); // false
