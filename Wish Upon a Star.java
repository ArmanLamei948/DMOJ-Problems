import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Wish_Upon_a_Star {

    static ArrayList<Integer> adj[];
    static HashSet<Integer> unVisited;
    static HashSet<Integer> nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        adj = new ArrayList[n];
        unVisited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            unVisited.add(i);
        }
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        while (!unVisited.isEmpty()) {
            for (int i : unVisited) {
                unVisited.remove(i);
                nodes = new HashSet<>();
                nodes.add(i);
                dfs(i);
                int edges = 0;
                for (ArrayList<Integer> neighbours : adj) for (int j : neighbours) if (nodes.contains(j)) edges++;
                edges /= 2;
                if (edges != nodes.size() && edges != nodes.size() - 1) {
                    System.out.println("NO");
                    System.exit(0);
                }
                break;
            }
        }
        System.out.println("YES");
    }
    static void dfs (int v) {
        for (int i : adj[v]) {
            if (!nodes.contains(i)) {
                nodes.add(i);
                unVisited.remove(i);
                dfs(i);
            }
        }
    }
}
