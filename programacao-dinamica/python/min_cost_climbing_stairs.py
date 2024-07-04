def min_cost_climbing_stairs(cost):
    memo = [-1] * (len(cost) + 1)  # Inicializa o array de memoização

    return min_cost_climbing_stairs_util(len(cost), cost, memo)

def min_cost_climbing_stairs_util(n, cost, memo):
    if n == 0 or n == 1:
        return 0

    if memo[n] != -1:
        return memo[n]

    memo[n] = min(
        min_cost_climbing_stairs_util(n - 1, cost, memo) + cost[n - 1],
        min_cost_climbing_stairs_util(n - 2, cost, memo) + cost[n - 2]
    )

    return memo[n]

# Casos de teste
cost1 = [10, 15, 20]
print(min_cost_climbing_stairs(cost1))  # Saída esperada: 15

cost2 = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
print(min_cost_climbing_stairs(cost2))  # Saída esperada: 6
