var minCostFrog = function(heights) {
    const n = heights.length;
    const memo = new Array(n).fill(-1);
    
    // Função recursiva com memoização
    function solve(ind) {
        if (ind >= n) {
            return Infinity;
        }
        if (ind === n - 1) {
            return 0;
        }
        if (memo[ind] !== -1) {
            return memo[ind];
        }
        
        const jump1Cost = (ind + 1 < n) ? solve(ind + 1) + Math.abs(heights[ind] - heights[ind + 1]) : Infinity;
        const jump2Cost = (ind + 2 < n) ? solve(ind + 2) + Math.abs(heights[ind] - heights[ind + 2]) : Infinity;
        
        return memo[ind] = Math.min(jump1Cost, jump2Cost);
    }
    
    // Chamada inicial da função com o índice 0 (pedra inicial)
    return solve(0);
};

// Teste dos casos fornecidos
console.log(minCostFrog([10, 30, 40, 20])); // Saída esperada: 30
console.log(minCostFrog([10, 10])); // Saída esperada: 0
console.log(minCostFrog([30, 10, 60, 10, 60, 50])); // Saída esperada: 40
