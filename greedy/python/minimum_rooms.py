def minimum_rooms(start, end, n):
    start.sort()
    end.sort()

    i = 0
    j = 0
    ans = 0
    rooms = 0

    # Aloca salas conforme necessário e mantém o máximo que precisamos
    while i < n or j < n:
        if i < n and (j == n or start[i] <= end[j]):
            i += 1
            rooms += 1
        else:
            j += 1
            rooms -= 1

        ans = max(ans, rooms)

    return ans
