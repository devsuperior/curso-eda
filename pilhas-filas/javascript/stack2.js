export default class Stack2 {
    constructor() {
        this.list = [];
    }

    isEmpty() {
        return this.list.length === 0;
    }

    push(item) {
        this.list.push(item);
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error("Stack is empty");
        }
        return this.list.pop();
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Stack is empty");
        }
        return this.list[this.list.length - 1];
    }

    count() {
        return this.list.length;
    }

    clear() {
        this.list = [];
    }
}
