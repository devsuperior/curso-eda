export default class Node {

    #element;
    #parent;
    #children;

    constructor(element, parent = null) {
        this.#element = element;
        this.#parent = parent;
        this.#children = [];
    }

    element() {
        return this.#element;
    }

    _setElement(element) {
        this.#element = element;
    }

    _getParent() {
        return this.#parent;
    }

    _setParent(parent) {
        this.#parent = parent;
    }

    _getChildren() {
        return this.#children;
    }

    _addChild(child) {
        this.#children.push(child);
        child._setParent(this);
    }

    _removeChild(child) {
        this.#children = this.#children.filter(c => c !== child);
        child._setParent(null);
    }

    _isLeaf() {
        return this.#children.length === 0;
    }
}
