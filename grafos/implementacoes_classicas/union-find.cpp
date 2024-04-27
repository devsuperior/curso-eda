#include <iostream>
#include <vector>

using namespace std;

class UnionFind {
public:
    vector<int> parent;

    UnionFind(int n) {
        parent.resize(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i; // Initialize each node as its own parent
        }
    }

    // Find operation without path compression
    int find(int u) {
        while (parent[u] != u) {
            u = parent[u];
        }
        return u;
    }

    // Union operation
    void unite(int u, int v) {
        int root_u = find(u);
        int root_v = find(v);

        if (root_u != root_v) {
            parent[root_u] = root_v; // Simply make one root point to the other
        }
    }

    // Check if two nodes are in the same set
    bool same_set(int u, int v) {
        return find(u) == find(v);
    }
};

int main() {
    int n, m;
    cin >> n >> m;

    UnionFind uf(n);

    // Perform union operations
    for (int i = 0; i < m; ++i) {
        int u, v;
        cin >> u >> v;
        uf.unite(u, v);
    }

    // Perform find operations and check if elements are in the same set
    int queries;
    cin >> queries;
    for (int i = 0; i < queries; ++i) {
        int u, v;
        cin >> u >> v;
        if (uf.same_set(u, v)) {
            cout << u << " and " << v << " are in the same set." << endl;
        } else {
            cout << u << " and " << v << " are not in the same set." << endl;
        }
    }

    return 0;
}
