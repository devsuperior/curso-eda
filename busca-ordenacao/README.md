# Módulo Busca e Ordenação

## Busca

### Visão geral

- **Definição**: Consiste na tarefa de buscar um elemento em um conjunto de dados

    - *Exemplo*: Recuperar dados armazenados em uma base de dados

- O objetivo é verificar se um determinado valor está ou não presente em um conjunto de elementos (ex: *array*).

- Cada elemento é composto por um campo que é identificado como a **CHAVE** de busca. 

- É por meio deste campo, comparando a chave do elemento a ser buscado, que vamos identificar se dado elemento é o que estamos buscando.

![exemplo-busca](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-busca-chave.png "Comparação das chaves para buscar um determinado elemento")

- Existem vários tipos de busca, no entanto, para pensarmos no tipo de busca mais adequada, alguns pontos precisam ser verificados:
    - Os dados são estruturados?
        - Armazenados em array, lista ou árvore
    - Os dados estão ordenados?
    - Existem registros duplicados?

- Temos 2 tipos de busca:
    - Busca sequencial
        * *Caso especial*: Busca sequencial ordenada
    - Busca binária

### Busca sequencial

- Este algoritmo percorre o array que contém os dados da primeira até a última posição.
    - A necessidade de percorrer todo o array, pois estamos assumindo que os dados não estão ordenados.

- Para cada posição do array, compara se a posição atual do array é igual ao valor buscado. 
    - Se os valores são iguais, a busca termina
    - Caso contrário, a busca continua com as posições seguinte do array.

#### Exemplo

![busca-sequencial](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-busca-sequencial.png "Exemplo busca sequencial")
<p align="center">Exemplo busca sequencial</p>

#### Algoritmo

```javascript
const busca_sequencial = (nums, key) => {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == key)
            return i;
    }
    return -1;
};
```
<p align="center">Exemplo busca sequencial em javascript</p>

#### Complexidade

- Considerando um array com $n$ elementos, temos:
    - **melhor caso**: O($1$), o elemento é o primeiro do array.
    - **pior caso**: O($n$), o elemento é o último do array ou não existe
    - **caso médio**: O($n/2$)


### Busca sequencial ordenada

- A busca de um determinado elemento em um array não ordenado é uma tarefa que tem um custo significativo. Uma das formas de melhorar este algoritmo é ordenando os elementos.

- Neste caso, temos a **busca sequencial ordenada** que é um caso especial de **busca sequencial**. 

- O algoritmo funciona da seguinte forma:
    01. Assume-se que os dados estão ordenados;

    00. Se o elemento procurado for **menor** que o elemento da posição atual do array, então a busca é finalizada, indicando que o elemento procurado não está contido no array.

        - Não há a necessidade de percorrer todo o array.

#### Exemplo

![busca-sequencial-ord](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-busca-sequencial-ord.png "Exemplo busca sequencial ordenada")
<p align="center">Exemplo busca sequencial ordenada</p>

#### Algoritmo

```javascript
const busca_sequencial_ordenada = (nums, key) => {
    nums.sort((a, b) => a - b);
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == key)
            return i;
        else
            if (key < nums[i])
                return -1;
    }
    return -1;
};
```
<p align="center">Exemplo busca sequencial ordenada em javascript</p>

#### Complexidade

- Apesar de ser mais eficiente que a busca sequencial, ambas tem complexidade de tempo e espaço similares.


### Busca binária

- Uma estratégia de busca mais sofisticada é a busca binária, sendo esta a forma mais eficiente de buscar um elemento em um array.

- Para aplicar o algoritmo da busca binária, vamos assumir que os dados estão **ordenados**.

- O algoritmo é baseado princípio de **dividir para conquistar**, onde um problema maior é dividido em sub-problemas.

- O algoritmo funciona da seguinte forma:
    - A cada passo, obtemos o elemento central do array:
        - Se o valor deste elemento for igual ao elemento que estamos buscando, a busca termina;
        - Se o elemento do meio for maior que o elemento que estamos buscando, então reduzimos a busca a metade inferior do array;
        - Caso contrário, reduzimos a busca à metade superior do array.

#### Exemplo

![busca-binaria](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-busca-binaria.png "Exemplo busca sequencial")
<p align="center">Exemplo Busca binária</p>

#### Algoritmos

```javascript
const busca_binaria = function(nums, key) {
    let low = 0;
    let middle;
    let high = nums.length - 1;

    while (low <= high) {
        middle = Math.floor((low + high) / 2);
        if (key < nums[middle])
            high = middle - 1;
        else if (key > nums[middle])
            low = middle + 1;
        else
            return middle;
    }

    return -1;
};
```
<p align="center">Busca binária <em>iterativa</em> em javascript</p>

```javascript
const busca_binaria_recursiva = function(nums, key, low, high) {

    if (low > high) {
        return -1;
    }

    const middle = Math.floor((low + high) / 2);
    if (key === nums[middle]) {
        return middle;
    } 
    else if (key < nums[middle]) {
        return busca_binaria_recursiva(nums, key, low, middle - 1);
    }
    else {
        return busca_binaria_recursiva(nums, key, middle + 1, high);
    }
};
```
<p align="center">Busca binária <em>recursiva</em> em javascript</p>

#### Complexidade

- Considerando um array com $n$ elementos, temos:
    - **melhor caso**: O($1$), o elemento está no meio do array
    - **pior caso**: O(log $n$), o elemento não existe
    - **caso médio**: O(log $n$)



## Ordenação

### Visão geral

- **Definição**: Consiste na tarefa de organizar um conjunto de dados ou uma coleção (ex: array), seguindo uma determinada ordem predefinida.

    - *Exemplo 1*: Suponha o conjunto de dados [10, 5, 2, -2, 20], podemos **ordená-lo** de acordo com dois critérios:

        - **Crescente**: [-2, 2, 5, 10, 20]

        - **Descrescente**: [20, 10, 5, 2, -2]

    - *Exemplo 2*: Organizar os contatos de uma agenda telefonica ["Pedro", "Caio", "Roberta", "Amanda", "Nélio"] em ordem alfabética

        - ["Amanda", "Caio", "Nélio", "Pedro", "Roberta"].

- Um algoritmo de ordencão é utilizado para colocar um determinado conjunto em uma certa ordem.

- A ordenação permite que o acesso aos dados seja feito de uma forma mais eficiente.

- Para a tarefa de ordenação utilizamos uma chave para comparar o valor dos elementos do conjunto, neste caso podemos armazenar valores numéricos ou cadeias de caracteres (*strings*).

- Os algoritmos de ordenação podem ser classificados de duas formas:

    - *Ordenação interna*: Utiliza-se somente a memória principal (RAM) para ordenar o conjunto de dados. Neste caso, o acésso aos elementos é rápido.

    - *Ordenacão externa*: É necessário utilizar algum armazenamento externo (ex: arquivo) para realizar a ordenação dos elementos. Ou seja, o conjunto de elemento não cabe na memória principal.

- Neste capítulo, vamos abordar os algoritmos de ordenação mais utilizados como o Bubble Sort, Selection Sort, Insertion Sort, Merge Sort e Quick Sort.

### Bubble Sort

- Também conhecido como ordenação por bolha, é um dos algoritmos mais conhecidos.

- No entanto, é um algoritmo ineficiente, principalmente quando estamos trabalhando com um grande conjunto de dados.

- O algoritmo funciona da seguinte forma:

    - Compara os valores dos elementos adjacentes e caso estejam foram de ordem, ambos são trocados de lugar.

    - O processo se repete até que nenhuma troca seja necessária, indicando que os elementos estão ordenados.

#### Exemplo:


![ordenacao-bubble](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/ordenacao-bubble-sort.png)
<p align="center">Bubble Sort</p>

#### Algoritmo

```javascript
const bubble_sort = (nums) => {
    const N = nums.length;
    for (let i = 0; i < N; i++) {
        let swapped = false;
        for (let j = 0; j < N - 1 - i; j++) {
            if (nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1);
                swapped = true;
            }
        }
        if (!swapped) {
            break;
        }
    }
    return nums;
};

const swap = (nums, a, b) => {
    const aux = nums[a];
    nums[a] = nums[b];
    nums[b] = aux;
};
```

#### Complexidade

- Considerando um array com $n$ elementos, temos:
    - **melhor caso**: O($n$), os elementos já estão ordenados
    - **pior caso**: O($n^2$), elementos ordenados na ordem inversa
    - **caso médio**: O($n^2$)

### Selection Sort

- Também conhecida como **ordenação por seleção**.

- Em geral, o *Selection sort* é mais eficiente quando comparado com o *Bubble sort*.

- No entanto, seu desempenho se reduz significativamente a medida que o número de elementos no array aumenta.

- É um dos algoritmos mais simples, funciona da seguinte forma:

    - Procura o menor elemento do array e seleciona-o. Em seguida, troca de posição com a primeira posição do array. Ou seja, o elemento é colocado na posição correta. 

    - Em seguida, procura o próximo menor valor, seleciona-o e troca colocando este elemento na segunda posição.

    - Este processo é repetido até que todo o array esteja ordenado.

#### Exemplo

![ordenacao-selecao](https://raw.githubusercontent.com/devsuperior/eda-assets/a48d1f82bdedb2aeb38ae5d5507031dbbbfc637c/img/ordenacao-selection-sort.png)
<p align="center">Selection Sort</p>

#### Algoritmo

```javascript
const selection_sort = (nums) => {
    const N = nums.length;
    for (let i = 0; i < N - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < N; j++) {
            if (nums[j] < nums[minIndex])
                minIndex = j;
        }
        if (minIndex != i)
            swap(nums, i, minIndex);
    }
    return nums;
};

const swap = (nums, a, b) => {
    const aux = nums[a];
    nums[a] = nums[b];
    nums[b] = aux;
};
```

#### Complexidade

- O algoritmo de ordenação *Selection Sort* tem a mesma complexidade de tempo no melhor caso, pior caso e caso médio, uma vez que seu comportamento depende principalmente do número de comparações e trocas.

- Considerando um array com $n$ elementos, temos:
    - tempo: O($n^2$)
    - espaço: O($1$)

- Na prática, o *selection sort* possui um desempenho melhor que o *bubble sort* na maior parte dos casos, no entanto, quando estamos trabalhando com grandes conjuntos de dados, este algoritmo ainda é considerado ineficiente.

### Insertion Sort

- Também chamada de **ordenação por inserção**.

- Este é um dos algoritmos mais eficientes de ordenação, considerando pequenos conjuntos de dados.

    - Mais eficiente incluindo o algoritmo *Merge Sort* e *Quick sort*.

- O algoritmo funciona da seguinte forma:

    - Para cada posição $K$ do array verifica-se o seu valor está na posição correta.

    - Verifica-se os elementos à esquerda da posição $K$ e movimenta-se uma posição para frente os elementos que são **maiores** que o valor da posição $K$.

    - Desta fora, será aberta uma posição livre para inserção do elemento da posição $K$ na posição correta.

    - Este processo é repetido para as posições seguintes, até que o array esteja ordenado.

#### Exemplo

![ordenacao-insercao1](https://raw.githubusercontent.com/devsuperior/eda-assets/974a564a63bdbf168aadd862d0cb8348755e1c1f/img/ordenacao-insertion-sort-1.png)
![ordenacao-insercao1](https://raw.githubusercontent.com/devsuperior/eda-assets/bfa39c6487a482eb66a1bb312f8452ece721a7ad/img/ordenacao-insertion-sort-2.png)
<p align="center">Insertion Sort</p>

#### Algoritmo

```javascript
const insertion_sort = (nums) => {
    const N = nums.length;
    for (let i = 1; i < N; i++) {
        let aux = nums[i];
        let j = i - 1;
        while (j >= 0 && nums[j] > aux) {
            nums[j + 1] = nums[j];
            j -= 1;
        }
        nums[j + 1] = aux;
    }
    return nums;
};
```

#### Complexidade

- Considerando um array com $n$ elementos, temos:
    - **melhor caso**: O($n$), os elementos já estão ordenados
    - **pior caso**: O($n^2$), elementos ordenados na ordem inversa
    - **caso médio**: O($n^2$)

### Merge Sort

- Também chamada de **ordenação por junção/ intercalação**.

- Algoritmo recursivo que usa a idéia de dividir
para conquistar para ordenar os dados.

- Parte da premissa que é mais fácil ordenar um conjunto menor de dados.

- O algoritmo divide os dados em conjuntos cada
vez menores, em seguida os dados são ordenados e combinados por meio da união (merge).

- O algoritmo funciona da seguinte forma:

    - Divide de forma recursiva o array em **duas partes**.

        - Continua até que cada parte contenha somente um elemento.

    - Em seguida, combina os dois arrays de forma ordenada.

    - Esse proceso se repete até que exista somente um array com todos os elementos.

#### Exemplo

![ordenacao-merge](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/ordenacao-merge-sort.png)

#### Algoritmo

```javascript
const merge_sort = (nums, left, right) => {
    if (left < right) {
        let middle = Math.floor((left + right) / 2);
        merge_sort(nums, left, middle);
        merge_sort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }
    return nums;
};

const merge = (nums, left, middle, right) => {
    const result = [];
    let length = right - left + 1;
    let i = left;
    let j = middle + 1;
    let k = 0;

    while (i <= middle && j <= right) {
        if (nums[i] < nums[j]) {
            result[k++] = nums[i++];
        } else {
            result[k++] = nums[j++];
        }
    }

    while (i <= middle) {
        result[k++] = nums[i++];
    }

    while (j <= right) {
        result[k++] = nums[j++];
    }

    for (let i = 0; i < length; i++) {
        nums[left + i] = result[i];
    }
};
```

#### Complexidade

- Considerando um array com $N$ elementos, o tempo de execução é de ordem O($N$ log $N$) em todos os casos


### Quick Sort

- Também chamado de **ordenação por partição**.

- Outro algoritmo recursivo que utiliza a abordagem de dividir para conquistar para ordenar os dados.

- O algoritmo consiste em aplicar uma propriedade onde vamos escolher um elemento como pivô e rearranjar o array de forma que:

    - Valores menores que o pivô a esquerda

    - Valores maiores que o pivô a direita

- O algoritmo funciona da seguinte forma:

    - Um elemento é escolhido como pivô.

        - Existem diversas estratégias que podem ser usadas, como utilizar o termo central ou o último elemento, etc.

    - Valores menores que o pivô são organizados antes dele e os maiores depois. A ideia é que teremos duas partições: A primeira com os elementos menores, e a segunda com os elementos maiores.

    - Aplica recursivamente o algoritmo em cada partição.

#### Exemplo

![ordenacao-quick-1](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/ordenacao-quick-sort-1.png)

![ordenacao-quick-2](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/ordenacao-quick-sort-2.png)

![ordenacao-quick-3](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/ordenacao-quick-sort-3.png)

#### Algoritmo

```javascript
const quick_sort = (nums, left, right) => {
    if (left < right) {
        let pivot = partition(nums, left, right);
        quick_sort(nums, left, pivot - 1);
        quick_sort(nums, pivot + 1, right);
    }
    return nums;
};

const partition = (nums, left, right) => {
    let pivot = nums[right];
    let i = left;
    for (let j = left; j < right; j++) {
        if (nums[j] <= pivot) {
            swap(nums, j, i);
            i = i + 1;
        }
    }
    swap(nums, i, right);
    return i;
};

const swap = (nums, a, b) => {
    const aux = nums[a];
    nums[a] = nums[b];
    nums[b] = aux;
};
```

#### Complexidade

- Considerando um array com $n$ elementos, temos:
    - **melhor caso** e **caso médio**: O($N$ log $N$)
    - **pior caso**: O($n^2$)

- Em geral é um algoritmo muito rápido para ordenação, no entanto, em alguns casos ele pode diminuir consideravelmente seu desempenho (ex: casos em que o particionamento não é balanceado).






























