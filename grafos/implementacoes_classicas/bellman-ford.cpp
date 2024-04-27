#include <iostream>
#include <vector>
#include <climits>

using namespace std;

class Graph {
public:
    int n;
    vector<vector<pair<int, int>>> adj_list;

    Graph(int n) : n(n), adj_list(n) {}

    void add_edge(int u, int v, int weight) {
        adj_list[u].push_back({v, weight});
    }

    vector<int> bellman_ford(int start) {
        vector<int> distance(n, INT_MAX);
        distance[start] = 0;

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; ++i) {
            for (int u = 0; u < n; ++u) {
                for (auto& edge : adj_list[u]) {
                    int v = edge.first;
                    int weight = edge.second;
                    if (distance[u] != INT_MAX && distance[u] + weight < distance[v]) {
                        distance[v] = distance[u] + weight;
                    }
                }
            }
        }

        // Check for negative cycles
        for (int u = 0; u < n; ++u) {
            for (auto& edge : adj_list[u]) {
                int v = edge.first;
                int weight = edge.second;
                if (distance[u] != INT_MAX && distance[u] + weight < distance[v]) {
                    // Negative cycle found
                    distance.clear(); // Clear the distances
                    return distance; // Return empty vector
                }
            }
        }

        return distance;
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

    int start_node;
    cin >> start_node;

    vector<int> distances = graph.bellman_ford(start_node);

    if (distances.empty()) {
        cout << "Negative cycle detected!" << endl;
    } else {
        cout << "Shortest distances from node " << start_node << ":" << endl;
        for (int i = 0; i < n; ++i) {
            cout << "Node " << i << ": ";
            if (distances[i] == INT_MAX) {
                cout << "INF" << endl;
            } else {
                cout << distances[i] << endl;
            }
        }
    }

    return 0;
}
