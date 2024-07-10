const lcsUtil = function(ind1, ind2, s1, s2, memo) {
    // Casos base
    if(ind1 < 0 || ind2 < 0) {
        return 0;
    }

    if(memo[ind1][ind2] != -1){
        return memo[ind1][ind2];
    }

    // Se caracteres forem iguais avança nos dois
    if(s1[ind1] == s2[ind2]){
        memo[ind1][ind2] = 1 + lcsUtil(ind1 - 1, ind2 - 1, s1, s2, memo);
        return memo[ind1][ind2];
    }
    // Se forem diferentes, avançar em um ou no outro
    else {
        memo[ind1][ind2] = Math.max(lcsUtil(ind1 - 1, ind2, s1, s2, memo), lcsUtil(ind1, ind2 - 1, s1, s2, memo));
        return memo[ind1][ind2];
    }
}

const findLCS = function(s1, s2) {
    let n = s1.length;
    let m = s2.length;

    let memo = Array.from( {length: n}, () => Array(m).fill(-1));

    return lcsUtil(n - 1, m - 1, s1, s2, memo);
}


// Caso de Teste 1
let s1 = "abcde";
let s2 = "ace";
console.log(findLCS(s1, s2)); // Saída esperada: 3

// Caso de Teste 2
s1 = "abc";
s2 = "def";
console.log(findLCS(s1, s2)); // Saída esperada: 0

// Caso de Teste 3
s1 = "abcdef";
s2 = "abcdef";
console.log(findLCS(s1, s2)); // Saída esperada: 6

// Caso de Teste 4 - Caso Grande
s1 = "aaaaaaaaaaaaaaaaaaabcdef";
s2 = "abcdefaaaaaaaaaaaaaaaaaaa";
console.log(findLCS(s1, s2)); // Saída esperada: 19