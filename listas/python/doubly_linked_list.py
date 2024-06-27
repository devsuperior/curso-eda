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
        if index == self.get_size():
            self.add_at_end(elem)
            return
        node = Node(elem)
        current = self.get_node(index - 1)
        node.next = current.next
        node.prev = current
        current.next.prev = node
        current.next = node
        self.size += 1

    def get(self, index):
        current = self.get_node(index)
        return current.value if current else None

    def get_node(self, index):
        if index < 0 or index >= self.get_size():
            return None
        current = self.head
        for _ in range(index):
            current = current.next
        return current

    def contains(self, elem):
        return self.index_of(elem) != -1

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
        if self.is_empty():
            return None
        node = self.head
        self.head = self.head.next
        if self.head:
            self.head.prev = None
        else:
            self.tail = None
        self.size -= 1
        return node.value

    def remove_tail(self):
        if self.is_empty():
            return None
        node = self.tail
        self.tail = self.tail.prev
        if self.tail:
            self.tail.next = None
        else:
            self.head = None
        self.size -= 1
        return node.value

    def remove_at_position(self, index):
        if self.is_empty() or index < 0 or index >= self.get_size():
            return None
        if index == 0:
            return self.remove_head()
        if index == self.get_size() - 1:
            return self.remove_tail()
        current = self.get_node(index)
        current.prev.next = current.next
        current.next.prev = current.prev
        self.size -= 1
        return current.value

    def remove(self, elem):
        index = self.index_of(elem)
        if index == -1:
            return False
        self.remove_at_position(index)
        return True

    def reverse(self):
        current = self.head
        while current:
            current.next, current.prev = current.prev, current.next
            current = current.prev
        self.head, self.tail = self.tail, self.head

    def to_array(self):
        elements = []
        current = self.head
        while current:
            elements.append(current.value)
            current = current.next
        return elements
