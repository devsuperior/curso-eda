function validParentheses(text) {
    let stack = [];
    for (let c of text) {
        if (c === '(') {
            stack.push(')');
        } else if (c === '{') {
            stack.push('}');
        } else if (c === '[') {
            stack.push(']');
        } else if (stack.length === 0 || stack.pop() !== c) {
            return false;
        }
    }
    return stack.length === 0;
}

console.log(validParentheses("()([]{})")); // true
console.log(validParentheses("(){]{}")); // false
