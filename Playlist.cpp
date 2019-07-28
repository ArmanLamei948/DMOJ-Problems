#include <iostream>

using namespace std;

int values[100];
int weights[100];
int dp[101][30001];

int max (int a, int b) {
    return a > b ? a : b;
}
// hello there
int main() {
    for (int k = 0; k < 5; k++) {
        int w;
        scanf("%d", &w);
        int n;
        scanf("%d", &n);
        for (int i = 0; i < n; i++) {
            char name[100];
            scanf("%s %d %d", name, &values[i], &weights[i]);
            fill(dp[i], dp[i] + w + 1, 0);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                if (j >= weights[i - 1]) dp[i][j] = max(dp[i][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
            }
        }
        printf("%d\n", dp[n][w]);
    }
    return 0;
}
