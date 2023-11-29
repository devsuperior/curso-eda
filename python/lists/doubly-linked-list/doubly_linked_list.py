import sys
sys.path.append('..')

class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def clear(self):
        self.head = None
        self.tail = None
        self.size = 0

    def is_empty(self):
        return self.head is None

    def get_size(self):
        return self.size

    def add_at_start(self, elem):
        node = Node(elem)
        if self.is_empty():
            self.head = node
            self.tail = node
            self.size += 1
            return
        node.next = self.head
        self.head.prev = node
        self.head = node
        self.size += 1

    def add_at_end(self, elem):
        node = Node(elem)
        if self.is_empty():
            self.head = node
            self.tail = node
            self.size += 1
            return
        node.prev = self.tail
        self.tail.next = node
        self.tail = node
        self.size += 1

    def add_at_position(self, index, elem):
        if index == 0:
            self.add_at_start(elem)
            return
        if not self.get(index) or index == self.get_size():
            self.add_at_end(elem)
            return
        node = Node(elem)
        current = self.get_node(index - 1)
        current.next.prev = node
        node.next = current.next
        node.prev = current
        current.next = node
        self.size += 1

    def get(self, index):
        current = self.get_node(index)
        return current.value if current else None

    def get_node(self, index):
        if index < 0 or index >= self.get_size():
            return None

        current = self.head
        currentIndex = 0
        while current is not None and currentIndex < index:
            current = current.next
            currentIndex += 1
        return current

    def contains(self, elem):
        index_elem = self.index_of(elem)
        return index_elem != -1

    def index_of(self, elem):
        current = self.head
        index = 0
        while current:
            if current.value == elem:
                return index
            current = current.next
            index += 1
        return -1

    def remove_head(self):
        node = self.head
        self.head = self.head.next

        if self.head is None:
            self.tail = None
        else:
            self.head.prev = None
        self.size -= 1
        return node

    def remove_tail(self):
        node = self.tail
        self.tail = self.tail.prev

        if self.tail is None:
            self.head = None
        else:
            self.tail.next = None
        self.size -= 1
        return node

    def remove_at_position(self, index):
        if self.is_empty() or not self.get(index):
            return None
        if index == 0:
            return self.remove_head().value
        if index == self.get_size() - 1:
            return self.remove_tail().value
        current = self.get_node(index)
        current.prev.next = current.next
        current.next.prev = current.prev
        self.size -= 1
        return current.value

    def remove(self, elem):
        index = self.index_of(elem)
        if self.is_empty() or index == -1:
            return False
        self.remove_at_position(index)
        return True

    def reverse(self):
        node_head = self.head
        node_tail = self.tail

        self.head = node_tail
        self.tail = node_head

        current = node_head
        aux = None
        while current:
            aux = current.next
            current.next = current.prev
            current.prev = aux
            current = aux

    def to_array(self):
        current = self.head
        vect = []

        while current:
            vect.append(current.value)
            current = current.next
        return vect
