def validPath(n, edges, source, destination):
    # Armazena todas as arestas de acordo com os nós em 'graph'
    adj_list = [[] for _ in range(n)]
    for edge in edges:
        a, b = edge
        adj_list[a].append(b)
        adj_list[b].append(a)

    # Começa do nó fonte, adiciona-o à pilha
    visited = [False] * n
    visited[source] = True
    stack = [source]

    while stack:
        currNode = stack.pop()
        if currNode == destination:
            return True
        # Adiciona todos os vizinhos não visitados do nó atual à pilha
        # e marca como visitado
        for neighbour in adj_list[currNode]:
            if not visited[neighbour]:
                visited[neighbour] = True
                stack.append(neighbour)

    return False

# Exemplo 1
n = 3
edges = [[0, 1], [1, 2], [2, 0]]
source = 0
destination = 2
print(validPath(n, edges, source, destination))

# Exemplo 2
n = 6
edges = [[0, 1], [0, 2], [3, 5], [5, 4], [4, 3]]
source = 0
destination = 5
print(validPath(n, edges, source, destination))
