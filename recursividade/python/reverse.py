def reverse(lst):
    if len(lst) <= 1:
        return lst

    head = lst[0]
    tail = lst[1:]

    new_list = reverse(tail)
    new_list.append(head)

    return new_list


result = reverse(["azul", "verde", "preto", "rosa"])
print(result)
