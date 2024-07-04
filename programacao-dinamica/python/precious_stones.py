def maxProfit(n, values):
    # Cria um array memo de tamanho n+1 e inicializa com -1
    memo = [-1] * (n + 1)
    
    # Chama a função util para obter o valor máximo
    return util(n, values, memo)

# Função auxiliar util para calcular o valor máximo
def util(n, values, memo):
    # Caso base: se n for 0, o valor máximo é 0
    if n == 0:
        return 0
    
    # Se o valor já foi calculado anteriormente, retorna-o
    if memo[n] != -1:
        return memo[n]
    
    # Inicializa memo[n] com 0
    memo[n] = 0
    
    # Itera de 1 até n para encontrar o valor máximo
    for i in range(1, n + 1):
        # Se for possível cortar a barra de tamanho i
        if n - i >= 0:
            # Atualiza memo[n] com o valor máximo encontrado
            memo[n] = max(memo[n], util(n - i, values, memo) + values[i - 1])
    
    # Retorna o valor máximo calculado para o tamanho n
    return memo[n]

# Casos de teste
n1 = 4
values1 = [2, 5, 7, 9]
print(maxProfit(n1, values1))

n2 = 8
values2 = [1, 5, 8, 9, 10, 17, 17, 20]
print(maxProfit(n2, values2))

n3 = 8
values3 = [3, 5, 8, 9, 10, 17, 17, 20]
print(maxProfit(n3, values3))