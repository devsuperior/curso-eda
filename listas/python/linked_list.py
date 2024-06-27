class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
        self.size = 0

    def clear(self):
        self.head = None
        self.size = 0

    def is_empty(self):
        return self.head is None

    def get_size(self):
        return self.size

    def add_at_start(self, elem):
        node = Node(elem)
        if self.is_empty():
            self.head = node
            self.size += 1
            return
        aux = self.head
        self.head = node
        node.next = aux
        self.size += 1

    def add_at_end(self, elem):
        node = Node(elem)
        if self.head is None:
            self.head = node
            self.size += 1
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = node
        self.size += 1

    def add_at_position(self, index, elem):
        if index == 0:
            self.add_at_start(elem)
            return
        if not self.get(index):
            self.add_at_end(elem)
            return
        node = Node(elem)
        aux = self.get_node(index - 1)
        node.next = aux.next
        aux.next = node
        self.size += 1

    def get(self, index):
        current = self.get_node(index)
        if current:
            return current.value
        return None

    def get_node(self, index):
        if index < 0 or index >= self.get_size():
            return None
        current = self.head
        i = 0
        while i != index:
            current = current.next
            i += 1
        return current

    def contains(self, elem):
        return self.index_of(elem) != -1

    def index_of(self, elem):
        current = self.head
        i = 0
        while current:
            if current.value == elem:
                return i
            current = current.next
            i += 1
        return -1

    def remove_at_position(self, index):
        if self.is_empty() or not self.get(index):
            return None
        item = None
        if index == 0:
            item = self.head.value
            self.head = self.head.next
            self.size -= 1
            return item
        if index == self.get_size() - 1:
            item = self.get(index)
            aux = self.get_node(index - 1)
            aux.next = None
            self.size -= 1
            return item
        aux = self.get_node(index - 1)
        item = aux.next.value
        aux.next = aux.next.next
        self.size -= 1
        return item

    def remove(self, elem):
        index = self.index_of(elem)
        if self.is_empty() or index == -1:
            return False
        self.remove_at_position(index)
        return True

    def to_array(self):
        current = self.head
        arr = []
        while current:
            arr.append(current.value)
            current = current.next
        return arr
