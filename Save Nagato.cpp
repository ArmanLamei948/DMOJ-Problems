#include <iostream>
#include <vector>
#include <queue>

using namespace std;
// hello there
int main() {
    int n;
    scanf("%d", &n);
    auto* adj = new vector<int>[n];
    for (int i = 1; i < n; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        a--;
        b--;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    int* max = new int[n];
    queue<int> q;
    q.push(0);
    bool* visited = new bool[n];
    fill(visited, visited+n, false);
    visited[0] = true;
    int* depth = new int[n];
    depth[0] = 1;
    max[0] = 1;
    int f1 = 0;
    while (!q.empty()) {
        int v = q.front();
        q.pop();
        for (int i : adj[v]) {
            if (!visited[i]) {
                q.push(i);
                visited[i] = true;
                depth[i] = depth[v] + 1;
                max[i] = depth[i];
                if (depth[i] > depth[f1]) f1 = i;
            }
        }
    }
    q.push(f1);
    fill(visited, visited+n, false);
    visited[f1] = true;
    depth[f1] = 1;
    int f2 = f1;
    while (!q.empty()) {
        int v = q.front();
        q.pop();
        for (int i : adj[v]) {
            if (!visited[i]) {
                q.push(i);
                visited[i] = true;
                depth[i] = depth[v] + 1;
                if (depth[i] > max[i]) max[i] = depth[i];
                if (depth[i] > depth[f2]) f2 = i;
            }
        }
    }
    q.push(f2);
    fill(visited, visited+n, false);
    visited[f2] = true;
    depth[f2] = 1;
    while (!q.empty()) {
        int v = q.front();
        q.pop();
        for (int i : adj[v]) {
            if (!visited[i]) {
                q.push(i);
                visited[i] = true;
                depth[i] = depth[v] + 1;
                if (depth[i] > max[i]) max[i] = depth[i];
            }
        }
    }
    for (int i = 0; i < n; i++) printf("%d\n", max[i]);
    return 0;
}
