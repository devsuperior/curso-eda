from queue1 import Queue1

queue = Queue1()

print("queue.count():", queue.count())
print("queue.is_empty():", queue.is_empty())

queue.add("Maria")
queue.add("Joao")
queue.add("Ana")
print("Adicionados: Maria, Joao, Ana")

print("queue.count():", queue.count())
print("queue.is_empty():", queue.is_empty())
print("queue.peek():", queue.peek())

print("Itens:")
while not queue.is_empty():
    print(queue.remove())
