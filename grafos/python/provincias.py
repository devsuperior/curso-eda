def dfs(node, isConnected, visit):
    visit[node] = True
    for i in range(len(isConnected)):
        if isConnected[node][i] == 1 and not visit[i]:
            dfs(i, isConnected, visit)

def findCircleNum(isConnected):
    n = len(isConnected)
    numberOfComponents = 0
    visit = [False] * n

    for i in range(n):
        if not visit[i]:
            numberOfComponents += 1
            dfs(i, isConnected, visit)

    return numberOfComponents

# Exemplo 1
isConnected1 = [
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1]
]
print(findCircleNum(isConnected1))

# Exemplo 2
isConnected2 = [
    [1, 0, 0],
    [0, 1, 0],
    [0, 0, 1]
]
print(findCircleNum(isConnected2))
