#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

// Class for bidirectional graph
class Graph {
public:
    int n;
    vector<pair<int, int>> *adj_list;
    
    // Large number to represent positive infinity
    const int INF = 0x3f3f3f3f;

    Graph(int n) {
        this->n = n;
        this->adj_list = new vector<pair<int, int>>[n];
    }

    void add_edge(int u, int v, int w) {
        adj_list[u].push_back({v, w});
        adj_list[v].push_back({u, w});
    }

    int prim() {
        // Minimum weight of edge with one end marked and the other at i
        vector<int> value;
        value.resize(n, INF);

        priority_queue<pair<int, int>> pq;

        // True if i has been included in the MST
        bool marked[n];

        for (int i = 0; i < n; i++)
            marked[i] = false;

        int mst_cost = 0;

        value[0] = 0;
        pq.push({0, 0});

        for (int k = 0; k < n; k++) {
            int current;

            // Find the vertex
            while (true) {
                current = pq.top().second;
                pq.pop();

                if (!marked[current])
                    break;
            }

            // Add current to the MST
            marked[current] = true;
            mst_cost += value[current];

            // Traverse neighbors putting smaller ones in the queue to process
            for (int j = 0; j < (int) adj_list[current].size(); j++) {
                int neighbor = adj_list[current][j].first;
                int weight = adj_list[current][j].second;

                if (value[neighbor] > weight) {
                    value[neighbor] = weight;
                    // Add negative weight to prioritize smaller ones first
                    pq.push({-value[neighbor], neighbor});
                }
            }
        }
        return mst_cost;
    }
};

int main() {
    int n, m;
    cin >> n >> m;

    Graph graph(n);

    // Reading edges and weights and adding them to the graph
    for (int i = 0, u, v, w; i < m; i++) {
        cin >> u >> v >> w;
        graph.add_edge(u, v, w);
    }

    int target;
    cin >> target;

    // Cost of the MST
    int cost = graph.prim();

    cout << cost << endl;
}
