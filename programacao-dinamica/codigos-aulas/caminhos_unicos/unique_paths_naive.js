const countPaths = function(i, j) {
    if(i == 0 || j == 0)
        return 1;

    let moveUp = countPaths(i - 1, j);
    let moveLeft = countPaths(i, j - 1);

    return moveUp + moveLeft;
}

n = 25, m = 25
console.log(countPaths(n - 1, m - 1));