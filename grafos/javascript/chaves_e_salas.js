/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function(rooms) {
    var visited = new Array(rooms.length).fill(false);
    visited[0] = true;
    var stack = [];
    stack.push(0);

    while (stack.length > 0) {
        var current = stack.pop();
        for(const neighbour of rooms[current]){
            if (!visited[neighbour]) { 
                visited[neighbour] = true; 
                stack.push(neighbour);
            }
        }
    }

    // If any room hasn't been visited, return false
    for (var i = 0; i < visited.length; i++) {
        if (!visited[i]) return false;
    }
    return true;
};

let rooms = [[1],[2],[3],[]]
console.log(canVisitAllRooms(rooms))

rooms = [[1,3],[3,0,1],[2],[0]]
console.log(canVisitAllRooms(rooms))
