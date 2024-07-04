def can_jump(nums):
    n = len(nums)
    memo = [-1] * n  # -1 for UNKNOWN
    memo[-1] = 1  # 1 for GOOD
    
    def can_jump_from_position(position):
        nonlocal memo, nums, n
        
        if memo[position] != -1:
            return memo[position] == 1
        
        furthest_jump = min(position + nums[position], n - 1)
        for next_position in range(position + 1, furthest_jump + 1):
            if can_jump_from_position(next_position):
                memo[position] = 1  # 1 for GOOD
                return True
        
        memo[position] = 0  # 0 for BAD
        return False
    
    return can_jump_from_position(0)

# Casos de teste
print(can_jump([2, 3, 1, 1, 4]))  # Saída esperada: True
print(can_jump([3, 2, 1, 0, 4]))  # Saída esperada: False
