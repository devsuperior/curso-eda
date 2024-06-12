def char_count(ch, text):
    return char_count_tail_recursive(ch.lower(), text.lower(), 0, 0)


def char_count_tail_recursive(ch, text, index, count):
    if index >= len(text):
        return count

    new_count = count + 1 if text[index] == ch else count
    return char_count_tail_recursive(ch, text, index + 1, new_count)


result = char_count("b", "Batata para o bebê")
print(result)
