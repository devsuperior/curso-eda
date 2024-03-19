from typing import List

def find_max_consecutive_ones(nums: List[int]) -> int:
    max_ones = 0
    count_ones = 0
    
    for value in nums:
        if value == 1:
            count_ones += 1

        if value != 1 and count_ones > 0:
            max_ones = max(max_ones, count_ones)
            count_ones = 0

    max_ones = max(max_ones, count_ones)

    return max_ones

print(find_max_consecutive_ones([1,1,0,1,1,1,0,1,1,1,1]))  # 4
print(find_max_consecutive_ones([1,0,1,1,0,1]))  # 2
