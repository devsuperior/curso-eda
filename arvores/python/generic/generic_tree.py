from node import Node


class GenericTree:
    def __init__(self):
        self._root = None
        self._size = 0

    def size(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def elements(self):
        lst = []
        self._collect_elements(lst, self._root)
        return lst

    def _collect_elements(self, lst, node):
        if node is not None:
            lst.append(node.element())
            for child in node._get_children():
                self._collect_elements(lst, child)

    def positions(self):
        lst = []
        self._collect_positions(lst, self._root)
        return lst

    def _collect_positions(self, lst, node):
        if node is not None:
            lst.append(node)
            for child in node._get_children():
                self._collect_positions(lst, child)

    def find(self, element):
        return self._find_recursive(self._root, element)

    def _find_recursive(self, node, target):
        if node is None:
            return None
        if node.element() == target:
            return node
        for child in node._get_children():
            found = self._find_recursive(child, target)
            if found:
                return found
        return None

    def _validate(self, position):
        if not isinstance(position, Node):
            raise ValueError("Invalid position type")
        if position._get_parent() is position:
            raise ValueError("Removed node")
        return position

    def add(self, element, parent):
        if not self.is_empty() and parent is None:
            raise ValueError("Parent position can't be null for a non-empty tree")
        parent_node = self._validate(parent) if parent else None
        new_node = Node(element, parent_node)
        if parent_node is None:
            self._root = new_node
        else:
            parent_node._add_child(new_node)
        self._size += 1
        return new_node

    def children(self, position):
        node = self._validate(position)
        return node._get_children().copy()

    def root(self):
        return self._root

    def is_external(self, position):
        node = self._validate(position)
        return node._is_leaf()

    def is_root(self, position):
        node = self._validate(position)
        return node == self._root

    def parent(self, position):
        node = self._validate(position)
        return node._get_parent()

    def replace(self, position, element):
        node = self._validate(position)
        node._set_element(element)

    def remove(self, position):
        node = self._validate(position)
        if node == self._root:
            self._root = None
        else:
            parent = node._get_parent()
            if parent:
                parent._remove_child(node)
        self._size -= self._subtree_size(node)
        self._mark_as_removed(node)

    def _mark_as_removed(self, node):
        node._set_parent(node)
        for child in node._get_children():
            self._mark_as_removed(child)

    def _subtree_size(self, node):
        children_size = 0
        for child in node._get_children():
            children_size += self._subtree_size(child)
        return 1 + children_size
