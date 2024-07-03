class Queue1:
    def __init__(self):
        self.list = []

    def is_empty(self):
        return len(self.list) == 0

    def add(self, item):
        self.list.append(item)

    def remove(self):
        if self.is_empty():
            raise Exception("Queue is empty")
        return self.list.pop(0)

    def peek(self):
        if self.is_empty():
            raise Exception("Queue is empty")
        return self.list[0]

    def count(self):
        return len(self.list)
