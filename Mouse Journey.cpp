#include <stdio.h>
#include <stdbool.h>

int dp[25][25];
bool catcell[25][25];

int main() {
    int r, c;
    scanf("%d %d", &r, &c);
    int k;
    scanf("%d", &k);
    for (int i = 0; i < k; i++) {
        int y, x;
        scanf("%d %d", &y, &x);
        catcell[y-1][x-1] = true;
    }
    dp[0][0] = catcell[0][0] ? 0 : 1;
    for (int i = 1; i < r; i++) dp[i][0] = catcell[i][0] ? 0 : dp[i-1][0];
    for (int i = 1; i < c; i++) dp[0][i] = catcell[0][i] ? 0 : dp[0][i-1];
    for (int i = 1; i < r; i++) for (int j = 1; j < c; j++) dp[i][j] = catcell[i][j] ? 0 : dp[i-1][j] + dp[i][j-1];
    printf("%d", dp[r-1][c-1]);
    return 0;
}
