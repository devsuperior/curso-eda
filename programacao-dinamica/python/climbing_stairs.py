def climbStairs(n):
    memo = [-1] * (n + 1)  # Inicializa o array de memoização
    return climbStairsUtil(n, memo)  # Chama a função auxiliar

def climbStairsUtil(n, memo):
    if memo[n] != -1:  # Se o valor já foi calculado, retorna o memo
        return memo[n]

    if n == 0 or n == 1:  # Casos base
        return 1

    memo[n] = climbStairsUtil(n - 1, memo) + climbStairsUtil(n - 2, memo)  # Calcula o valor e armazena no memo
    return memo[n]

# Caso de teste 1
n1 = 2
print(climbStairs(n1))

# Caso de teste 2
n2 = 3
print(climbStairs(n2))

# Caso de teste 3
n3 = 45
print(climbStairs(n3))
