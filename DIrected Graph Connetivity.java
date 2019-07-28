import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Directed_Graph_Connectivity {
// hello there
    static HashSet<Integer> adj[];
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        adj = new HashSet[n];
        for (int i = 0; i < n; i++) adj[i] = new HashSet<>();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]) - 1;
            b[i] = Integer.parseInt(line[1]) - 1;
            adj[a[i]].add(b[i]);
        }
        for (int i = 0; i < m; i++) {
            adj[a[i]].remove(b[i]);
            visited = new boolean[n];
            dfs(0);
            System.out.println(visited[n-1] ? "YES" : "NO");
            adj[a[i]].add(b[i]);
        }
    }
    static void dfs (int v) {
        for (int i : adj[v]) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
