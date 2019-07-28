import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Forest_Fires {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            char[][] grid = new char[10][10];
            ArrayList<Integer> fires = new ArrayList<>();
            ArrayList<Integer> tree = new ArrayList<>();
            for (int y = 0; y <= 9; y++) {
                String line = in.readLine();
                for (int x = 0; x <= 9; x++) {
                    grid[y][x] = line.charAt(x);
                    int cell = y * 10 + x;
                    if (grid[y][x] == 'F') fires.add(cell);
                    if (grid[y][x] == 'T') tree.add(cell);
                }
            }
            ArrayList<Integer> adj[] = new ArrayList[100];
            int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int j : tree) {
                int y = j / 10;
                int x = j % 10;
                adj[j] = new ArrayList<>();
                for (int[] move : moves) {
                    int y2 = y + move[0];
                    int x2 = x + move[1];
                    if (y2 >= 0 && y2 <= 9 && x2 >= 0 && x2 <= 9 && grid[y2][x2] == 'T') adj[j].add(y2 * 10 + x2);
                }
            }
            int[] depth = new int[100];
            Arrays.fill(depth, 1000);
            for (int j : fires) {
                int y = j / 10;
                int x = j % 10;
                adj[j] = new ArrayList<>();
                for (int[] move : moves) {
                    int y2 = y + move[0];
                    int x2 = x + move[1];
                    if (y2 >= 0 && y2 <= 9 && x2 >= 0 && x2 <= 9 && grid[y2][x2] == 'T') adj[j].add(y2 * 10 + x2);
                }
                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);
                boolean[] visited = new boolean[100];
                visited[j] = true;
                depth[j] = 0;
                while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int k : adj[v]) {
                        if (!visited[k]) {
                            queue.add(k);
                            visited[k] = true;
                            depth[k] = Math.min(depth[k], depth[v] + 1);
                        }
                    }
                }
            }
            int ans = 0;
            for (int j : tree) ans = Math.max(ans, depth[j]);
            System.out.println(ans == 1000 ? -1 : ans);
            in.readLine();
        }
    }
}
