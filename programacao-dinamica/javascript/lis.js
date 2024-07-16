const lis = function(s){
    let n = s.length;
    let memo = Array(n).fill(1);

    let ans = 1;
    for(let i = 0; i < n; i++) {
        // olhamos índices anteriores buscando sequência para continuar
        for(let j = 0; j < i; j++) {
            if(s[j] < s[i]){
                memo[i] = Math.max(memo[i], 1 + memo[j]);
            }
        }
        ans = Math.max(ans, memo[i]);
    }

    return ans;
}

// Caso 1
let s = [3,1,8,2,5];
console.log(lis(s));

// Caso 2
s = [10, 4, 5, 6, 5, 15, 2, 3];
console.log(lis(s));