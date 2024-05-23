def dijkstra(s, numVertices, adjList):
    dist = [float('inf')] * numVertices
    visited = [False] * numVertices

    # Inicializar distâncias até a origem
    dist[s] = 0

    # Loop para garantir que todos os vértices sejam processados
    for _ in range(numVertices):
        current = -1

        for i in range(numVertices):
            if visited[i]:
                continue

            # Seleciona o vértice mais próximo
            if current == -1 or dist[i] < dist[current]:
                current = i

        if current == -1:
            break  # Todos os vértices restantes são inatingíveis
        visited[current] = True

        # Percorrer vizinhos de current
        for neighbour, w in adjList[current]:
            # Tentar relaxar vizinho w
            if dist[current] + w < dist[neighbour]:
                dist[neighbour] = dist[current] + w

    # Encontre a maior distância mínima calculada durante o algoritmo de Dijkstra
    maxMinDist = max(dist)
    return -1 if maxMinDist == float('inf') else maxMinDist

def networkDelayTime(times, n, k):
    adjList = [[] for _ in range(n)]

    for u, v, w in times:
        adjList[u - 1].append((v - 1, w))

    return dijkstra(k - 1, n, adjList)

# Exemplo 1
times = [[2, 1, 1], [2, 3, 1], [3, 4, 1]]
n = 4
k = 2
print(networkDelayTime(times, n, k)) 

# Exemplo 2
times = [[1, 2, 1]]
n = 2
k = 1
print(networkDelayTime(times, n, k)) 

# Exemplo 3
times = [[1, 2, 1]]
n = 2
k = 2
print(networkDelayTime(times, n, k)) 
