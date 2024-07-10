class Rank:
    def __init__(self, word, count):
        self.word = word
        self.count = count


def normalize(text):
    import re
    no_punctuation = re.sub(r'[^\w\s]', ' ', text)
    return re.sub(r'\s+', ' ', no_punctuation).strip().lower()


def word_count(text):
    from collections import defaultdict
    dictionary = defaultdict(int)
    words = normalize(text).split()

    for word in words:
        dictionary[word] += 1

    ranks = [Rank(word, count) for word, count in dictionary.items()]
    ranks.sort(key=lambda x: (-x.count, x.word))

    return ranks


input_text = """
    O vento sussurra sons entre as árvores, sons que fazem animais 
    correrem. A floresta e a natureza vibram com segredos e sons.
"""

result = word_count(input_text)
for obj in result:
    print(f'{obj.word}: {obj.count}')
