export default class Queue1 {
    constructor() {
        this.list = [];
    }

    isEmpty() {
        return this.list.length === 0;
    }

    add(item) {
        this.list.push(item);
    }

    remove() {
        if (this.isEmpty()) {
            throw new Error("Queue is empty");
        }
        return this.list.shift();
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Queue is empty");
        }
        return this.list[0];
    }

    count() {
        return this.list.length;
    }
}
