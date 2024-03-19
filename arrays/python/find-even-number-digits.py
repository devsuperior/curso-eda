from typing import List

def find_numbers(nums: List[int]) -> int:
    count_even_number = 0
    for value in nums:
        num_digits = len(str(value))
        if num_digits % 2 == 0:
            count_even_number += 1
    return count_even_number

print(find_numbers([12, 345, 2, 6, 7896]))  # 2
print(find_numbers([555, 901, 482, 1771]))  # 1