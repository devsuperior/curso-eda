const lcsUtil = function(ind1, ind2, s1, s2) {
    // Casos base
    if(ind1 < 0 || ind2 < 0) {
        return 0;
    }
    
    // Se caracteres forem iguais avança nos dois
    if(s1[ind1] == s2[ind2]){
        return 1 + lcsUtil(ind1 - 1, ind2 - 1, s1, s2);
    }
    // Se forem diferentes, avançar em um ou no outro
    else {
        return Math.max(lcsUtil(ind1 - 1, ind2, s1, s2), lcsUtil(ind1, ind2 - 1, s1, s2));
    }
}

const findLCS = function(s1, s2) {
    let n = s1.length;
    let m = s2.length;

    return lcsUtil(n - 1, m - 1, s1, s2);
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