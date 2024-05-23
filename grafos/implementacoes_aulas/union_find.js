class DisjointSet {
    constructor(n) {
        this.parent = [];
        for (let i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }

    // acha parent da componente atual
    find(x) {
        while (this.parent[x] !== x) {
            x = this.parent[x];
        }
        return x;
    }

    // une duas componentes a partir dos parents
    union(x, y) {
        const rootX = this.find(x);
        const rootY = this.find(y);
        if (rootX !== rootY) {
            this.parent[rootY] = rootX;
        }
    }
}

const unionFind = new DisjointSet(7);
unionFind.union(0, 1);
unionFind.union(2, 3);
unionFind.union(3, 4);
unionFind.union(5, 6);
unionFind.union(3, 6);
unionFind.union(6, 1);

console.log(unionFind.parent);
console.log("O representante de 6 eh " + unionFind.find(6))