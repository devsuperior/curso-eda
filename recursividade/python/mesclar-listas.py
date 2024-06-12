def merge_lists(a, b):
    if not a:
        return b
    if not b:
        return a

    head1 = a[0]
    tail1 = a[1:]

    head2 = b[0]
    tail2 = b[1:]

    return [head1, head2] + merge_lists(tail1, tail2)


result1 = merge_lists([10, 20, 30], [5, 8, 7])
print(result1)

result2 = merge_lists(["ana", "maria"], ["joao", "bob", "alex", "leo"])
print(result2)
