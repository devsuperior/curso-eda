from typing import List

#   Problema: Busca Binária (Recursiva)
#
#   n = number of elements array
#
#   time: O(log n)
#   space: O(1)
#

def busca_binaria(nums: List[int], key: int, low: int, high: int) -> int:
    if low > high:
        return -1
    
    middle = (low + high) // 2
    if key == nums[middle]:
        return middle
    elif key < nums[middle]:
        return busca_binaria(nums, key, low, middle - 1)
    else:
        return busca_binaria(nums, key, middle + 1, high)


nums = [-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]
key = 34

result = busca_binaria(nums, key, 0, len(nums)) # 9

if result != -1:
    print(f"Elemento {key} encontrado na posicao {result}.")
else:
    print(f"Elemento {key} não encontrado no array.")

nums = [-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38]
key = 10

result = busca_binaria(nums, key, 0, len(nums)) # -1

if result != -1:
    print(f"Elemento {key} encontrado na posicao {result}.")
else:
    print(f"Elemento {key} não encontrado no array.")


nums = [-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431]
key = 11

result = busca_binaria(nums, key, 0, len(nums)) # 3

if result != -1:
    print(f"Elemento {key} encontrado na posicao {result}.")
else:
    print(f"Elemento {key} não encontrado no array.")