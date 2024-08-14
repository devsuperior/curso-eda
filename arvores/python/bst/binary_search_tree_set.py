class BinarySearchTreeSet:
    class _Node:
        def __init__(self, key, parent):
            self.key = key
            self.parent = parent
            self.left = self.right = None

        def is_sentinel(self):
            return self.key is None

    def __init__(self, collection=None):
        self._size = 0
        self._root = self._Node(None, None)
        if collection is not None:
            self.add_all(collection)

    def size(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def add(self, key):
        if key is None:
            raise ValueError("Key cannot be null")

        if self.is_empty():
            self._root = self._Node(key, None)
            self._root.left = self._Node(None, self._root)
            self._root.right = self._Node(None, self._root)
            self._size += 1
            return

        node = self._find_key_location(self._root, key)
        if node.is_sentinel():
            parent = node.parent
            new_node = self._Node(key, parent)
            new_node.left = self._Node(None, new_node)
            new_node.right = self._Node(None, new_node)
            if node == parent.left:
                parent.left = new_node
            else:
                parent.right = new_node
            self._size += 1

    def remove(self, key):
        if key is None:
            raise ValueError("Key cannot be null")

        node_to_remove = self._find_key_location(self._root, key)
        if node_to_remove.is_sentinel():
            return False

        if not node_to_remove.left.is_sentinel() and not node_to_remove.right.is_sentinel():
            successor = self._find_min(node_to_remove.right)
            node_to_remove.key = successor.key
            node_to_remove = successor

        child = node_to_remove.right if node_to_remove.left.is_sentinel() else node_to_remove.left
        child.parent = node_to_remove.parent

        if node_to_remove.parent is None:
            self._root = child
        elif node_to_remove == node_to_remove.parent.left:
            node_to_remove.parent.left = child
        else:
            node_to_remove.parent.right = child

        self._size -= 1
        return True

    def _find_min(self, node):
        while not node.left.is_sentinel():
            node = node.left
        return node

    def _find_key_location(self, node, key):
        while not node.is_sentinel():
            cmp = (key > node.key) - (key < node.key)
            if cmp == 0:
                return node
            elif cmp < 0:
                node = node.left
            else:
                node = node.right
        return node

    def add_all(self, collection):
        for item in collection:
            self.add(item)

    def contains(self, key):
        node = self._find_key_location(self._root, key)
        return not node.is_sentinel()

    def keys(self):
        keys_list = []
        self._collect_keys(self._root, keys_list)
        return keys_list

    def _collect_keys(self, node, keys_list):
        if not node.is_sentinel():
            self._collect_keys(node.left, keys_list)
            keys_list.append(node.key)
            self._collect_keys(node.right, keys_list)

    def __str__(self):
        return str(self.keys())

    def to_string_format(self):
        sb = []
        self._to_string_format(self._root, 0, sb)
        return ''.join(sb)

    def _to_string_format(self, node, depth, sb):
        if not node.is_sentinel():
            self._to_string_format(node.right, depth + 1, sb)
            space = '  ' * (depth - 1) + '--' if depth > 0 else ''
            parent = node.parent.key if depth > 0 and node.parent else ''
            sb.append(f"{space}({node.key}){parent}\n")
            self._to_string_format(node.left, depth + 1, sb)

    def union(self, other):
        result = BinarySearchTreeSet()
        for key in self.keys():
            result.add(key)
        for key in other.keys():
            result.add(key)
        return result

    def intersection(self, other):
        result = BinarySearchTreeSet()
        for key in self.keys():
            if other.contains(key):
                result.add(key)
        return result

    def difference(self, other):
        result = BinarySearchTreeSet()
        for key in self.keys():
            if not other.contains(key):
                result.add(key)
        return result
