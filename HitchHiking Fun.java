import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HitchHiking_Fun {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        ArrayList<Integer> adj[] = new ArrayList[n];
        ArrayList<Integer> cost[] = new ArrayList[n];
        long[] shortest = new long[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            cost[i] = new ArrayList<>();
            shortest[i] = 10_000_000_000L;
        }
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            int c = line[2].equals("1") ? 100_001 : 1;
            adj[a].add(b);
            adj[b].add(a);
            cost[a].add(c);
            cost[b].add(c);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        shortest[0] = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i = 0; i < adj[v].size(); i++) {
                int neighbour = adj[v].get(i);
                long distance = shortest[v] + cost[v].get(i);
                if (distance < shortest[neighbour]) {
                    shortest[neighbour] = distance;
                    queue.add(neighbour);
                }
            }
        }
        if (shortest[n-1] == 10_000_000_000L) System.out.println(-1);
        else {
            long dang = shortest[n-1] / 100_001;
            System.out.println(dang + " " + (dang + shortest[n-1] % 100_001));
        }
    }
}
