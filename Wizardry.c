int prev[2000001];
int ans[2000001];

int main() {
    int n, e, i;
    scanf("%d %d %d", &n, &e, &i);
    int a, b;
    for (int i = 0; i < e; i++) {
        scanf("%d %d", &a, &b);
        prev[++b] = ++a;
    }
    int v = i + 1;
    int index = 0;
    while (prev[v] != 0) {
        v = prev[v];
        ans[index] = v - 1;
        index++;
    }
    for (int i = index - 1; i >= 0; i--) printf("%d ", ans[i]);
    return 0;
}
