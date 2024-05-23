var findJudge = function(n, trust) {
    // Vetor para contar quantas pessoas confiam em cada pessoa
    const trustCount = new Array(n + 1).fill(0);
    // Vetor para verificar se uma pessoa confia em alguém
    const trustsSomeone = new Array(n + 1).fill(false);

    // Processa a lista de confiança
    for (let i = 0; i < trust.length; i++) {
        const [a, b] = trust[i];
        // Marca que a pessoa 'a' confia em alguém
        trustsSomeone[a] = true;
        // Incrementa o contador de confiança para a pessoa 'b'
        trustCount[b]++;
    }

    // Verifica cada pessoa para encontrar o juiz
    for (let i = 1; i <= n; i++) {
        // O juiz não confia em ninguém e todos (exceto ele mesmo) confiam nele
        if (trustCount[i] === n - 1 && !trustsSomeone[i]) {
            return i;
        }
    }

    // Se não encontrar nenhum juiz, retorna -1
    return -1;
};

// Exemplo 1
let n = 2
let trust = [[1, 2]]
console.log(findJudge(n, trust))

// Exemplo 2
n = 3
trust = [[1,3],[2,3]]
console.log(findJudge(n, trust))

// Exemplo 3
n = 3
trust = [[1,3],[2,3],[3,1]]
console.log(findJudge(n, trust))