import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Train_Ride {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] moves = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
        for (int k = 0; k < 5; k++) {
            ArrayList<char[]> temp = new ArrayList<>();
            char[] line = in.readLine().toCharArray();
            int start = -1;
            int end = -1;
            while (line[0] != 'x') {
                temp.add(line);
                line = in.readLine().toCharArray();
            }
            int n = temp.size();
            char[][] grid = new char[n][10];
            for (int i = 0; i < n; i++) grid[i] = temp.get(i).clone();
            int cells = n*10;
            ArrayList<Integer> adj[] = new ArrayList[cells];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < 10; x++) {
                    if (grid[y][x] == ' ') continue;
                    int cell = y*10+x;
                    if (grid[y][x] == 'S') start = cell;
                    if (grid[y][x] == 'E') end = cell;
                    adj[cell] = new ArrayList<>();
                    for (int[] move : moves) {
                        int y2 = y + move[0];
                        int x2 = x + move[1];
                        if (y2 >= 0 && y2 < n && x2 >= 0 && x2 < 10 && grid[y2][x2] != ' ') adj[cell].add(y2*10+x2);
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            boolean[] visited = new boolean[cells];
            visited[start] = true;
            int[] depth = new int[cells];
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
            System.out.println(depth[end]);
        }
    }
}
