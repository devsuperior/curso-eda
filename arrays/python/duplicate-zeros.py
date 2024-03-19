from typing import List

def duplicate_zeros(arr: List[int]) -> None:
    i = 0
    while i < len(arr) - 1:
        if arr[i] == 0:
            arr.insert(i + 1, 0)
            arr.pop()
            i += 2
        else:
            i += 1

# Exemplo de uso
arr = [1, 0, 2, 3, 0, 4, 5, 0]
duplicate_zeros(arr)
print(arr)
