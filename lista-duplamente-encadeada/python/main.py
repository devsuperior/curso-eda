from doubly_linked_list import DoublyLinkedList

# 1 - Add at start
my_list = DoublyLinkedList()
my_list.add_at_start(2)
my_list.add_at_start(9)
print(my_list.to_array())

my_list.clear()

# 2 - Add at end
my_list.add_at_end(2)
my_list.add_at_end(4)
my_list.add_at_end(8)
my_list.add_at_end(32)
my_list.add_at_end(128)
print(my_list.to_array())

# 3 - Get the size of the list
print(f"Tamanho da lista igual a: {my_list.get_size()}")

# 4 - Add at position
my_list.add_at_position(3, 16)
print(my_list.to_array())

my_list.add_at_position(5, 64)
print(my_list.to_array())

# 5 - Remove head
node = my_list.remove_head()
print(f"Removendo do início, elemento {node.value} da lista")
print(my_list.to_array())

# 6 - Remove tail
node = my_list.remove_tail()
print(f"Removendo do final, elemento {node.value} da lista")
print(my_list.to_array())

# 7 - Remove at position
# index = 4
# item = my_list.remove_at_position(index)
# if item is not None:
#     print(f"Removendo elemento {item} da posição {index}")
# else:
#     print(f"Erro ao remover elemento da posição {index}")

# print(my_list.to_array())

# 8 - Remove
# my_list.remove(32)
# my_list.remove(4)
# print(my_list.to_array())

# 9 - Reverse list
my_list.reverse()
print(my_list.to_array())