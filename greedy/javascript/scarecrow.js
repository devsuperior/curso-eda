/**
 * @param {number} n
 * @param {string} field
 * @return {number}
 */
var minimumScarecrows = function(n, field) {
    let ans = 0;
    for(let i = 0; i < n; i++){
        if(field[i] == '.'){
            i += 2;
            ans++;
        }
    }
    return ans;
}

console.log(minimumScarecrows(3, '.#.'))
console.log(minimumScarecrows(11, '...##....##'))
console.log(minimumScarecrows(2, '##'))