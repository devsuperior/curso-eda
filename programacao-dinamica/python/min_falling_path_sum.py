def min_falling_path_sum(matrix):
    n = len(matrix)
    INF = float('inf')

    # Criando a matriz de memoização e inicializando a primeira linha
    memo = [[0] * n for _ in range(n)]
    for j in range(n):
        memo[0][j] = matrix[0][j]

    # Preenchendo a matriz usando programação dinâmica
    for i in range(1, n):
        for j in range(n):
            path_a = path_b = path_c = INF
            if is_valid(i - 1, j - 1, n):
                path_a = matrix[i][j] + memo[i - 1][j - 1]
            if is_valid(i - 1, j + 1, n):
                path_b = matrix[i][j] + memo[i - 1][j + 1]
            if is_valid(i - 1, j, n):
                path_c = matrix[i][j] + memo[i - 1][j]

            memo[i][j] = min(path_a, path_b, path_c)

    # Encontrando o mínimo na última linha
    ans = INF
    for j in range(n):
        ans = min(ans, memo[n - 1][j])

    return ans

# Função para verificar se as coordenadas são válidas
def is_valid(i, j, n):
    return 0 <= i < n and 0 <= j < n

# Testes dos casos fornecidos
print(min_falling_path_sum([[2,1,3],[6,5,4],[7,8,9]]))  # Saída esperada: 13
print(min_falling_path_sum([[-19,57],[-40,-5]]))      # Saída esperada: -59
