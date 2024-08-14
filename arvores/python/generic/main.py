from generic_tree import GenericTree
from collections import deque


def print_tree(tree):
    print_recursive(tree.root(), tree, 0)


def print_recursive(position, tree, depth):
    if position is None:
        return
    spaces = "    " * depth
    print(spaces + position.element())
    for child in tree.children(position):
        print_recursive(child, tree, depth + 1)


def print_bfs(tree):
    if tree.is_empty():
        return
    queue = deque([tree.root()])
    while queue:
        position = queue.popleft()
        print(position.element())
        queue.extend(tree.children(position))


my_tree = GenericTree()

root = my_tree.add("Livro Azul", None)
intro = my_tree.add("Introdução", root)
cap1 = my_tree.add("Capítulo 1", root)
cap2 = my_tree.add("Capítulo 2", root)

my_tree.add("Para quem é este livro", intro)
my_tree.add("Agradecimentos", intro)

my_tree.add("Conceitos", cap1)
my_tree.add("Aplicações", cap1)

cap2_sec1 = my_tree.add("Métodos", cap2)
my_tree.add("Problema terreno", cap2)
my_tree.add("Problema carros", cap2)

my_tree.add("Método recursivo", cap2_sec1)
my_tree.add("Método imperativo", cap2_sec1)

print("size:", my_tree.size())
print("isEmpty:", my_tree.is_empty())

pos1 = my_tree.find("Livro Azul")
pos2 = my_tree.find("Capítulo 1")
pos3 = my_tree.find("Aplicações")

print("\nLivro Azul:")
if pos1:
    print("Encontrado")
    print("isExternal:", my_tree.is_external(pos1))
    print("isRoot:", my_tree.is_root(pos1))
    parent = my_tree.parent(pos1)
    if parent is not None:
        print("parent:", parent.element())
else:
    print("NÃO encontrado")

print("\nCapítulo 1:")
if pos2:
    print("Encontrado")
    print("isExternal:", my_tree.is_external(pos2))
    print("isRoot:", my_tree.is_root(pos2))
    parent = my_tree.parent(pos2)
    if parent is not None:
        print("parent:", parent.element())
else:
    print("NÃO encontrado")

print("\nAplicações:")
if pos3:
    print("Encontrado")
    print("isExternal:", my_tree.is_external(pos3))
    print("isRoot:", my_tree.is_root(pos3))
    parent = my_tree.parent(pos3)
    if parent is not None:
        print("parent:", parent.element())
else:
    print("NÃO encontrado")

pos4 = my_tree.find("Conceitos")
my_tree.replace(pos4, "Conceitos básicos")

print("\nPRINT DFS PRE ORDER:")
print_tree(my_tree)

print("\nPRINT elements():")
for elem in my_tree.elements():
    print(elem)

print("\nPRINT positions():")
for pos in my_tree.positions():
    print(pos.element())

print("\nPRINT BFS:")
print_bfs(my_tree)

pos5 = my_tree.find("Métodos")
if pos5:
    my_tree.remove(pos5)
    print("\nPRINT remove:")
    print("SIZE =", my_tree.size())
    print_tree(my_tree)
