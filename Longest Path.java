import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestPath {

    static ArrayList<Integer> adj[];
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        adj = new ArrayList[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dp[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            adj[Integer.parseInt(line[0])].add(Integer.parseInt(line[1]));
        }
        int max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, solve(i));
        System.out.println(max);
    }

    static int solve (int v) {
        if (dp[v] != -1) return dp[v];
        dp[v] = 0;
        for (int i : adj[v]) dp[v] = Math.max(dp[v], solve(i) + 1);
        return dp[v];
    }
}
