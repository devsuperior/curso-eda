class Node:
    def __init__(self, value) -> None:
        self.value = value
        self.next = None

class LinkedList:
    def __init__(self) -> None:
        self.head = None
        self.size = 0

    def clear(self):
        self.head = None
        self.size = 0

    def isEmpty(self):
        if self.head == None:
            return True
        return False
    
    def getSize(self):
        return self.size
    
    def addAtStart(self, elem):
        node = Node(elem)
        if self.isEmpty():
            self.head = node
            self.size += 1
            return
        aux = self.head
        self.head = node
        node.next = aux
        self.size += 1

    def addAtEnd(self, elem):
        node = Node(elem)
        if self.head == None:
            self.head = node
            self.size += 1
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = node
        self.size += 1

    def addAtPosition(self, index, elem):
        if index == 0:
            self.addAtStart(elem)
            return
        if not self.get(index):
            self.addAtEnd(elem)
            return
        node = Node(elem)
        aux = self.getNode(index - 1)
        node.next = aux.next
        aux.next = node
        self.size += 1
        
    def get(self, index):
        current = self.getNode(index)
        if current:
            return current.value
        return None

    def getNode(self, index):
        if index < 0 or index > self.getSize():
            return None
        current = self.head
        i = 0
        while i != index:
            current = current.next
            i += 1
        if current:
            return current
        return None
    
    def contains(self, elem):
        indexElem = self.indexOf(elem)
        if indexElem != -1:
            return True
        return False
    
    def indexOf(self, elem):
        current = self.head
        i = 0
        while current:
            if current.value == elem:
                return i
            current = current.next
            i += 1
        return -1
    
    def removeAtPosition(self, index):
        if self.isEmpty() or not self.getNode(index):
            return None

        item = None
        aux = None
        if index == 0:
            item = self.head.value
            self.head = self.head.next
            self.size -= 1
            return item

        if index == self.getSize() - 1:
            item = self.get(index)
            aux = self.getNode(index - 1)
            aux.next = None
            self.size -= 1
            return item

        aux = self.getNode(index - 1)
        item = aux.next.value
        aux.next = aux.next.next
        self.size -= 1
        return item
    
    def remove(self, elem):
        index = self.indexOf(elem)
        if self.isEmpty() or index == -1:
            return False
        self.removeAtPosition(index)
        return True
    
    def toArray(self):
        current = self.head
        vect = []
        while current:
            vect.append(current.value)
            current = current.next
        return vect
        
# list = LinkedList()
# list.addAtStart(10)
# list.addAtStart(20)
# list.addAtEnd(30)
# list.addAtEnd(40)
# list.addAtPosition(1, 50)

# print(list.toArray())

# list.remove(30)
# list.remove(100)
# list.removeAtPosition(2)
# list.removeAtPosition(-1)

# print(list.toArray())

