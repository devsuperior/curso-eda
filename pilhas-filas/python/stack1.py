class Stack1:
    def __init__(self, size=100):
        self.size = size
        self.arr = [None] * size
        self.top = -1

    def is_empty(self):
        return self.top == -1

    def is_full(self):
        return self.top == self.size - 1

    def push(self, item):
        if self.is_full():
            raise Exception("Stack is full")
        self.top += 1
        self.arr[self.top] = item

    def pop(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        item = self.arr[self.top]
        self.top -= 1
        return item

    def peek(self):
        if self.is_empty():
            raise Exception("Stack is empty")
        return self.arr[self.top]

    def count(self):
        return self.top + 1

    def clear(self):
        self.top = -1
