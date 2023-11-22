
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    
    constructor() {
        this.head = null;
        this.size = 0;
    }

    // clear = () => {
    //     this.head = null;
    //     this.size = 0;
    // };

    clear = () => {
        let aux = this.head;
        while (aux != null) {
            aux = aux.next;
            this.head.value = null;
            this.head.next = null;
            this.head = aux;
        }
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
            this.size = this.size + 1;
            return;
        }
        const aux = this.head;
        this.head = node;
        node.next = aux;
        this.size = this.size + 1;
    };

    addAtEnd = (elem) => {
        const node = new Node(elem);
        if (this.head == null) {
            this.head = node;
            this.size = this.size + 1;
            return;
        }
    
        let current = this.head;
        while (current.next) {
            current = current.next;
        }
        current.next = node;
        this.size = this.size + 1;
    };

    addAtPosition = (index, elem) => {
        if (index == 0) {
           this.addAtStart(elem);
           return; 
        }
        if (!this.get(index)) {
            this.addAtEnd(elem);
            return;
        }

        // const node = new Node(elem);
        // let current = this.getNode(index - 1);
        // let aux = current.next;
        // current.next = node;
        // node.next = aux;
        // this.size++;

        const node = new Node(elem);
        let current = this.getNode(index - 1);
        node.next = current.next;
        current.next = node;
        this.size++;
    };

    contains = (elem) => {
        // let current = this.head;
        // while (current) {
        //     if (current.value == elem) 
        //         return true;
        //     current = current.next;
        // }
        // return false;
        let indexElem = this.indexOf(elem);
        if (indexElem != -1) {
            return true;
        }
        return false;
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
        let i = 0;
        while (i != index) {
            current = current.next;
            i++;
        }
        if (current) 
            return current;
        return null;
    };

    indexOf = (elem) => {
        let current = this.head;
        let i = 0
        while (current) {
            if (current.value == elem)
                return i;
            current = current.next;
            i++;
        }
        return -1;
    };

    removeAtPosition = (index) => {
        if (this.isEmpty() || !this.get(index)) {
            return null;
        }
        let item = null;
        let current = null;
        if (index == 0) {
            item = this.head.value;
            this.head = this.head.next;
            this.size--;
            return item;
        }
        if (index == this.getSize() - 1) {
            item = this.get(index);
            current = this.getNode(index - 1);
            current.next = null;
            this.size--;
            return item;
        }
        current = this.getNode(index - 1);
        item = (current.next).value;
        current.next = (current.next).next;
        this.size--;
        return item;
    };

    remove = (elem) => {
        let index = this.indexOf(elem);
        if (this.isEmpty() || index == -1) {
            return false;
        }
        this.removeAtPosition(index);
        return true;
    };

    printLinkedList = () => {
        let current = this.head;
        while (current != null) {
            console.log(current.value);
            current = current.next;
        }
    };
}

let linkedList = new LinkedList();
// console.log("Tamanho da lista:", linkedList.getSize());
// console.log("Lista esta vazia?", linkedList.isEmpty());

// linkedList.addAtEnd('A');
// linkedList.addAtEnd('B');
// linkedList.printLinkedList();
// console.log("Tamanho da lista:", linkedList.getSize());
// console.log("Lista esta vazia?", linkedList.isEmpty());

// linkedList.clear();
// linkedList.printLinkedList();
// console.log("Tamanho da lista:", linkedList.getSize());
// console.log("Lista esta vazia?", linkedList.isEmpty());

// linkedList.addAtEnd(10);
// linkedList.addAtEnd(20);
// console.log("Lista atual: ");
// linkedList.printLinkedList();

// console.log("Adiciona o elemento 2 no inicio...")
// linkedList.addAtStart(2);
// console.log("Lista atual: ");
// linkedList.printLinkedList();
// console.log("Tamanho da lista:", linkedList.getSize());

// console.log("elem 20 está na lista?", linkedList.contains(20));
// console.log("elem 80 está na lista?", linkedList.contains(80));

// console.log("elem 2 esta na posicao:", linkedList.indexOf(2));

// console.log(linkedList.get(-5));
// console.log(linkedList.get(0));
// console.log(linkedList.get(1));
// console.log(linkedList.get(2));

// console.log("Elem 88 esta na lista?", linkedList.contains(88));
// console.log("Elem 10 esta na lista?", linkedList.contains(10));

// console.log("Limpando a lista ...")
// linkedList.clear();
linkedList.addAtEnd(2);
linkedList.addAtEnd(4);
linkedList.addAtEnd(16);
linkedList.addAtEnd(32);

console.log("Lista atual: ");
linkedList.printLinkedList();

linkedList.addAtPosition(4, 8);
console.log("Lista atual: ");
linkedList.printLinkedList();

// console.log("removendo elemento da posicao 4:", linkedList.removeAtPosition(4));
// console.log("Lista atual: ");
// linkedList.printLinkedList();

// console.log("Tamanho da lista:", linkedList.getSize());

console.log("removendo o elemento 2:", linkedList.remove(16));
console.log("Lista atual: ");
linkedList.printLinkedList();

console.log("Tamanho da lista:", linkedList.getSize());

console.log("Removendo todos os elementos");
linkedList.clear();

console.log("Lista atual: ");
linkedList.printLinkedList();

console.log("Tamanho da lista:", linkedList.getSize());




