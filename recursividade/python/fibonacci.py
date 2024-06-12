def fib(n):
    return fib_tail_recursive(n, 0, 1)


def fib_tail_recursive(n, a, b):
    if n == 0:
        return a
    if n == 1:
        return b
    return fib_tail_recursive(n - 1, b, a + b)


result = fib(6)
print("RESULTADO =", result)
