#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

// Large number to represent positive infinity
const int INF = 0x3f3f3f3f;

// Class for bidirectional graph
class Graph {
public:
    int n;
    vector<pair<int, int>> *adj_list;

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

    int dijkstra(int s, int d) {
        // Smallest cost found so far
        vector<int> route_cost;
        vector<int> dist;
        route_cost.resize(n);
        dist.resize(n);

        // True if shortest path has been found
        bool marked[n];

        // Initialization, infinite distance, none marked
        for (int i = 0; i < n; i++) {
            route_cost[i] = INF;
            dist[i] = INF;
            marked[i] = false;
        }

        // Initialization of the source
        route_cost[s] = 0;
        dist[s] = 1;

        for (int k = 0; k < n; k++) {
            int current = -1;

            for (int i = 0; i < n; i++) {
                if (marked[i])
                    continue;

                // If there's none yet or found one that reduces the cost
                if (current == -1 || route_cost[i] < route_cost[current])
                    current = i;
            }

            marked[current] = true;

            // Relaxation of edges
            for (int i = 0; i < (int) adj_list[current].size(); i++) {
                int neighbor = adj_list[current][i].first;
                int weight = adj_list[current][i].second;

                route_cost[neighbor] = min(route_cost[neighbor], route_cost[current] + weight);
                dist[neighbor] = min(dist[neighbor], dist[current] + 1);
            }
        }

        // Price of the shortest path * number of unvisited cities
        return route_cost[d] * (n - dist[d]);
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
    int standard_cost = graph.prim();
    // Cost of the shortest path
    int vip_cost = graph.dijkstra(0, target);

    // Prints the minimum price
    if (vip_cost < standard_cost)
        cout << "VIP\n" << vip_cost << endl;
    else
        cout << "STANDARD\n" << standard_cost << endl;

    return 0;
}
