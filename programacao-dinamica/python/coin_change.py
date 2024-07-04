def coin_change(coins, amount):
    # Cria uma lista de memoização inicializada com Infinity
    memo = [float('inf')] * (amount + 1)
    # Caso base: 0 moedas são necessárias para fazer o valor 0
    memo[0] = 0

    # Preenche a tabela dp de 1 até amount
    for i in range(1, amount + 1):
        for coin in coins:
            if i - coin >= 0:
                memo[i] = min(memo[i], memo[i - coin] + 1)

    # Retorna o resultado para dp[amount]
    if memo[amount] == float('inf'):
        return -1
    return memo[amount]

# Teste dos casos fornecidos
print(coin_change([1, 2, 5], 11))      # Saída esperada: 3
print(coin_change([2], 3))            # Saída esperada: -1
print(coin_change([1, 2, 3, 7, 11], 10000))  # Saída esperada: 910
