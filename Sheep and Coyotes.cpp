#include <bits/stdc++.h>

using namespace std;
// hello there
int main() {
    int s;
    scanf("%d", &s);
    double sheepx[100];
    double sheepy[100];
    for (int i = 0; i < s; i++) {
        scanf("%lf", &sheepx[i]);
        scanf("%lf", &sheepy[i]);
    }
    bool xVisited[100000];
    bool yVisited[100000];
    fill(xVisited, xVisited+s, false);
    fill(yVisited, yVisited+s, false);
    for (double i = 0; i <= 1000; i += 0.01) {
        double distance[100];
        double min = 2000;
        for (int j = 0; j < s; j++) {
            distance[j] = sqrt(pow(sheepx[j] - i, 2) + pow(sheepy[j], 2));
            min = distance[j] < min ? distance[j] : min;
        }
        for (int j = 0; j < s; j++) {
            int x = (int) (sheepx[j] * 100);
            int y = (int) (sheepy[j] * 100);
            if (distance[j] == min && (!xVisited[x] || !yVisited[y])) {
                printf("%s", "The sheep at (");
                printf("%.2lf", sheepx[j]);
                printf("%s", ", ");
                printf("%.2lf", sheepy[j]);
                printf("%s", ") might be eaten.\n");
                xVisited[x] = true;
                yVisited[y] = true;
            }
        }
    }
    return 0;
}
