def min_cost_frog(heights):
    n = len(heights)
    memo = [-1] * n
    
    # Função recursiva com memoização
    def solve(ind):
        nonlocal memo, heights, n
        if ind >= n:
            return float('inf')
        if ind == n - 1:
            return 0
        if memo[ind] != -1:
            return memo[ind]
        
        jump1_cost = solve(ind + 1) + abs(heights[ind] - heights[ind + 1]) if ind + 1 < n else float('inf')
        jump2_cost = solve(ind + 2) + abs(heights[ind] - heights[ind + 2]) if ind + 2 < n else float('inf')
        
        memo[ind] = min(jump1_cost, jump2_cost)
        return memo[ind]
    
    # Chamada inicial da função com o índice 0 (pedra inicial)
    return solve(0)

# Teste dos casos fornecidos
print(min_cost_frog([10, 30, 40, 20]))   # Saída esperada: 30
print(min_cost_frog([10, 10]))          # Saída esperada: 0
print(min_cost_frog([30, 10, 60, 10, 60, 50]))   # Saída esperada: 40
