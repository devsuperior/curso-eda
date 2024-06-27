from doubly_linked_list import DoublyLinkedList

lst = DoublyLinkedList()

# 1 - Add at start
lst.add_at_start(2)
lst.add_at_start(9)
print(lst.to_array())

lst.clear()

# 2 - Add at end
lst.add_at_end(2)
lst.add_at_end(4)
lst.add_at_end(8)
lst.add_at_end(32)
lst.add_at_end(128)
print(lst.to_array())

# 3 - Get the size of the list
print(f'Tamanho da lista igual a: {lst.get_size()}')

# 4 - Add at position
lst.add_at_position(3, 16)
print("Adicionado 16 à posição 3:")
print(lst.to_array())

lst.add_at_position(5, 64)
print("Adicionado 64 à posição 5:")
print(lst.to_array())

# 5 - Remove head
lst.remove_head()
print("Removido primeiro elemento:")
print(lst.to_array())

# 6 - Remove tail
lst.remove_tail()
print("Removido último elemento:")
print(lst.to_array())

# 7 - Remove at position
lst.remove_at_position(4)
print("Removido elemento da posição 4:")
print(lst.to_array())

# 8 - Remove
lst.remove(32)
print("Removido elemento 32:")
print(lst.to_array())
lst.remove(4)
print("Removido elemento 4:")
print(lst.to_array())

# 9 - Reverse list
lst.reverse()
print("Lista reversa:")
print(lst.to_array())
