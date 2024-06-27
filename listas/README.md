# Módulo Listas

## Listas encadeadas

#### Introdução:

- Também podem ser chamadas de **listas ligadas** (*Linked Lists*) ou **lista simplesmente encadeada**.

- **Definição**: É um tipo de lista onde cada elemento **aponta** para o seu sucessor na lista.

    - Cada elemento da lista encadeada é chamado de **nó** (*node*). 

    - Um **nó** é uma estrutura que será composta por **duas informações** ou campos:

        - **dado**: Informação que queremos armazenar na lista (ex: número, string, objeto)

        - **próximo**: Referência ou posição para o ao próximo elemento da lista.

![listas-encadeadas](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/lista-encadeada.png)
<p align="center">Representacão de um nó e lista encadeada</p>

- Cada nó da lista encadeada é **alocado dinamicamente**, a medida que os dados são inseridos.

#### Representação na memória

- Diferentemente dos arrays as listas encadeadas não armazenam seus dados de forma sequencial na memória. 

- Na lista encadeada, os dados são organizados de forma **dinâmica**, permitindo os mesmos sejam armazenados em espaços quaisquer da memória.

![representacao-memoria](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/representacao-array-listas.png)
<p align="center">Representação arrays e listas encadeadas na memória</p>

- Desta forma, esses espaços serão alocados somente no momento em que for necessário armazenar um novo elemento.

- **Analogia**: Vagões de um trem

    - Cada vagão de um trem existe, de maneira independente e pode estar em qualquer lugar, assim como um **nó** existe de forma independente e pode estar em qualquer espaço de memória;

    - Dentro de cada vagão, podemos armazenar objetos, assim como cada **nó** podemos armazenar o nosso dado de interesse;

    - Cada vagão possui um gancho que permite ligar ao vagão seguinte, assim como um **nó** possui a informação do **nó** seguinte;

    - A partir do primeiro vagão do trem, podemos alcançar o segundo se ambos estiverem ligados pelo gancho, em seguida o terceiro, até alcançar o último vagão de um trem;
    
    - Da mesma forma, a partir do primeiro **nó**, conseguimos alcançar o segundo **nó**, depois o terceiro **nó**, até alcançarmos o último **nó** que aponta para um valor indefinido (*null*).

#### Vantagens:

- Melhor utilização dos recursos da memória.

- Não é necessário movimentar os elementos nas operações de inserção e remoção.

![exemplo-insercao](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-insercao.png)
<p align="center">Exemplo inserção elemento na lista encadeada</p>

#### Desvantagens:

- Acesso indireto aos elementos

- Necessidade de percorrer a lista para acessar um elemento.

### Implementação Lista encadeada

#### Estrutura nó

Estrutura base do nó, que armazena o valor ou dado de interesse e uma referência para o próximo elemento da lista.

##### Algoritmo:

```javascript
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

const node1 = new Node("A");
const node2 = new Node("B");
const node3 = new Node("C");

node1.next = node2;
node2.next = node3;

console.log(node1.value);
console.log(node1.next.value);
console.log(node2.next.value);
```

#### Estrutura lista encadeada

Criar estrutura da lista encadeada, responsável pelo gerenciamento das operações da lista (inserção elementos, remoção, etc).

##### Algoritmo:

```javascript
class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }
}

let linkedList = new LinkedList();

const node1 = new Node("A");
const node2 = new Node("B");
const node3 = new Node("C");

linkedList.head = node1;
node1.next = node2;
node2.next = node3;

console.log(linkedList.head.value);
console.log(linkedList.head.next.value);
console.log(linkedList.head.next.next.value);
```

#### Adicionar elemento ao final da lista

Operação para inserir um novo elemento ao final da lista encadeada.

##### Exemplo

![insercao-final](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-encadeada-addAtEnd.png)
<p align="center">Insere elemento no final da lista</p>

##### Algoritmo

```javascript
addAtEnd = (elem) => {
    const node = new Node(elem);
    if (this.head == null) {
        this.head = node;
        this.size = this.size + 1;
        return;
    }
    
    let current = this.head;
    while (current.next) {
        current = current.next;
    }
    current.next = node;
    this.size = this.size + 1;
};
```

#### Imprimir elementos da lista
Exibe os elementos da lista encadeada

##### Exemplo

![exibe-elementos](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-encadeada-printList.png)
<p align="center">Exibe elementos da lista</p>

##### Algoritmo

```javascript
printLinkedList = () => {
    let current = this.head;
    while (current != null) {
        console.log(current.value);
        current = current.next;
    }
};
```

#### Obter o tamanho da lista
Operação para consultar o tamanho da lista encadeada

##### Algoritmo

```javascript
getSize = () => {
    return this.size;
};
```

#### Verificar se a lista está vazia
Retorna verdadeiro se a lista encadeada estiver vazia, falso caso contrário.

```javascript
isEmpty = () => {
    if (this.head == null) 
        return true;
    return false;
};
```

#### Limpar a lista
Remove todos os elementos da lista encadeada, deixando-a vazia.

##### Algoritmo 1: Implementação simples

```javascript
clear = () => {
    this.head = null;
    this.size = 0;
};
```

#### Adicionar elemento no início da lista

Adiciona um elemento no início da lista encadeada.

##### Exemplo

![insercao-inicio](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-encadeada-addAtStart.png)
<p align="center">Insere elemento no início da lista</p>

##### Algoritmo

```javascript
addAtStart = (elem) => {
    const node = new Node(elem);
    if (this.isEmpty()) {
        this.head = node;
        this.size = this.size + 1;
        return;
    }
    const aux = this.head;
    this.head = node;
    node.next = aux;
    this.size = this.size + 1;
};
```

#### Obter elemento em uma posição específica

Retorna o elemento na posição especificada da lista encadeada. se o índice não existir, retorna *null*.

```javascript
get = (index) => {
    let current = this.getNode(index);
    if (current)
        return current.value; 
    return null;
};

getNode = (index) => {
    if (index < 0 || index > this.getSize()) 
        return null;
    let current = this.head;
    let i = 0;
    while (i != index) {
        current = current.next;
        i++;
    }
    if (current) 
        return current;
    return null;
};
```

#### Adicionar elemento em uma posição específica

Adiciona um elemento em uma posição específica da lista encadeada. Se o índice não existir, insere no final.

##### Exemplo

![insercao-posicao](https://raw.githubusercontent.com/devsuperior/eda-assets/8db36528cee374cec20a1efbe538fcb892ecf4bb/img/exemplo-lista-encadeada-addAtPosition-1.png)
![insercao-posicao2](https://raw.githubusercontent.com/devsuperior/eda-assets/f8f6d6a69368e6cda0be0b1b3b0d96ba608533b8/img/exemplo-lista-encadeada-addPosition-2.png)
<p align="center">Insere em qualquer posição da lista</p>

##### Algoritmo

```javascript
addAtPosition = (index, elem) => {
    if (index == 0) {
        this.addAtStart(elem);
        return; 
    }
    if (!this.get(index)) {
        this.addAtEnd(elem);
        return;
    }
    
    const node = new Node(elem);
    let aux = this.getNode(index - 1);
    node.next = aux.next;
    aux.next = node;
    this.size++;
};
```

#### Obter a posição de um elemento

Procura um elemento na lista encadeada e retorna sua posição. Se não existir retorna -1.

#### Algoritmo

```javascript
indexOf = (elem) => {
    let current = this.head;
    let i = 0
    while (current) {
        if (current.value == elem)
            return i;
            current = current.next;
            i++;
    }
    return -1;
};
```


#### Verifica se um elemento existe na lista

Retorna um true se o elemento existir e false caso o elemento não esteja na lista

#### Algoritmo

```javascript
contains = (elem) => {
    let indexElem = this.indexOf(elem);
    if (indexElem != -1) {
        return true;
    }
    return false;
};
```

#### Remover elemento de uma posição específica

Remove o elemento em uma posição específica da lista encadeada e retorna o elemento. Se o índice não existir, retorna null.

##### Exemplo

![remove-posicao1](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-encadeada-removeAtPosition-1.png)
![remove-posicao2](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-encadeada-removeAtPosition-2.png)
![remove-posicao3](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-encadeada-removeAtPosition-3.png)

#### Algoritmo

```javascript
removeAtPosition = (index) => {
    if (this.isEmpty() || !this.get(index)) {
        return null;
    }
    let item = null;
    let aux = null;
    if (index == 0) {
        item = this.head.value;
        this.head = this.head.next;
        this.size--;
        return item;
    }
    if (index == this.getSize() - 1) {
        item = this.get(index);
        aux = this.getNode(index - 1);
        aux.next = null;
        this.size--;
        return item;
    }
    aux = this.getNode(index - 1);
    item = (aux.next).value;
    aux.next = (aux.next).next;
    this.size--;
    return item;
};
```

#### Remover um elemento específico

Remove a primeira ocorrência do elemento fornecido na lista encadeada. Retorna true se a lista conter o elemento e false caso contrário.

#### Algoritmo

```javascript
remove = (elem) => {
    let index = this.indexOf(elem);
    if (this.isEmpty() || index == -1) {
        return false;
    }
    this.removeAtPosition(index);
    return true;
};
```

### Exemplo prático

#### Lista de tarefas (To-Do List)

*Descrição*: Implementar uma aplicação de lista de tarefas utilizando listas encadeadas. Cada nó da lista deverá representar uma tarefa.

- Uma tarefa deve ter os campos: id, descrição, tipo, status (pendente | concluida).

- Implementar as seguintes operações:

    - Inserir uma tarefa na lista (parâmetro opcional: posição. Se não for informada, insere ao final);

    - Retornar lista com tarefas de um dado tipo;

    - Buscar tarefa por id;

    - Deletar tarefa por id;

    - Marcar uma tarefa como concluída por id;

    - Editar descrição, tipo, status de uma tarefa por id;

    - Reposicionar uma tarefa, caso a posição de destino não exista, não muda a tarefa de posição.

## Listas duplamente encadeadas

#### Introdução:

- Também podem ser chamadas de **listas duplamente ligadas** (*Doubly Linked Lists*).

- **Definição**: É um tipo de lista onde cada elemento *aponta* para o seu **sucessor** e o seu **antecessor** na lista.

    - Cada elemento da lista encadeada é chamado de **nó** (*node*). 

    - Um **nó** é uma estrutura que será composta por **três informações** ou campos:

        - **dado**: Informação que queremos armazenar na lista (ex: número, string, objeto)

        - **próximo**: Referência ou posição para o próximo elemento da lista.

        - **anterior**: Referência ou posição para o nó anterior (antecessor).

- Na lista duplamente encadeada teremos uma referência para o primeiro elemento (nó) da lista, chamado de cabeça (*head*) e uma cauda (*tail*) que aponta para o último elemento (nó).

![listas-duplamente-encadeadas](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-duplamente-encad.png)
<p align="center">Representacão de um nó e da lista duplamente encadeada</p>


#### Vantagens

- **Flexibilidade na Navegação**: Na lista duplamente encadeada podemos navegar em ambas as direções, facilitando operações como inserção e remoção de elementos em qualquer ponto da lista.

- Não precisa movimentar os elementos nas operações de inserção e remoção.

![listas-dup-encad-insercao](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-lista-dupl-encad-insercao.png)
<p align="center">Exemplo operação de inserção</p>

- Operações como reverter uma lista (*reverse*) em comparação com a lista encadeada.

![listas-dup-encad-reverse](https://raw.githubusercontent.com/devsuperior/eda-assets/fcdd76d7c8131805936eb4464526686a444df8d8/img/exemplo-lista-encad-reverseV2.png)
<p align="center">Comparação operação reverter listas</p>

- Para reverter uma lista duplamente encadeada, você ainda precisa percorrer a lista, mas em comparação com a lista encadeada simples, você pode economizar tempo, já que pode acessar os nós tanto do próximo quanto do anterior. Então, enquanto você precisa passar por cada nó, você está economizando em termos de acessos.

#### Desvantagens

- Acesso indireto aos elementos, ou seja, é necessário percorrer a lista para acessar um elemento (nó) específico.

#### Quando utilizar

- Necessidade de acessar o dado de um elemento antecessor.

![listas-dup-encad-acesso](https://raw.githubusercontent.com/devsuperior/eda-assets/main/img/exemplo-acesso-lista-dupl-encad.png)
<p align="center">Exemplo acesso ao elemento antecessor</p>

### Implementação Lista duplamente encadeada

#### Estrutura nó

Estrutura base do nó, que armazena o valor ou dado de interesse, referência para o próximo elemento e uma referência para o elemento anterior da lista.

##### Algoritmo:

```javascript
class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
```

#### Estrutura Lista duplamente encadeada

Criar estrutura da lista duplamente encadeada, responsável pelo gerenciamento das operações da lista (inserção elementos, remoção, etc).

##### Algoritmo:

```javascript
class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
```

#### Adicionar elemento ao final da lista

Operação para inserir um novo elemento ao final da lista duplamente encadeada.

##### Exemplo

![insercao-final](https://raw.githubusercontent.com/devsuperior/eda-assets/57a67d8fd0e377e4b1999edfada5f9497f85cc9a/img/addAtEnd-list-dupl-encad.png)
<p align="center">Insere elemento no final da lista</p>

##### Algoritmo

```javascript
addAtEnd = (elem) => {
    const node = new Node(elem);
    if (this.isEmpty()) {
        this.head = node;
        this.tail = node;
        this.size += 1;
        return;
    }
    node.prev = this.tail;
    this.tail.next = node;
    this.tail = node;
    this.size += 1;
};
```

#### Retorna um array 
Obtém um array a partir da lista duplamente encadeada

##### Algoritmo

```javascript
toArray = () => {
    let current = this.head;
    let vect = [];
        
    while (current) {
        vect.push(current.value);
        current = current.next;
    }
    return vect;
};
```

#### Obter o tamanho da lista
Operação para consultar o tamanho da lista duplamente encadeada

##### Algoritmo

```javascript
getSize = () => {
    return this.size;
};
```

#### Verificar se a lista está vazia
Retorna verdadeiro se a lista duplamente encadeada estiver vazia, falso caso contrário.

```javascript
isEmpty = () => {
    if (this.head == null) 
        return true;
    return false;
};
```

#### Limpar a lista
Remove todos os elementos da lista duplamente encadeada, deixando-a vazia.

```javascript
clear = () => {
    this.head = null;
    this.tail = null;
    this.size = 0;
};
```

#### Adicionar elemento no início da lista

Adiciona um elemento no início da lista duplamente encadeada.

##### Exemplo

![insercao-inicio-dup](https://raw.githubusercontent.com/devsuperior/eda-assets/57a67d8fd0e377e4b1999edfada5f9497f85cc9a/img/addAtStart-list-dupl-encad.png)
<p align="center">Insere elemento no início da lista</p>

##### Algoritmo

```javascript
addAtStart = (elem) => {
    const node = new Node(elem);
    if (this.isEmpty()) {
        this.head = node;
        this.size = this.size + 1;
        return;
    }
    const aux = this.head;
    this.head = node;
    node.next = aux;
    this.size = this.size + 1;
};
```

#### Obter elemento em uma posição específica

Retorna o elemento na posição especificada da lista duplamente encadeada. se o índice não existir, retorna *null*.

```javascript
get = (index) => {
    let current = this.getNode(index);
    if (current) 
        return current.value;
    return null;
};

getNode = (index) => {
    if (index < 0 || index > this.getSize())
        return null;
        
    let current = this.head;
    let currentIndex = 0;
    while (current !== null && currentIndex < index) {
        current = current.next;
        currentIndex++;
    }
    return current;
};
```

#### Adicionar elemento em uma posição específica

Adiciona um elemento em uma posição específica da lista duplamente encadeada. Se o índice não existir, insere no final.

##### Exemplo

![insercao-posicao](https://raw.githubusercontent.com/devsuperior/eda-assets/57a67d8fd0e377e4b1999edfada5f9497f85cc9a/img/lista-dup-encad-addAtPosition-1.png)
![insercao-posicao2](https://raw.githubusercontent.com/devsuperior/eda-assets/57a67d8fd0e377e4b1999edfada5f9497f85cc9a/img/lista-dup-encad-addAtPosition-2.png)
<p align="center">Insere em qualquer posição da lista</p>

##### Algoritmo

```javascript
addAtPosition = (index, elem) => {
    if (index == 0) {
        this.addAtStart(elem);
        return; 
    }
    if (!this.get(index) || index == this.getSize()) {
        this.addAtEnd(elem);
        return;
    }
    const node = new Node(elem);
    let current = this.getNode(index - 1);
    current.next.prev = node;
    node.next = current.next;
    node.prev = current;
    current.next = node;
    this.size += 1;
};
```

#### Obter a posição de um elemento

Procura um elemento na lista duplamente encadeada e retorna sua posição. Se não existir retorna -1.

#### Algoritmo

```javascript
indexOf = (elem) => {
    let current = this.head;
    let index = 0;
    while(current) {
        if (current.value === elem)
            return index;
        current = current.next;
        index++;
    }
    return -1;
};
```


#### Verifica se um elemento existe na lista

Retorna um true se o elemento existir e false caso o elemento não esteja na lista

#### Algoritmo

```javascript
contains = (elem) => {
    let indexElem = this.indexOf(elem); 
    if (indexElem != -1) {
        return true;
    }
    return false;
};
```

#### Remover elemento do início da lista

Remove um elemento no início da lista duplamente encadeada.

##### Exemplo

![insercao-inicio-dup](https://raw.githubusercontent.com/devsuperior/eda-assets/de495158f9864ff59424e036a3c4d8fd3adcb6fc/img/removeHead-lista-dupl-encad.png)
<p align="center">Remove elemento no início da lista</p>

##### Algoritmo

```javascript
removeHead = () => {
    const node = this.head;
    this.head = this.head.next;

    if (this.head == null) {
        this.tail = null;
    } else {
        this.head.prev = null;
    }
    this.size -= 1;
    return node;
};
```

#### Remover elemento do final da lista

Remove um elemento no final da lista duplamente encadeada.

##### Exemplo

![insercao-fim-dup](https://raw.githubusercontent.com/devsuperior/eda-assets/de495158f9864ff59424e036a3c4d8fd3adcb6fc/img/removeTail-lista-dupl-encad.png)
<p align="center">Remove elemento no final da lista</p>

##### Algoritmo

```javascript
removeTail = () => {
    const node = this.tail;
    this.tail = this.tail.prev;

    if (this.tail == null) {
        this.head = null;
    } else {
        this.tail.next = null;
    }
    this.size -= 1;
    return node;
};
```

#### Remover elemento de uma posição específica

Remove o elemento em uma posição específica da lista duplamente encadeada e retorna o elemento. Se o índice não existir, retorna null.

##### Exemplo

![remove-posicao-list-dup-1](https://raw.githubusercontent.com/devsuperior/eda-assets/de495158f9864ff59424e036a3c4d8fd3adcb6fc/img/removeAtPosition-lista-dupl-encad-1.png)
![remove-posicao-list-dup-2](https://raw.githubusercontent.com/devsuperior/eda-assets/de495158f9864ff59424e036a3c4d8fd3adcb6fc/img/removeAtPosition-lista-dupl-encad-2.png)
<p align="center">Remove elemento de uma posição específica</p>

#### Algoritmo

```javascript
removeAtPosition = (index) => {
    if (this.isEmpty() || !this.get(index)) {
        return null;
    }
    if (index == 0)
        return this.removeHead().value;
    if (index == this.getSize() - 1)
        return this.removeTail().value;
    const current = this.getNode(index);
    current.prev.next = current.next;
    current.next.prev = current.prev;
    this.size -= 1;
    return current.value;
};
```

#### Remover um elemento específico

Remove a primeira ocorrência do elemento fornecido na lista duplamente encadeada. Retorna true se a lista conter o elemento e false caso contrário.

#### Algoritmo

```javascript
remove = (elem) => {
    let index = this.indexOf(elem);
    if (this.isEmpty() || index == -1) {
        return false;
    }
    this.removeAtPosition(index);
    return true;
};
```

#### Reverter uma lista

Reverte os elementos de uma lista duplamente encadeada.

##### Exemplo

![insercao-fim-dup](https://raw.githubusercontent.com/devsuperior/eda-assets/e0af2d9876ae98c06cf4383785a49047b5836445/img/reverse-list-dup-encad.png)
<p align="center">Reverte os elementos de uma lista</p>

##### Algoritmo

```javascript
reverse = () => {
    const nodeHead = this.head;
    const nodeTail = this.tail;

    this.head = nodeTail;
    this.tail = nodeHead;

    let current = nodeHead;
    let aux = null;
    while (current) {
        aux = current.next;
        current.next = current.prev;
        current.prev = aux;
        current = aux;
    }
};
```


