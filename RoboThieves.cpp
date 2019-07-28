#include <iostream>
#include <vector>
#include <string>
#include  <queue>

using namespace std;

int n, m;
vector<int> adj[10000];
char grid[100][100];
string check;
bool marked[100][100];
vector<int> cameras, dots;
int moves[4][2];
int depth[10000];
queue<int> q;
bool visited[100][100];

// Hello there

int indexof (char item) {
    for (int i = 0; i < 4; i++) if (check[i] == item) return i;
    return -1;
}

void next (int y, int x, int root) {
    if (visited[y][x]) return;
    visited[y][x] = true;
    int cell = y*m+x;
    int index = indexof(grid[y][x]);
    if (index == -1) if (!marked[y][x]) adj[root].push_back(cell);
    switch (grid[y][x]) {
        case 'U': {
            next(y-1, x, root);
            break;
        }
        case 'D': {
            next(y+1, x, root);
            break;
        }
        case 'L': {
            next(y, x-1, root);
            break;
        }
        case 'R': {
            next(y, x+1, root);
            break;
        }
    }
}

int main() {
    scanf("%d %d", &n, &m);
    int s = -1;
    check = "LRUD";
    for (int y = 0; y < n; y++) {
        scanf("%s", grid[y]);
        for (int x = 0; x < m; x++) {
            int cell = y*m+x;
            switch (grid[y][x]) {
                case 'S': {
                    s = cell;
                    break;
                }
                case 'W': {
                    marked[y][x] = true;
                    break;
                }
                case 'C': {
                    cameras.push_back(cell);
                    marked[y][x] = true;
                    break;
                }
                case '.': {
                    dots.push_back(cell);
                    break;
                }
            }
        }
    }
    for (int i : cameras) {
        int y = i/m;
        int x = i%m;
        for (int y2 = y+1; y2 < n && grid[y2][x] != 'W'; y2++) marked[y2][x] = indexof(grid[y2][x]) == -1;
        for (int y2 = y-1; y2 >= 0 && grid[y2][x] != 'W'; y2--) marked[y2][x] = indexof(grid[y2][x]) == -1;
        for (int x2 = x+1; x2 < m && grid[y][x2] != 'W'; x2++) marked[y][x2] = indexof(grid[y][x2]) == -1;
        for (int x2 = x-1; x2 >= 0 && grid[y][x2] != 'W'; x2--) marked[y][x2] = indexof(grid[y][x2]) == -1;
    }
    for (int i = 0; i < 4; i++) {
        moves[i][0] = 0;
        moves[i][1] = 0;
    }
    moves[0][1] = -1;
    moves[1][1] = 1;
    moves[2][0] = -1;
    moves[3][0] = 1;
    int cells = n*m;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            int cell = y*m+x;
            if (marked[y][x] || indexof(grid[y][x]) != -1) continue;
            for (int i = 0; i < 4; i++) {
                int y2 = y + moves[i][0];
                int x2 = x + moves[i][1];
                for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) visited[i][j] = false;
                if (indexof(grid[y2][x2]) != -1) next(y2, x2, cell);
                else if (!marked[y2][x2]) adj[cell].push_back(y2*m+x2);
            }
        }
    }
    q.push(s);
    fill(depth, depth+cells, -1);
    depth[s] = 0;
    while (!q.empty()) {
        int v = q.front();
        q.pop();
        for (int i : adj[v]) {
            if (depth[i] == -1) {
                q.push(i);
                depth[i] = depth[v] + 1;
            }
        }
    }
    for (int i : dots) printf("%d\n", depth[i]);
    return 0;
}
