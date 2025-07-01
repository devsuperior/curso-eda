function knapsack(i, w, weights, values) {
    let memo = Array.from( { length: n + 1}, () => Array(W + 1).fill(-1));
    return knapsackAux(i, w, weights, values, memo);
}

function knapsackAux(i, w, weights, values, memo) {
    // Caso base: se não temos itens sobrando ou capacidade é 0, retorne 0
    if (i == 0 || w == 0) {
        return 0;
    }

    // Verificar se já calculamos este subproblema
    if (memo[i][w] !== -1) {
        return memo[i][w];
    }

    // Se incluir o próximo item exceder a capacidade, pular ele
    if (weights[i - 1] > w){   
        memo[i][w] = knapsackAux(i - 1, w, weights, values, memo);
    } 
    // Caso contrário, explorar dois casos: incluir o n-ésimo item ou excluir ele
    else {
        let itemIn = values[i - 1] + knapsackAux(i - 1, w - weights[i - 1], weights, values, memo);
        let itemOut = knapsackAux(i - 1, w, weights, values, memo);
        memo[i][w] = Math.max(itemIn, itemOut);
    }

    return memo[i][w];
}

// Exemplo de uso
let weights = [1, 2, 3]
let values = [6, 10, 12]
let W = 5;
let n = 3;

console.log(knapsack(n, W, weights, values));
