#include <iostream>
#include <vector>
#include <stack>

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

    void dfs(int start) {
        vector<bool> visited(n, false);
        stack<int> st;

        st.push(start);

        while (!st.empty()) {
            int current = st.top();
            st.pop();

            if (!visited[current]) {
                cout << current << " "; // Print the current node
                visited[current] = true;

                // Push unvisited neighbors onto the stack
                for (int neighbor : adj_list[current]) {
                    if (!visited[neighbor]) {
                        st.push(neighbor);
                    }
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

    cout << "DFS Traversal:" << endl;
    graph.dfs(start_node);

    return 0;
}
