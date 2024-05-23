class DisjointSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.components = n

    # acha parent da componente atual
    def find(self, x):
        while self.parent[x] != x:
            x = self.parent[x]
        return x

    # une duas componentes a partir dos parents
    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX != rootY:
            self.parent[rootY] = rootX
            self.components -= 1

def minimumCost(n, connections):
    def kruskal(numVertices, edges):
        # ordenar crescentemente por peso
        edges.sort(key=lambda x: x[2])

        # criar estruturas de apoio
        disjointSet = DisjointSet(numVertices)
        totalWeight = 0

        # percorrer a lista de arestas ordenada
        for u, v, weight in edges:
            # se estiverem em componentes diferentes, faz a união
            if disjointSet.find(u - 1) != disjointSet.find(v - 1):
                disjointSet.union(u - 1, v - 1)
                totalWeight += weight

        # Verificar se todas as vértices estão conectadas
        if disjointSet.components > 1:
            return -1  # Não é possível formar uma árvore mínima

        return totalWeight

    return kruskal(n, connections)

# Exemplo 1
n = 3
connections = [[1, 2, 5], [1, 3, 6], [2, 3, 1]]
print(minimumCost(n, connections))  # Output esperado: 6

# Exemplo 2
n = 4
connections = [[1, 2, 3], [3, 4, 4]]
print(minimumCost(n, connections))  # Output esperado: -1
