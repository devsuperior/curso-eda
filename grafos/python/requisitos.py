def canFinish(numCourses, prerequisites):
    graph = [[] for _ in range(numCourses)]
    visited = [0] * numCourses

    # Create the adjacency list for the graph
    for course, prereq in prerequisites:
        graph[prereq].append(course)

    def dfs(node):
        if visited[node] == 1:
            # Node is being visited, hence a cycle is detected
            return False
        if visited[node] == 2:
            # Node has been completely visited
            return True

        # Mark the node as visiting
        visited[node] = 1

        # Visit all the neighbors
        for neighbor in graph[node]:
            if not dfs(neighbor):
                return False

        # Mark the node as completely visited
        visited[node] = 2
        return True

    # Perform DFS on each course
    for course in range(numCourses):
        if visited[course] == 0:  # Unvisited node
            if not dfs(course):
                return False

    return True

# Exemplo 1
numCourses = 2
prerequisites = [[0, 1]]
print(canFinish(numCourses, prerequisites))

# Exemplo 2
numCourses = 2
prerequisites = [[0, 1], [1, 0]]
print(canFinish(numCourses, prerequisites))
