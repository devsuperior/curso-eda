import Node from "./node.js";

export default class GenericTree {

    #root;
    #size;

    constructor() {
        this.#root = null;
        this.#size = 0;
    }

    size() {
        return this.#size;
    }

    isEmpty() {
        return this.#size === 0;
    }

    elements() {
        const list = [];
        this.#collectElements(list, this.#root);
        return list;
    }

    #collectElements(list, node) {
        list.push(node.element());
        for (const child of node._getChildren()) {
            this.#collectElements(list, child);
        }
    }

    positions() {
        const list = [];
        this.#collectPositions(list, this.#root);
        return list;
    }

    #collectPositions(list, node) {
        list.push(node);
        for (const child of node._getChildren()) {
            this.#collectPositions(list, child);
        }
    }

    find(element) {
        return this.#findRecursive(this.#root, element);
    }

    #findRecursive(node, target) {
        if (!node) {
            return null;
        }
        if (node.element() === target) {
            return node;
        }
        for (const child of node._getChildren()) {
            const found = this.#findRecursive(child, target);
            if (found) {
                return found;
            }
        }
        return null;
    }

    #validate(position) {
        if (!(position instanceof Node)) {
            throw new Error("Invalid position type");
        }
        if (position._getParent() === position) {
            throw new Error("Removed node");
        }
        return position;
    }

    add(element, parent) {
        if (!this.isEmpty() && !parent) {
            throw new Error("Parent position can't be null for a non-empty tree");
        }
        const parentNode = parent ? this.#validate(parent) : null;
        const newNode = new Node(element, parentNode);
        if (!parentNode) {
            this.#root = newNode;
        }
        else {
            parentNode._addChild(newNode);
        }
        this.#size++;
        return newNode;
    }

    children(position) {
        const node = this.#validate(position);
        return [...node._getChildren()];
    }

    root() {
        return this.#root;
    }

    isExternal(position) {
        const node = this.#validate(position);
        return node._isLeaf();
    }

    isRoot(position) {
        const node = this.#validate(position);
        return node === this.#root;
    }

    parent(position) {
        const node = this.#validate(position);
        return node._getParent();
    }

    replace(position, element) {
        const node = this.#validate(position);
        node._setElement(element);
    }

    remove(position) {
        const node = this.#validate(position);
        if (node === this.#root) {
            this.#root = null;
        }
        else {
            const parent = node._getParent();
            if (parent) {
                parent._removeChild(node);
            }
        }
        this.#size -= this.#subtreeSize(node);
        this.#markAsRemoved(node);
    }

    #markAsRemoved(node) {
        node._setParent(node);
        for (const child of node._getChildren()) {
            this.#markAsRemoved(child);
        }
    }

    #subtreeSize(node) {
        let childrenSize = 0;
        for (const child of node._getChildren()) {
            childrenSize += this.#subtreeSize(child);
        }
        return 1 + childrenSize;
    }
}
