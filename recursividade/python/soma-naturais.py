def sum_naturals(n):
    if n == 0:
        return 0
    return n + sum_naturals(n - 1)


result = sum_naturals(4)
print("RESULTADO:", result)
