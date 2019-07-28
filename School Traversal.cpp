#include <iostream>
#include <vector>
#include <queue>

using namespace std;
// hello there
int d[6000][6000];
int depth[6000];
bool visited[6000];
vector<int> adj[6000];
vector<int> cost[6000];

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 1; i < n; i++) {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        adj[a].push_back(b);
        adj[b].push_back(a);
        cost[a].push_back(c);
        cost[b].push_back(c);
    }
    queue<int> q;
    for (int i = 0; i < n; i++) {
        q.push(i);
        fill(visited, visited+n, false);
        visited[i] = true;
        depth[i] = 0;
        d[i][i] = 0;
        while (!q.empty()) {
            int v = q.front();
            q.pop();
            for (int j = 0; j < (int) adj[v].size(); j++) {
                int node = adj[v][j];
                if (!visited[node]) {
                    q.push(node);
                    visited[node] = true;
                    depth[node] = depth[v] + cost[v][j];
                    d[i][node] = depth[node];
                }
            }
        }
    }
    int queries;
    scanf("%d", &queries);
    for (int i = 0; i < queries; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        printf("%lld\n", d[a][b]);
    }
    return 0;
}
