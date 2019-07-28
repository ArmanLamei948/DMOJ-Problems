import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Mountain_Hiking {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] moves = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        for (int k = 0; k < 5; k++) {
            int[][] graph = new int[10][10];
            for (int y = 0; y < 10; y++) {
                String line = in.readLine();
                for (int x = 0; x < 10; x++) graph[y][x] = Integer.parseInt(line.substring(x, x+1));
            }
            ArrayList<Integer> adj[] = new ArrayList[100];
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    int cell = y*10+x;
                    adj[cell] = new ArrayList<>();
                    for (int[] move : moves) {
                        int y2 = y + move[0];
                        int x2 = x + move[1];
                        if (y2 >= 0 && y2 < 10 && x2 >= 0 && x2 < 10) {
                            int dif = graph[y2][x2] - graph[y][x];
                            if (-1 <= dif && dif <= 1) adj[cell].add(y2*10+x2);
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
                int node = i*10;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(node);
                boolean[] visited = new boolean[100];
                visited[node] = true;
                int[] depth = new int[100];
                Arrays.fill(depth, Integer.MAX_VALUE);
                depth[node] = 0;
                while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int j : adj[v]) {
                        if (!visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                            depth[j] = depth[v] + 1;
                        }
                    }
                }
                for (int j = 9; j <= 99; j += 10) min = Math.min(min, depth[j]);
            }
            System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
            in.readLine();
        }
    }
}
