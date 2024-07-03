from collections import deque

queue = deque()

print(f"queue.size(): {len(queue)}")
print(f"queue.isEmpty(): {len(queue) == 0}")

queue.append("Maria")
queue.append("Joao")
queue.append("Ana")
print("Adicionados: Maria, Joao, Ana")

print(f"queue.size(): {len(queue)}")
print(f"queue.isEmpty(): {len(queue) == 0}")
print(f"queue.peek(): {queue[0]}")

print("Itens:")
while queue:
    print(queue.popleft())
