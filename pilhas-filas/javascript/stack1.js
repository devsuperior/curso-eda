export default class Stack1 {
    constructor(size = 100) {
        this.size = size;
        this.arr = new Array(size);
        this.top = -1;
    }

    isEmpty() {
        return this.top === -1;
    }

    isFull() {
        return this.top === this.size - 1;
    }

    push(item) {
        if (this.isFull()) {
            throw new Error("Stack is full");
        }
        this.top++;
        this.arr[this.top] = item;
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error("Stack is empty");
        }
        const item = this.arr[this.top];
        this.top--;
        return item;
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Stack is empty");
        }
        return this.arr[this.top];
    }

    count() {
        return this.top + 1;
    }

    clear() {
        this.top = -1;
    }
}
