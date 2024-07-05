from time import time
import json


with open('c:/temp/visitantes-input.json', 'r') as file:
    visitors_list = json.load(file)


def total(visitors):
    unique_visitors = set()

    for visitor in visitors:
        name = visitor.split(',')[0]
        unique_visitors.add(name)

    return len(unique_visitors)


def total_naive(visitors):
    unique_visitors = []

    for visitor in visitors:
        name = visitor.split(',')[0]
        if name not in unique_visitors:
            unique_visitors.append(name)

    return len(unique_visitors)


start1 = time()
result1 = total(visitors_list)
end1 = time()
time1 = end1 - start1
print(f"RESULT = {result1}. Time = {time1:.3f}s")

start2 = time()
result2 = total_naive(visitors_list)
end2 = time()
time2 = end2 - start2
print(f"RESULT = {result2}. Time = {time2:.3f}s")

quo = time2 / time1
print(f"Segundo algoritmo {quo:.1f} vezes mais lento")

