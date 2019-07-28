import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Artskjid {

    static ArrayList<Integer>[] adj, cost;
    static int ans;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        adj = new ArrayList[n];
        cost = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            cost[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            adj[a].add(Integer.parseInt(line[1]));
            cost[a].add(Integer.parseInt(line[2]));
        }
        solve(0, 1, 0);
        System.out.println(ans);
    }

    static void solve (int v, int visited, int length) {
        if (v == n - 1) ans = Math.max(ans, length);
        else {
            for (int i = 0; i < adj[v].size(); i++) {
                int node = adj[v].get(i);
                if ((visited & (1 << node)) != (1 << node)) {
                    solve(node, visited | (1 << node), length + cost[v].get(i));
                }
            }
        }
    }
}
