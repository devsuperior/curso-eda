class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

export default class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    clear = () => {
        this.head = null;
        this.tail = null;
        this.size = 0;
    };

    isEmpty = () => {
        if (this.head == null)
            return true;
        return false;
    };

    getSize = () => {
        return this.size;
    };

    addAtStart = (elem) => {
        const node = new Node(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.size += 1;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
        this.size += 1;
    };

    addAtEnd = (elem) => {
        const node = new Node(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.size += 1;
            return;
        }
        node.prev = this.tail;
        this.tail.next = node;
        this.tail = node;
        this.size += 1;
    };

    addAtPosition = (index, elem) => {
        if (index == 0) {
            this.addAtStart(elem);
            return;
        }
        if (!this.get(index) || index == this.getSize()) {
            console.log("Caiu aqui!");
            this.addAtEnd(elem);
            return;
        }
        const node = new Node(elem);
        let current = this.getNode(index - 1);
        current.next.prev = node;
        node.next = current.next;
        node.prev = current;
        current.next = node;
        this.size += 1;
    };

    get = (index) => {
        let current = this.getNode(index);
        if (current) 
            return current.value;
        return null;
    };

    getNode = (index) => {
        if (index < 0 || index > this.getSize())
            return null;
        
        let current = this.head;
        let currentIndex = 0;
        while (current !== null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current;
    };

    contains = (elem) => {
        let indexElem = this.indexOf(elem); 
        if (indexElem != -1) {
            return true;
        }
        return false;
    };

    indexOf = (elem) => {
        let current = this.head;
        let index = 0;
        while(current) {
            if (current.value === elem)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    };

    removeHead = () => {
        const node = this.head;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }
        this.size -= 1;
        return node;
    };

    removeTail = () => {
        const node = this.tail;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.size -= 1;
        return node;
    };

    removeAtPosition = (index) => {
        if (this.isEmpty() || !this.get(index)) {
            return null;
        }
        if (index == 0)
            return this.removeHead().value;
        if (index == this.getSize() - 1)
            return this.removeTail().value;
        const current = this.getNode(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        this.size -= 1;
        return current.value;
    };

    remove = (elem) => {
        let index = this.indexOf(elem);
        if (this.isEmpty() || index == -1) {
            return false;
        }
        this.removeAtPosition(index);
        return true;
    };

    reverse = () => {
        const nodeHead = this.head;
        const nodeTail = this.tail;

        this.head = nodeTail;
        this.tail = nodeHead;

        let current = nodeHead;
        let aux = null;
        while (current) {
            aux = current.next;
            current.next = current.prev;
            current.prev = aux;
            current = aux;
        }
    };

    toArray = () => {
        let current = this.head;
        let vect = [];
        
        while (current) {
            vect.push(current.value);
            current = current.next;
        }
        return vect;
    };
}

