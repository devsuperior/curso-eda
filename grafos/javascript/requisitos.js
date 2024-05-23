/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {
    const graph = Array.from({ length: numCourses }, () => []);
    const visited = new Array(numCourses).fill(0);

    // Create the adjacency list for the graph
    for (const [course, prereq] of prerequisites) {
        graph[prereq].push(course);
    }

    function dfs(node) {
        if (visited[node] === 1) {
            // Node is being visited, hence a cycle is detected
            return false;
        }
        if (visited[node] === 2) {
            // Node has been completely visited
            return true;
        }

        // Mark the node as visiting
        visited[node] = 1;

        // Visit all the neighbors
        for (const neighbor of graph[node]) {
            if (!dfs(neighbor)) {
                return false;
            }
        }

        // Mark the node as completely visited
        visited[node] = 2;
        return true;
    }

    // Perform DFS on each course
    for (let course = 0; course < numCourses; course++) {
        if (visited[course] === 0) { // Unvisited node
            if (!dfs(course)) {
                return false;
            }
        }
    }

    return true;
};

// Exemplo 1
let numCourses = 2;
let prerequisites = [[0, 1]];
console.log(canFinish(numCourses, prerequisites));

// Exemplo 2
numCourses = 2;
prerequisites = [[0, 1], [1, 0]];
console.log(canFinish(numCourses, prerequisites));
