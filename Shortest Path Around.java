import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_Around {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] moves = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
        for (int k = 0; k < 5; k++) {
            ArrayList<Integer> xs = new ArrayList<>();
            char[][] grid = new char[10][10];
            for (int y = 0; y < 10; y++) {
                grid[y] = in.readLine().toCharArray();
                for (int x = 0; x < 10; x++) if (grid[y][x] == 'X') xs.add(y*10+x);
            }
            ArrayList<Integer> adj[] = new ArrayList[100];
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    if (grid[y][x] == '#') continue;
                    int cell = y*10+x;
                    adj[cell] = new ArrayList<>();
                    for (int[] move : moves) {
                        int y2 = y + move[0];
                        int x2 = x + move[1];
                        if (y2 >= 0 && y2 < 10 && x2 >= 0 && x2 < 10 && grid[y2][x2] != '#') adj[cell].add(y2*10+x2);
                    }
                }
            }
            int s = xs.get(0);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            boolean[] visited = new boolean[100];
            visited[s] = true;
            int[] depth = new int[100];
            while (!queue.isEmpty()) {
                int v = queue.remove();
                for (int i : adj[v]) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                        depth[i] = depth[v] + 1;
                    }
                }
            }
            System.out.println(depth[xs.get(1)]);
            in.readLine();
        }
    }
}
