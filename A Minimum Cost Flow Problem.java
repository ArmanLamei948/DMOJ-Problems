import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] disj;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int[][] adj = new int[n + 1][];
        disj = new int[n + 1];
        for (int i = 1; i <= n; i++) disj[i] = i;
        int[] a = new int[m];
        int[] b = new int[m];
        int[] neighbours = new int[n + 1];
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            a[i] = Integer.parseInt(line[0]);
            b[i] = Integer.parseInt(line[1]);
            neighbours[a[i]]++;
            neighbours[b[i]]++;
            int x = find(a[i]);
            int y = find(b[i]);
            if (x != y) disj[Math.max(x, y)] = Math.min(x, y);
        }
        for (int i = 1; i <= n; i++) adj[i] = new int[neighbours[i]];
        int[] index = new int[n + 1];
        for (int i = 0; i < m; i++) {
            adj[a[i]][index[a[i]]] = b[i];
            index[a[i]]++;
            adj[b[i]][index[b[i]]] = a[i];
            index[b[i]]++;
        }
        int unNeeded = m;
        int isolated = -1;
        boolean[] marked = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = find(i);
            if (!marked[x]) {
                isolated++;
                marked[x] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(x);
                boolean[] visited = new boolean[n + 1];
                visited[x] = true;
                while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int j : adj[v]) {
                        if (!visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                            unNeeded--;
                        }
                    }
                }
            }
        }
        System.out.println(Math.max(0, isolated - Math.min(unNeeded, k)));
    }
    static int find (int n) {
        if (disj[n] == n) return n;
        return disj[n] = find(disj[n]);
    }
}
