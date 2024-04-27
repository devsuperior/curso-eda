#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

class Graph {
public:
    int n;
    vector<vector<int>> adj_list;
    vector<vector<int>> rev_adj_list; // Reverse adjacency list for Kosaraju's algorithm

    Graph(int n) : n(n), adj_list(n), rev_adj_list(n) {}

    void add_edge(int u, int v) {
        adj_list[u].push_back(v);
        rev_adj_list[v].push_back(u); // Reverse the direction of edges for the reverse graph
    }

    void dfs_first(int u, vector<bool>& visited, stack<int>& st) {
        visited[u] = true;

        for (int v : adj_list[u]) {
            if (!visited[v]) {
                dfs_first(v, visited, st);
            }
        }

        st.push(u);
    }

    void dfs_second(int u, vector<bool>& visited, vector<int>& component, int label) {
        visited[u] = true;
        component[u] = label;

        for (int v : rev_adj_list[u]) {
            if (!visited[v]) {
                dfs_second(v, visited, component, label);
            }
        }
    }

    vector<int> kosaraju() {
        vector<bool> visited(n, false);
        stack<int> st;

        // First DFS to fill the stack based on finishing times
        for (int u = 0; u < n; ++u) {
            if (!visited[u]) {
                dfs_first(u, visited, st);
            }
        }

        // Reset visited array
        fill(visited.begin(), visited.end(), false);

        vector<int> component(n, -1);
        int label = 0;

        // Second DFS to process the vertices in the order defined by the stack
        while (!st.empty()) {
            int u = st.top();
            st.pop();

            if (!visited[u]) {
                dfs_second(u, visited, component, label++);
            }
        }

        return component;
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

    vector<int> component = graph.kosaraju();

    // Find the number of SCCs and print vertices in each SCC
    int num_scc = *max_element(component.begin(), component.end()) + 1;
    cout << "Number of Strongly Connected Components: " << num_scc << endl;
    cout << "Vertices in each SCC:" << endl;
    for (int i = 0; i < num_scc; ++i) {
        cout << "SCC " << i << ": ";
        for (int j = 0; j < n; ++j) {
            if (component[j] == i) {
                cout << j << " ";
            }
        }
        cout << endl;
    }

    return 0;
}
