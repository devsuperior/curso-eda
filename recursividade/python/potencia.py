def power(a, b):
    if b == 0:
        return 1
    return a * power(a, b - 1)


print(power(5, 0))
print(power(3, 4))
