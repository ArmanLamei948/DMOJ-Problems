import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Secret_Party {
// hello there
    static ArrayList<Integer> adj[];
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 5; k++) {
            int n = Integer.parseInt(in.readLine());
            adj = new ArrayList[201];
            for (int i = 1; i <= 200; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = in.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                adj[a].add(b);
                adj[b].add(a);
            }
            visited = new boolean[201];
            visited[2] = true;
            depth = new int[201];
            Arrays.fill(depth, Integer.MAX_VALUE);
            depth[2] = 0;
            dfs(2);
            TreeSet<Integer> ans = new TreeSet<>();
            for (int i : adj[1]) if (depth[i] >= 3) ans.add(i);
            for (int i : ans) System.out.print(i + " ");
            if (ans.isEmpty()) System.out.print("none");
            System.out.println();
        }
    }
    static void dfs (int v) {
        for (int i : adj[v]) {
            if (!visited[i] && i != 1) {
                visited[i] = true;
                depth[i] = depth[v] + 1;
                dfs(i);
            }
        }
    }
}
