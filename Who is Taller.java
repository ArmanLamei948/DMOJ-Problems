import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Who_is_Taller {
    // Hello there
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        ArrayList<Integer> adj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            adj[x].add(y);
        }
        line = in.readLine().split(" ");
        int p = Integer.parseInt(line[0]) - 1;
        int q = Integer.parseInt(line[1]) - 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);
        boolean[] visited = new boolean[n];
        visited[p] = true;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int v = queue.remove();
            for (int i : adj[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    if (i == q) {
                        System.out.println("yes");
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found) {
            queue = new LinkedList<>();
            queue.add(q);
            visited = new boolean[n];
            visited[q] = true;
            while (!queue.isEmpty() && !found) {
                int v = queue.remove();
                for (int i : adj[v]) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        if (i == p) {
                            System.out.println("no");
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!found) System.out.println("unknown");
    }
}
