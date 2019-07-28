import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Bridges_in_a_Graph {
// hello there
    static HashSet<Integer> adj[];
    static HashSet<Integer> unVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 5; k++) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            adj = new HashSet[n];
            unVisited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                adj[i] = new HashSet<>();
                unVisited.add(i);
            }
            int[] a = new int[m];
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                String[] line = in.readLine().split(" ");
                int x = Integer.parseInt(line[0]) - 1;
                int y = Integer.parseInt(line[1]) - 1;
                a[i] = x;
                b[i] = y;
                adj[x].add(y);
                adj[y].add(x);
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                adj[a[i]].remove(b[i]);
                adj[b[i]].remove(a[i]);
                unVisited.remove(0);
                dfs(0);
                if (!unVisited.isEmpty()) ans++;
                adj[a[i]].add(b[i]);
                adj[b[i]].add(a[i]);
                for (int j = 0; j < n; j++) unVisited.add(j);
            }
            System.out.println(ans);
        }
    }
    static void dfs (int v) {
        for (int i : adj[v]) {
            if (unVisited.contains(i)) {
                unVisited.remove(i);
                dfs(i);
            }
        }
    }
}
