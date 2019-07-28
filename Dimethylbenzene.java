import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Dimethylbenzene {
// hello there
    static ArrayList<Integer> adj[];
    static ArrayList<Integer> nodes;
    static HashSet<ArrayList<Integer>> cycles;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        nodes = new ArrayList<>();
        nodes.add(0);
        cycles = new HashSet<>();
        dfs(0, 0);
        System.out.println("NO");
    }
    static void dfs (int v, int visits) {
        if (visits == 5) return;
        for (int l : adj[v]) {
            nodes.add(l);
            int e = nodes.size();
            boolean cycle = false;
            for (int i = 0; i < e && !cycle; i++) {
                for (int j = i; j < e && !cycle; j++) {
                    ArrayList<Integer> temp1 = new ArrayList<>(nodes.subList(i, j + 1));
                    for (int k = j; k < e && !cycle; k++) {
                        for (int f = k; f < e && !cycle; f++) {
                            ArrayList<Integer> temp2 = new ArrayList<>(nodes.subList(k, f + 1));
                            if (temp1.equals(temp2) && !cycles.contains(temp1)) {
                                cycle = true;
                                cycles.add(temp1);
                                HashSet<Integer> distincts = new HashSet<>(temp1);
                                if (distincts.size() == 6) {
                                    System.out.println("YES");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
            dfs(l, visits+1);
        }
    }
}
