from generic_tree import GenericTree


def print_tree(tree):
    def print_recursive(tree, pos, depth):
        spaces = "   " * depth
        print(spaces + pos.element())
        for child in tree.children(pos):
            print_recursive(tree, child, depth + 1)

    print_recursive(tree, tree.root(), 0)


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

print("Size =", my_tree.size())
print("isEmpty =", my_tree.is_empty())

print("\nManual print:")
print_tree(my_tree)

pos1 = my_tree.find_bfs("Métodos")

if pos1:
    my_tree.remove(pos1)
    print("\nSize após remoção =", my_tree.size())
    print("\nManual print:")
    print_tree(my_tree)

pos2 = my_tree.find_bfs("Para quem é este livro")
if pos2:
    my_tree.replace(pos2, "Público alvo")
    print("\nManual print depois de replace:")
    print_tree(my_tree)

pos3 = my_tree.find_bfs("Livro Azul")
pos4 = my_tree.find_bfs("Capítulo 1")
pos5 = my_tree.find_bfs("Aplicações")

print("\nLivro Azul isExternal:", my_tree.is_external(pos3))
print("Livro Azul isRoot:", my_tree.is_root(pos3))
print("Capítulo 1 isExternal:", my_tree.is_external(pos4))
print("Capítulo 1 isRoot:", my_tree.is_root(pos4))
print("Aplicações isExternal:", my_tree.is_external(pos5))
print("Aplicações isRoot:", my_tree.is_root(pos5))

print("\nBFS:")
for element in my_tree.elements_bfs():
    print(element)

print("\nDFS:")
for element in my_tree.elements_dfs():
    print(element)

