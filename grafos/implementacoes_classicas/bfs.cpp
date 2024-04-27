#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

class Graph {
public:
    int n;
    vector<vector<int>> adj_list;

    Graph(int n) : n(n), adj_list(n) {}

    void add_edge(int u, int v) {
        adj_list[u].push_back(v);
        adj_list[v].push_back(u); // Assuming the graph is undirected
    }

    void bfs(int start) {
        vector<bool> visited(n, false);
        queue<int> q;

        q.push(start);
        visited[start] = true;

        while (!q.empty()) {
            int current = q.front();
            q.pop();
            cout << current << " "; // Print the current node

            for (int neighbor : adj_list[current]) {
                if (!visited[neighbor]) {
                    q.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        cout << endl;
    }
};

int main() {
    int n, m;
    cin >> n >> m;

    Graph graph(n);

    for (int i = 0, u, v; i < m; i++) {
        cin >> u >> v;
        graph.add_edge(u, v);
    }

    int start_node;
    cin >> start_node;

    cout << "BFS Traversal:" << endl;
    graph.bfs(start_node);

    return 0;
}
