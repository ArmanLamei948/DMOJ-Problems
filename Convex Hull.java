import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Convex_Hull {

   // Hello there

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);
        ArrayList<Integer> adj[] = new ArrayList[n];
        ArrayList<Integer> time[] = new ArrayList[n];
        ArrayList<Integer> hull[] = new ArrayList[n];
        int[] mintime = new int[n];
        int[] wearDown = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            time[i] = new ArrayList<>();
            hull[i] = new ArrayList<>();
            mintime[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            int t = Integer.parseInt(line[2]);
            int h = Integer.parseInt(line[3]);
            adj[a].add(b);
            adj[b].add(a);
            time[a].add(t);
            time[b].add(t);
            hull[a].add(h);
            hull[b].add(h);
        }
        line = in.readLine().split(" ");
        int x = Integer.parseInt(line[0]) - 1;
        int y = Integer.parseInt(line[1]) - 1;
        mintime[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i = 0; i < adj[v].size(); i++) {
                int node = adj[v].get(i);
                int distance = mintime[v] + time[v].get(i);
                int wd = wearDown[v] + hull[v].get(i);
                if (distance < mintime[node] && wd < k) {
                    queue.add(node);
                    mintime[node] = distance;
                    wearDown[node] = wd;
                }
            }
        }
        System.out.println(mintime[y] == Integer.MAX_VALUE ? -1 : mintime[y]);
    }
}
