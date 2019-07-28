import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dealing_with_Knots {
// hello there
    static ArrayList<Integer> adj[];
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        adj = new ArrayList[1000];
        for (int i = 0; i < 1000; i++) adj[i] = new ArrayList<>();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            adj[Integer.parseInt(line[0]) - 1].add(Integer.parseInt(line[1]) - 1);
        }
        String[] line = in.readLine().split(" ");
        int x = Integer.parseInt(line[0]) - 1;
        int y = Integer.parseInt(line[1]) - 1;
        visited = new boolean[1000];
        visited[x] = true;
        dfs(x);
        System.out.println(visited[y] ? "Tangled" : "Not Tangled");
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
