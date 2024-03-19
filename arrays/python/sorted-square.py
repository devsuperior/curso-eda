from typing import List

def sorted_squares(nums: List[int]) -> List[int]:
    result = [num ** 2 for num in nums]
    result.sort()
    return result

print(sorted_squares([-4, -1, 0, 3, 10]))
print(sorted_squares([-7, -3, 2, 3, 11]))
