def rob(nums):
    def rob_util(nums, i, memo):
        if i < 0:
            return 0
        if memo[i] >= 0:
            return memo[i]
        result = max(rob_util(nums, i - 2, memo) + nums[i], rob_util(nums, i - 1, memo))
        memo[i] = result
        return result
    
    if not nums:
        return 0
    
    memo = [-1] * len(nums)
    return rob_util(nums, len(nums) - 1, memo)

# Casos de teste
print(rob([1, 2, 3, 1]))  # Saída esperada: 4
print(rob([2, 7, 9, 3, 1]))  # Saída esperada: 12
