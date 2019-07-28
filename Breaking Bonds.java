import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Breaking_Bonds {
// hello there
    static ArrayList<Integer> adj[];
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int f = 0; f < 5; f++) {
            String[] line = in.readLine().split(" ");
            int c = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            adj = new ArrayList[c];
            for (int i = 0; i < c; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < b; i++) {
                line = in.readLine().split(" ");
                int x = Integer.parseInt(line[0]) - 1;
                int y = Integer.parseInt(line[1]) - 1;
                adj[x].add(y);
                adj[y].add(x);
            }
            int ans = 0;
            for (int i = 0; i < c; i++) {
                int e = adj[i].size();
                for (int j = 0; j < e; j++) {
                    int temp = adj[i].get(j);
                    adj[i].remove(j);
                    visited = new boolean[c];
                    visited[0] = true;
                    dfs(0);
                    boolean connected = true;
                    for (boolean k : visited) {
                        if (!k) {
                            connected = false;
                            break;
                        }
                    }
                    if (!connected) ans++;
                    adj[i].add(j, temp);
                }
            }
            System.out.println(ans);
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
