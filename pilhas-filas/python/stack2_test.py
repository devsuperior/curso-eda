from stack2 import Stack2

stack = Stack2()

print(f"stack.count(): {stack.count()}")
print(f"stack.is_empty(): {stack.is_empty()}")

stack.push("Maria")
stack.push("Joao")
stack.push("Ana")
print("Adicionados: Maria, Joao, Ana")

print(f"stack.count(): {stack.count()}")
print(f"stack.is_empty(): {stack.is_empty()}")
print(f"stack.peek(): {stack.peek()}")

print("Itens:")
while not stack.is_empty():
    print(stack.pop())
