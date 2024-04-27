#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Class for bidirectional graph
class Graph {
public:
    int n;
    vector<pair<int, pair<int, int>>> edges;

    Graph(int n) : n(n) {}

    void add_edge(int u, int v, int w) {
        edges.push_back({w, {u, v}});
    }

    int find_parent(int vertex, vector<int>& parent) {
        if (parent[vertex] == -1)
            return vertex;
        return find_parent(parent[vertex], parent);
    }

    void union_set(int u, int v, vector<int>& parent) {
        int u_set = find_parent(u, parent);
        int v_set = find_parent(v, parent);
        parent[u_set] = v_set;
    }

    int kruskal() {
        sort(edges.begin(), edges.end());

        vector<int> parent(n, -1);
        int mst_cost = 0;

        for (auto edge : edges) {
            int u = edge.second.first;
            int v = edge.second.second;
            int weight = edge.first;

            if (find_parent(u, parent) != find_parent(v, parent)) {
                mst_cost += weight;
                union_set(u, v, parent);
            }
        }

        return mst_cost;
    }
};

int main() {
    int n, m;
    cin >> n >> m;

    Graph graph(n);

    for (int i = 0, u, v, w; i < m; i++) {
        cin >> u >> v >> w;
        graph.add_edge(u, v, w);
    }

    int target;
    cin >> target;

    int cost = graph.kruskal();
    cout << cost << endl;
}
