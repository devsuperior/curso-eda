# Inicializando os conjuntos A e B
A = {1, 2, 3, 4, 5}
B = {4, 5, 6, 7, 8}

# Mostrando os conteúdos dos conjuntos A e B
print(f"Conjunto A: {A}")
print(f"Conjunto B: {B}")

# Adicionando um novo número ao conjunto A
A.add(9)
print(f"Conjunto A após adicionar 9: {A}")

# Removendo o número adicionado do conjunto A
A.remove(9)
print(f"Conjunto A após remover 9: {A}")

# Testando se um elemento pertence ao conjunto A
print(f"5 pertence ao conjunto A? {5 in A}")

# Testando se o conjunto A está vazio
print(f"Conjunto A está vazio? {len(A) == 0}")

# Testando o tamanho do conjunto A
print(f"Tamanho do conjunto A: {len(A)}")

# União dos conjuntos A e B, salvando o resultado em um conjunto C
C1 = A | B
C2 = set(A)
C2.update(B)
print(f"União dos conjuntos A e B (Conjunto C1): {C1}")
print(f"União dos conjuntos A e B (Conjunto C2): {C2}")

# Interseção dos conjuntos A e B, salvando o resultado em um conjunto C
C1 = A & B
C2 = set(A)
C2.intersection_update(B)
print(f"Interseção dos conjuntos A e B (Conjunto C1): {C1}")
print(f"Interseção dos conjuntos A e B (Conjunto C2): {C2}")

# Diferença entre os conjuntos A e B, salvando o resultado em um conjunto C
C1 = A - B
C2 = set(A)
C2.difference_update(B)
print(f"Diferença entre os conjuntos A e B (Conjunto C1): {C1}")
print(f"Diferença entre os conjuntos A e B (Conjunto C2): {C2}")
