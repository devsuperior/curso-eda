export default class BinarySearchTreeSet {
    #size;
    #root;

    constructor(collection = []) {
        this.#size = 0;
        this.#root = new Node(null, null);
        this.addAll(collection);
    }

    size() {
        return this.#size;
    }

    isEmpty() {
        return this.size() === 0;
    }

    remove(key) {
        if (key === null) {
            throw new Error("Key cannot be null");
        }

        let nodeToRemove = this.findKeyLocation(this.#root, key);

        if (nodeToRemove.isSentinel()) {
            return false;
        }

        if (!nodeToRemove.left.isSentinel() && !nodeToRemove.right.isSentinel()) {
            let successor = this.findMin(nodeToRemove.right);
            nodeToRemove.key = successor.key;
            nodeToRemove = successor;
        }

        let child = nodeToRemove.left.isSentinel() ? nodeToRemove.right : nodeToRemove.left;
        child.parent = nodeToRemove.parent;

        if (nodeToRemove.parent === null) {
            this.#root = child;
        } else if (nodeToRemove === nodeToRemove.parent.left) {
            nodeToRemove.parent.left = child;
        } else {
            nodeToRemove.parent.right = child;
        }

        this.#size--;
        return true;
    }

    findMin(node) {
        while (!node.left.isSentinel()) {
            node = node.left;
        }
        return node;
    }

    add(key) {
        if (key === null) {
            throw new Error("Key cannot be null");
        }

        if (this.isEmpty()) {
            this.#root = new Node(key, null);
            this.#root.left = new Node(null, this.#root);
            this.#root.right = new Node(null, this.#root);
            this.#size++;
            return;
        }

        let node = this.findKeyLocation(this.#root, key);

        if (node.isSentinel()) {
            let parent = node.parent;
            let newNode = new Node(key, parent);
            newNode.left = new Node(null, newNode);
            newNode.right = new Node(null, newNode);

            if (node === parent.left) {
                parent.left = newNode;
            } else if (node === parent.right) {
                parent.right = newNode;
            }

            this.#size++;
        }
    }

    findKeyLocation(node, key) {
        while (!node.isSentinel()) {
            let cmp = (key < node.key) ? -1 : (key > node.key) ? 1 : 0;
            if (cmp === 0) {
                return node;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    addAll(collection) {
        collection.forEach(item => this.add(item));
    }

    contains(key) {
        let node = this.findKeyLocation(this.#root, key);
        return !node.isSentinel();
    }

    keys() {
        let keysList = [];
        this.collectKeys(this.#root, keysList);
        return keysList;
    }

    collectKeys(node, keysList) {
        if (!node.isSentinel()) {
            this.collectKeys(node.left, keysList);
            keysList.push(node.key);
            this.collectKeys(node.right, keysList);
        }
    }

    union(other) {
        let result = new BinarySearchTreeSet();
        this.keys().forEach(key => result.add(key));
        other.keys().forEach(key => result.add(key));
        return result;
    }

    intersection(other) {
        let result = new BinarySearchTreeSet();
        this.keys().forEach(key => {
            if (other.contains(key)) {
                result.add(key);
            }
        });
        return result;
    }

    difference(other) {
        let result = new BinarySearchTreeSet();
        this.keys().forEach(key => {
            if (!other.contains(key)) {
                result.add(key);
            }
        });
        return result;
    }

    toString() {
        return this.keys().toString();
    }

    toStringFormat() {
        let sb = [];
        this.toStringFormatHelper(this.#root, 0, sb);
        return sb.join("");
    }

    toStringFormatHelper(node, depth, sb) {
        if (!node.isSentinel()) {
            this.toStringFormatHelper(node.right, depth + 1, sb);
            let space = (depth > 0) ? "  ".repeat(depth - 1) + "--" : "";
            let parent = (depth > 0) ? node.parent.key.toString() : "";
            sb.push(`${space}(${node.key})${parent}\n`);
            this.toStringFormatHelper(node.left, depth + 1, sb);
        }
    }
}

class Node {
    constructor(key, parent) {
        this.key = key;
        this.left = this.right = null;
        this.parent = parent;
    }

    isSentinel() {
        return this.key === null;
    }
}
