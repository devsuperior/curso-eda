def min_path_sum(grid):
    n = len(grid)
    m = len(grid[0])

    # Criando matriz de memoização e inicializando com 0
    memo = [[0] * m for _ in range(n)]

    memo[0][0] = grid[0][0]

    # Inicializando primeira coluna
    for i in range(1, n):
        memo[i][0] = memo[i - 1][0] + grid[i][0]

    # Inicializando primeira linha
    for j in range(1, m):
        memo[0][j] = memo[0][j - 1] + grid[0][j]

    # Aplicando tabulação
    for i in range(1, n):
        for j in range(1, m):
            memo[i][j] = min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j]

    return memo[n - 1][m - 1]

# Casos de teste
print(min_path_sum([[1,3,1],[1,5,1],[4,2,1]]))  # Saída esperada: 7
print(min_path_sum([[1,2,3],[4,5,6]]))  # Saída esperada: 12
