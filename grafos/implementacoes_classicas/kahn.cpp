#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Graph {
public:
    int n;
    vector<vector<int>> adj_list;

    Graph(int n) : n(n), adj_list(n) {}

    void add_edge(int u, int v) {
        adj_list[u].push_back(v);
    }

    vector<int> kahn() {
        vector<int> indegree(n, 0);
        for (int u = 0; u < n; ++u) {
            for (int v : adj_list[u]) {
                indegree[v]++;
            }
        }

        queue<int> q;
        for (int u = 0; u < n; ++u) {
            if (indegree[u] == 0) {
                q.push(u);
            }
        }

        vector<int> result;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            result.push_back(u);

            for (int v : adj_list[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.push(v);
                }
            }
        }

        return result;
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

    vector<int> result = graph.kahn();

    cout << "Topological Order:" << endl;
    for (int node : result) {
        cout << node << " ";
    }
    cout << endl;

    return 0;
}
