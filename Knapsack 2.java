import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Knapsack {
// hello there
    static int[] dp;
    static HashSet<Integer> visited[];
    static int n;
    static int[] values;
    static int[] weights;
    static int ans = 0;
    static int l;
    static int w;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        w = Integer.parseInt(line[1]);
        l = 1;
        values = new int[n];
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            line = in.readLine().split(" ");
            weights[i] = Integer.parseInt(line[0]);
            values[i] = Integer.parseInt(line[1]);
            l += values[i];
        }
        dp = new int[l];
        visited = new HashSet[l];
        for (int i = 0; i < l; i++) {
            dp[i] = Integer.MAX_VALUE/2;
            visited[i] = new HashSet<>();
        }
        dp[0] = 0;
        Solve(0);
        int ans = 0;
        for (int i = 1; i < l; i++) if (dp[i] <= w) ans = i;
        System.out.println(ans);
    }
    static void Solve (int val) {
        if (val >= l) return;
        for (int i = 0; i < n; i++) {
            if (!visited[val].contains(i)) {
                int next = val + values[i];
                int weight = dp[val] + weights[i];
                if (weight < dp[next] && weight <= w) {
                    dp[next] = weight;
                    visited[next] = new HashSet<>(visited[val]);
                    visited[next].add(i);
                    Solve(next);
                }
            }
        }
    }
}
