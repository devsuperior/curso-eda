from binary_search_tree_set import BinarySearchTreeSet

A = BinarySearchTreeSet([1, 2, 3, 4, 5])
B = BinarySearchTreeSet([4, 5, 6, 7, 8])

print("Conjunto A:", A)
print("Conjunto B:", B)

A.add(9)
print("Conjunto A após adicionar 9:", A)

A.remove(9)
print("Conjunto A após remover 9:", A)

print("5 pertence ao conjunto A?", A.contains(5))
print("Conjunto A está vazio?", A.is_empty())
print("Tamanho do conjunto A:", A.size())

C = A.union(B)
print("União dos conjuntos A e B (Conjunto C):", C)

C = A.intersection(B)
print("Interseção dos conjuntos A e B (Conjunto C):", C)

C = A.difference(B)
print("Diferença entre os conjuntos A e B (Conjunto C):", C)
