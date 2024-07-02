function removeDuplicates(text) {

    let stack = [];
    for (let char of text) {
        if (stack.length != 0 && stack[stack.length - 1] == char) {
            stack.pop();
        }
        else {
            stack.push(char);
        }
    }

    return stack.join("");
}

console.log(removeDuplicates("abbaca"));
console.log(removeDuplicates("azxxzy"));
