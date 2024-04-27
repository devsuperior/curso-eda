#include <iostream>
#include <vector>
#include <climits>

using namespace std;

class Graph {
public:
    int n;
    vector<vector<int>> dist;

    Graph(int n) : n(n), dist(n, vector<int>(n, INT_MAX)) {}

    void add_edge(int u, int v, int weight) {
        dist[u][v] = weight;
    }

    void floyd_warshall() {
        // Initialize the diagonal with 0
        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
        }

        // Update shortest paths using all vertices as intermediates
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    // If vertex k is on the shortest path from i to j, update the path
                    if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
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

    graph.floyd_warshall();

    cout << "Shortest distances between all pairs of vertices:" << endl;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (graph.dist[i][j] == INT_MAX) {
                cout << "INF ";
            } else {
                cout << graph.dist[i][j] << " ";
            }
        }
        cout << endl;
    }

    return 0;
}
