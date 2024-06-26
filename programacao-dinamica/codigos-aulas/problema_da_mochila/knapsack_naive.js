const knapsack = function(i, w, weights, values) {
    // Caso base: se não temos itens sobrando ou capacidade é 0, retorne 0
    if(i == 0 || w == 0) {
        return 0;
    }

    // Se incluir o próximo item exceder a capacidade, pular ele
    if(weights[i - 1] > w){   
        return knapsack(i - 1, w, weights, values);
    }

    // Caso contrário, explorar dois casos: incluir o n-ésimo item ou excluir ele
    else {
        let incluir_item = values[i - 1] + knapsack(i - 1, w - weights[i - 1], weights, values);
        let excluir_item = knapsack(i - 1, w, weights, values);

        return Math.max(incluir_item, excluir_item);
    }
}

// Exemplo de uso
let weights = [1, 2, 3]
let values = [6, 10, 12]
let W = 5;
let n = 3;

console.log(knapsack(n, W, weights, values));