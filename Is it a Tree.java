import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Is_It_a_Tree {
// hello there
    static ArrayList<Integer> adj[];
    static HashSet<Integer> unVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int edges = 0;
        adj = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            String[] line = in.readLine().split(" ");
            adj[i] = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                if (line[j].equals("1")) {
                    adj[i].add(j);
                    edges++;
                }
            }
        }
        if (edges != 6) {
            System.out.println("No");
            System.exit(0);
        }
        unVisited = new HashSet<>();
        for (int i = 1; i <= 3; i++) unVisited.add(i);
        dfs(0);
        System.out.println(unVisited.isEmpty() ? "Yes" : "No");
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
