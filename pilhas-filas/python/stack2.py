class Stack2:
    def __init__(self):
        self.list = []

    def is_empty(self):
        return len(self.list) == 0

    def push(self, item):
        self.list.append(item)

    def pop(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        return self.list.pop()

    def peek(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        return self.list[-1]

    def count(self):
        return len(self.list)

    def clear(self):
        self.list = []
