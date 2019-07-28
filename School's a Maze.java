import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Schools_a_Maze {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[][] grid = new char[10][19];
        int[] locations = new int[12];
        Arrays.fill(locations, -1);
        for (int i = 0; i < 10; i++) {
            grid[i] = in.readLine().toCharArray();
            for (int j = 0; j < 19; j++) {
                int temp = grid[i][j] - 65;
                if (0 <= temp && temp <= 11) locations[temp] = i*19+j;
            }
        }
        ArrayList<Integer> adj[] = new ArrayList[190];
        int[][] moves = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 19; j++) {
                int cell = i*19+j;
                adj[cell] = new ArrayList<>();
                if (grid[i][j] == '#') continue;
                for (int[] move : moves) {
                    int y = i + move[0];
                    int x = j + move[1];
                    if (y >= 0 && y < 10 && x >= 0 && x < 19 && grid[y][x] != '#') adj[cell].add(y*19+x);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            char[] nodes = in.readLine().toCharArray();
            int sum = 0;
            for (int j = 1; j < nodes.length; j++) {
                int a = locations[nodes[j-1] - 65];
                Queue<Integer> queue = new LinkedList<>();
                queue.add(a);
                boolean[] visited = new boolean[190];
                visited[a] = true;
                int[] depth = new int[190];
                while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int k : adj[v]) {
                        if (!visited[k]) {
                            queue.add(k);
                            visited[k] = true;
                            depth[k] = depth[v] + 1;
                        }
                    }
                }
                sum += depth[locations[nodes[j] - 65]];
            }
            System.out.println(sum);
        }
    }
}
