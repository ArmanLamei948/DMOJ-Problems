#include <bits/stdc++.h>

using namespace std;
// hello there
int main() {
    int t, r, c;
	char letter;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> r; cin >> c;
		vector<vector<char>> symbols;
		for (int j = 0; j < r; j++) {
			vector<char> temp;
			for (int k = 0; k < c; k++) {
				cin >> letter;
				temp.push_back(letter);
			}
			symbols.push_back(temp);
		}
		int len = r * c;
		vector<vector<int>> adj;
		for (int j = 0; j < r; j++) {
			for (int k = 0; k < c; k++) {
				vector<int> temp;
				int v1 = j * c + k;
				int displacements[4][2] = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
				switch (symbols[j][k]) {
				case '+': {
					for (int f = 0; f < 4; f++) {
						int y = j + displacements[f][0];
						int x = k + displacements[f][1];
						if (y >= 0 && y < r && x >= 0 && x < c && symbols[y][x] != '*')
							temp.push_back(y*c + x);
					}
					break;
				}
				case '-': {
					for (int f = 2; f < 4; f++) {
						int y = j + displacements[f][0];
						int x = k + displacements[f][1];
						if (y >= 0 && y < r && x >= 0 && x < c && symbols[y][x] != '*')
							temp.push_back(y*c + x);
					}
					break;
				}
				case '|': {
					for (int f = 0; f < 2; f++) {
						int y = j + displacements[f][0];
						int x = k + displacements[f][1];
						if (y >= 0 && y < r && x >= 0 && x < c && symbols[y][x] != '*')
							temp.push_back(y*c + x);
					}
					break;
				}
				}
				adj.push_back(temp);
			}
		}
		queue<int> q; q.push(0);
		vector<bool> visited; visited.push_back(true);
		for (int j = 1; j < len; j++) visited.push_back(false);
		vector<int> depth;
		depth.push_back(1);
		for (int j = 1; j < len; j++) depth.push_back(-1);
		while (!q.empty()) {
			int v = q.front(); q.pop();
			for (int j : adj[v]) {
				if (!visited[j]) {
					q.push(j);
					visited[j] = true;
					depth[j] = depth[v] + 1;
				}
			}
		}
		cout << depth[len - 1] << endl;
	}
    return 0;
}
