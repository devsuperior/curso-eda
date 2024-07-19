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

  elementsDfs() {
    const elements = [];
    this.#collectElements(elements, this.#root);
    return elements;
  }

  #collectElements(list, node) {
    if (node) {
      list.push(node.element());
      node
        ._getChildren()
        .forEach((child) => this.#collectElements(list, child));
    }
  }

  elementsBfs() {
    const elements = [];
    if (!this.#root) return elements;

    const queue = [this.#root];
    while (queue.length > 0) {
      const current = queue.shift();
      elements.push(current.element());
      queue.push(...current._getChildren());
    }

    return elements;
  }

  positions() {
    const positions = [];
    this.#collectPositions(positions, this.#root);
    return positions;
  }

  #collectPositions(list, node) {
    if (node) {
      list.push(node);
      node
        ._getChildren()
        .forEach((child) => this.#collectPositions(list, child));
    }
  }

  replace(position, element) {
    const node = this.#validate(position);
    node._setElement(element);
  }

  root() {
    if (this.isEmpty()) {
      throw new Error("The tree is empty");
    }
    return this.#root;
  }

  parent(position) {
    const node = this.#validate(position);
    if (node === this.#root) {
      throw new Error("The root has no parent");
    }
    return node._getParent();
  }

  children(position) {
    const node = this.#validate(position);
    return [...node._getChildren()];
  }

  isExternal(position) {
    const node = this.#validate(position);
    return node._isLeaf();
  }

  isRoot(position) {
    const node = this.#validate(position);
    return node === this.#root;
  }

  #validate(position) {
    if (!(position instanceof Node)) {
      throw new Error("Invalid position type");
    }
    if (position._getParent() === position) { // Convention to indicate 'deleted' or 'not part of the tree'
      throw new Error("Node is no longer in the tree");
    }
    return position;
  }

  add(element, parentPos) {
    if (!this.isEmpty() && !parentPos) {
      throw new Error("Parent position can't be null for a non-empty tree");
    }
    const parent = parentPos ? this.#validate(parentPos) : null;
    const newNode = new Node(element, parent);
    if (!parent) {
      this.#root = newNode;
    } else {
      parent._addChild(newNode);
    }
    this.#size++;
    return newNode;
  }

  remove(position) {
    const node = this.#validate(position);
    if (node === this.#root) {
      this.#root = null;
    } else {
      const parent = node._getParent();
      if (parent) {
        parent._removeChild(node);
      }
    }
    this.#size -= this.#subtreeSize(node);
    this.#markAsRemoved(node);
  }

  #subtreeSize(node) {
    return (
      1 +
      node
        ._getChildren()
        .reduce((acc, child) => acc + this.#subtreeSize(child), 0)
    );
  }

  #markAsRemoved(node) {
    node._setParent(node); // Convention to indicate 'deleted' or 'not part of the tree'
    node._getChildren().forEach((child) => this.#markAsRemoved(child));
  }

  // DFS to find an element
  findDfs(element) {
    return this.#findRecursively(this.#root, element);
  }

  #findRecursively(node, target) {
    if (!node) {
      return null;
    }
    if (node.element() === target) {
      return node;
    }
    for (const child of node._getChildren()) {
      const found = this.#findRecursively(child, target);
      if (found) {
        return found;
      }
    }
    return null;
  }

  // BFS to find an element
  findBfs(element) {
    if (!this.#root) {
      return null;
    }
    const queue = [this.#root];
    while (queue.length > 0) {
      const current = queue.shift();
      if (current.element() === element) {
        return current;
      }
      queue.push(...current._getChildren());
    }
    return null;
  }
}

