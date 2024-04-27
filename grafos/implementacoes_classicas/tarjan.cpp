#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

class Graph {
public:
    int n;
    vector<vector<int>> adj_list;
    vector<int> ids; // Ids of the vertices
    vector<int> low; // Low link values of the vertices
    vector<bool> on_stack; // Whether a vertex is on the stack
    stack<int> st; // Stack for DFS traversal
    int id; // Current id
    int num_scc; // Number of SCCs
    vector<vector<int>> sccs; // SCCs

    Graph(int n) : n(n), adj_list(n), ids(n, -1), low(n), on_stack(n, false), id(0), num_scc(0) {}

    void add_edge(int u, int v) {
        adj_list[u].push_back(v);
    }

    void dfs(int u) {
        ids[u] = low[u] = id++;
        st.push(u);
        on_stack[u] = true;

        for (int v : adj_list[u]) {
            if (ids[v] == -1) {
                dfs(v);
                low[u] = min(low[u], low[v]);
            } else if (on_stack[v]) {
                low[u] = min(low[u], ids[v]);
            }
        }

        // If u is the root of a SCC
        if (ids[u] == low[u]) {
            vector<int> scc;
            while (true) {
                int v = st.top();
                st.pop();
                on_stack[v] = false;
                scc.push_back(v);
                if (v == u) {
                    break;
                }
            }
            sccs.push_back(scc);
            num_scc++;
        }
    }

    void tarjan() {
        for (int u = 0; u < n; ++u) {
            if (ids[u] == -1) {
                dfs(u);
            }
        }
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

    graph.tarjan();

    // Print SCCs
    cout << "Number of Strongly Connected Components: " << graph.num_scc << endl;
    cout << "Vertices in each SCC:" << endl;
    for (int i = 0; i < graph.num_scc; ++i) {
        cout << "SCC " << i << ": ";
        for (int vertex : graph.sccs[i]) {
            cout << vertex << " ";
        }
        cout << endl;
    }

    return 0;
}
