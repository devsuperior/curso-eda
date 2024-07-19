from collections import deque
from node import Node


class GenericTree:
    def __init__(self):
        self.__root = None
        self.__size = 0

    def size(self):
        return self.__size

    def is_empty(self):
        return self.__size == 0

    def elements_dfs(self):
        elements = []
        self.__collect_elements(elements, self.__root)
        return elements

    def __collect_elements(self, list, node):
        if node:
            list.append(node.element())
            for child in node._get_children():
                self.__collect_elements(list, child)

    def elements_bfs(self):
        elements = []
        if self.__root is None:
            return elements

        queue = deque([self.__root])
        while queue:
            current = queue.popleft()
            elements.append(current.element())
            for child in current._get_children():
                queue.append(child)

        return elements

    def positions(self):
        positions = []
        self.__collect_positions(positions, self.__root)
        return positions

    def __collect_positions(self, list, node):
        if node:
            list.append(node)
            for child in node._get_children():
                self.__collect_positions(list, child)

    def replace(self, position, element):
        node = self.__validate(position)
        node._set_element(element)

    def root(self):
        if self.is_empty():
            raise ValueError("The tree is empty")
        return self.__root

    def parent(self, position):
        node = self.__validate(position)
        if node is self.__root:
            raise ValueError("The root has no parent")
        return node._get_parent()

    def children(self, position):
        node = self.__validate(position)
        return list(node._get_children())

    def is_external(self, position):
        node = self.__validate(position)
        return len(node._get_children()) == 0

    def is_root(self, position):
        node = self.__validate(position)
        return node is self.__root

    def __validate(self, position):
        if not isinstance(position, Node):
            raise ValueError("Invalid position type")
        if position._get_parent() == position:  # Convention to indicate 'deleted' or 'not part of the tree'
            raise ValueError("Node is no longer in the tree")
        return position

    def add(self, element, parent_pos):
        if not self.is_empty() and parent_pos is None:
            raise ValueError("Parent position can't be null for a non-empty tree")
        parent = None if parent_pos is None else self.__validate(parent_pos)
        new_node = Node(element, parent)
        if parent is None:
            self.__root = new_node
        else:
            parent._add_child(new_node)
        self.__size += 1
        return new_node

    def remove(self, position):
        node = self.__validate(position)
        if node is self.__root:
            self.__root = None
        else:
            parent = node._get_parent()
            if parent:
                parent._remove_child(node)
        self.__size -= self.__subtree_size(node)
        self.__mark_as_removed(node)

    def __subtree_size(self, node):
        subtree_count = 1
        for child in node._get_children():
            subtree_count += self.__subtree_size(child)
        return subtree_count

    def __mark_as_removed(self, node):
        node._set_parent(node)
        for child in node._get_children():
            self.__mark_as_removed(child)

    def find_dfs(self, element):
        return self.__find_recursively(self.__root, element)

    def __find_recursively(self, node, target):
        if node is None:
            return None
        if node.element() == target:
            return node
        for child in node._get_children():
            found = self.__find_recursively(child, target)
            if found:
                return found
        return None

    def find_bfs(self, element):
        if self.__root is None:
            return None

        queue = deque([self.__root])
        while queue:
            current = queue.popleft()

            if current.element() == element:
                return current

            queue.extend(current._get_children())

        return None
