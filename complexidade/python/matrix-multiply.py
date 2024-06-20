def matrix_multiply(A, B):
    m = len(A)
    p = len(A[0])
    n = len(B[0])

    C = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            for k in range(p):
                C[i][j] += A[i][k] * B[k][j]
    return C


A = [
    [1, 2, 3],
    [4, 5, 6]
]
B = [
    [7, 8],
    [9, 10],
    [11, 12]
]
C = matrix_multiply(A, B)
for row in C:
    print(row)
