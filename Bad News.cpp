#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>

char grid[625];
std::vector<int> loc[26], adj[625];
char word[100];
int prev[625];
int m;
// hello there
bool InPath (int v) {
    std::unordered_set<int> nodes;
    nodes.insert(v);
    while (v != prev[v]) {
        v = prev[v];
        if (nodes.count(v)) return true;
        nodes.insert(v);
    }
    return false;
}

bool Good (int v, char t, int depth) {
    for (int i : adj[v]) {
        int temp = prev[i];
        prev[i] = v;
        if (!InPath(i) && grid[i] == t) {
            if (depth == m-1) return true;
            if (Good(i, word[depth+1], depth+1)) return true;
        }
        else prev[i] = temp;
    }
    return false;
}

int main() {
    int n, q;
    scanf("%d %d", &n, &q);
    int moves[8][2] = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {;
            int cell = y*n+x;
            scanf(" %c", &grid[cell]);
            loc[grid[cell] - 'a'].push_back(cell);
            for (int* move : moves) {
                int y2 = y + move[0];
                int x2 = x + move[1];
                if (y2 >= 0 && y2 < n && x2 >= 0 && x2 < n) adj[cell].push_back(y2*n+x2);
            }
        }
    }
    for (int i = 0; i < q; i++) {
        scanf("%s", word);
        m = 0;
        for (int j = 0; j < 100 && m == 0; j++) if (0 > word[j] - 'a' || word[j] - 'a' > 25) m = j;
        bool bad = true;
        std::fill(prev, prev+n*n, 0);
        for (int j : loc[word[0] - 'a']) {
            if (Good(j, word[1], 1)) {
                bad = false;
                break;
            }
        }
        printf("%s\n", bad ? "bad puzzle!" : "good puzzle!");
    }
    return 0;
}
