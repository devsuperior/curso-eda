// Inicializando os conjuntos A e B
let A = new Set([1, 2, 3, 4, 5]);
let B = new Set([4, 5, 6, 7, 8]);

// Mostrando os conteúdos dos conjuntos A e B
console.log("Conjunto A:", A);
console.log("Conjunto B:", B);

// Adicionando um novo número ao conjunto A
A.add(9);
console.log("Conjunto A após adicionar 9:", A);

// Removendo o número adicionado do conjunto A
A.delete(9);
console.log("Conjunto A após remover 9:", A);

// Testando se um elemento pertence ao conjunto A
console.log("5 pertence ao conjunto A?", A.has(5));

// Testando se o conjunto A está vazio
console.log("Conjunto A está vazio?", A.size === 0);

// Testando o tamanho do conjunto A
console.log("Tamanho do conjunto A:", A.size);

// Operações de união, interseção e diferença usando métodos de Set
let C = new Set([...A, ...B]); // União
console.log("União dos conjuntos A e B (Conjunto C):", C);

C = new Set([...A].filter(x => B.has(x))); // Interseção
console.log("Interseção dos conjuntos A e B (Conjunto C):", C);

C = new Set([...A].filter(x => !B.has(x))); // Diferença
console.log("Diferença entre os conjuntos A e B (Conjunto C):", C);
