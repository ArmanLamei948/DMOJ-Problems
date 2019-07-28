#include <iostream>

using namespace std;

int h[100000];
int dp[100000];

int Dif (int a, int b) {
    return a-b < 0 ? b-a : a-b;
}

int min (int a, int b) {
    return a < b ? a : b;
}
// hello there
int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &h[i]);
    dp[0] = 0;
    dp[1] = Dif(h[1], h[0]);
    for (int i = 2; i < n; i++) dp[i] = min(dp[i-1] + Dif(h[i], h[i-1]), dp[i-2] + Dif(h[i], h[i-2]));
    printf("%d", dp[n-1]);
    return 0;
}
