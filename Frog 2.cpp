#include <iostream>
// hello there
using namespace std;

int h[100000];
int dp[100000];

int Dif (int a, int b) {
    return a-b < 0 ? b-a : a-b;
}

int max (int a, int b) {
    return a > b ? a : b;
}

int min (int a, int b) {
    return a < b ? a : b;
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    for (int i = 0; i < n; i++) scanf("%d", &h[i]);
    fill(dp, dp+n, 1000000000);
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
        for (int j = i-1; j >= max(i-k, 0); j--) dp[i] = min(dp[i], dp[j] + Dif(h[i], h[j]));
    }
    printf("%d", dp[n-1]);
    return 0;
}
