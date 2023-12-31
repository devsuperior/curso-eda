from typing import List

#   Problema: Busca Sequencial Ordenada
#
#   n = number of elements array
#
#   time: O(n)
#   space: O(n)
#

def busca_sequencial_ord(nums: List[int], key: int) -> int:
    nums.sort()
    for i, num in enumerate(nums):
        if num == key:
            return i
        else:
            if key < num:
                return -1
    return -1
    
nums = [28, 6, -2, 9, 16, 20, 23, 8]
key = 20

result = busca_sequencial_ord(nums, key)

if result != -1:
    print(f"Elemento encontrado na posicao {result}")
else:
    print(f"Elemento {key} não encontrado no array")

nums = [4, 6, -3, 21, 55, 91, 2]
key = 11

result = busca_sequencial_ord(nums, key)

if result != -1:
    print(f"Elemento encontrado na posicao {result}")
else:
    print(f"Elemento {key} não encontrado no array")


        