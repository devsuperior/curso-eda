from collections import deque


def time_required_to_buy(tickets, k):
    queue = deque(range(len(tickets)))
    result = 0

    while True:
        i = queue.popleft()
        tickets[i] -= 1
        result += 1
        if tickets[i] > 0:
            queue.append(i)
        elif i == k:
            return result


print(time_required_to_buy([2, 3, 2], 2))
print(time_required_to_buy([5, 1, 1, 1], 0))
