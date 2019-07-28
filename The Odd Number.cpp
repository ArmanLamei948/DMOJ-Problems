#include <iostream>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    int ans = 0;
    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);
        ans ^= num;
    }
    printf("%d\n", ans);
    return 0;
}
