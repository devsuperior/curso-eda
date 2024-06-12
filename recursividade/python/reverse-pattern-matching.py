def reverse(lst):
    match lst:
        case []:
            return []
        case [head, *tail]:
            return reverse(tail) + [head]


result = reverse(["azul", "verde", "preto", "rosa"])
print(result)
