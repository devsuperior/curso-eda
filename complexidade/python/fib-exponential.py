def fib_exponential(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fib_exponential(n - 1) + fib_exponential(n - 2)


result = fib_exponential(40)
print(result)
