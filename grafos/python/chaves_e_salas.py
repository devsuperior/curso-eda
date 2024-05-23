def canVisitAllRooms(rooms):
    visited = [False] * len(rooms)
    visited[0] = True
    stack = [0]

    while stack:
        current = stack.pop()
        for neighbour in rooms[current]:
            if not visited[neighbour]:
                visited[neighbour] = True
                stack.append(neighbour)

    # Se alguma sala não foi visitada, retorna False
    return all(visited)

# Exemplo 1
rooms1 = [[1],[2],[3],[]]
print(canVisitAllRooms(rooms1))

# Exemplo 2
rooms2 = [[1,3],[3,0,1],[2],[0]]
print(canVisitAllRooms(rooms2))
