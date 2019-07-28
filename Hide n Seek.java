import java.util.*;

public class Hide_n_Seek {
    // hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int t = in.nextInt();
        in.nextLine();
        char[][] grid = new char[n][m];
        int[] hiders = new int[t];
        int index = 0;
        int start = -1;
        int cells = n * m;
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < m; j++) {
                int cell = i * m + j;
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'G') start = cell;
                if (grid[i][j] == 'H') {
                    hiders[index] = cell;
                    index++;
                }
            }
        }
        ArrayList<Integer> adj[] = new ArrayList[cells];
        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cell = i * m + j;
                adj[cell] = new ArrayList<>();
                if (grid[i][j] != 'X') {
                    for (int[] move : moves) {
                        int y = i + move[0];
                        int x = j + move[1];
                        if (y >= 0 && x >= 0 && y < n && x < m && grid[y][x] != 'X') adj[cell].add(y * m + x);
                    }
                }
            }
        }
        int[] factorials = new int[t + 1];
        factorials[0] = 1;
        for (int i = 1; i <= t; i++) factorials[i] = factorials[i - 1] * i;
        int[][] last = {{hiders[t - 1]}};
        for (int i = 1; i < t; i++) {
            int[][] current = new int[factorials[i+1]][i+1];
            index = 0;
             for (int[] j : last) {
                 int r = j.length + 1;
                 for (int k = 1; k < r; k++) current[index][k] = j[k-1];
                 current[index][0] = hiders[t-i-1];
                 if (index + 1 < factorials[i+1]) current[index+1] = current[index].clone();
                 index++;
                for (int k = 1; k < r; k++) {
                    int temp = current[index][k];
                    current[index][k] = current[index][k-1];
                    current[index][k-1] = temp;
                    if (index + 1 < factorials[i+1]) current[index+1] = current[index].clone();
                    index++;
                }
            }
            last = current.clone();
        }
        int shortest = Integer.MAX_VALUE;
        for (int[] i : last) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            boolean[] visited = new boolean[cells];
            visited[start] = true;
            int[] depth = new int[cells];
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
            int sum = depth[i[0]];
            for (int j = 0; j < i.length - 1; j++) {
                queue = new LinkedList<>();
                queue.add(i[j]);
                visited = new boolean[cells];
                visited[i[j]] = true;
                depth = new int[cells];
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
                sum += depth[i[j+1]];
            }
            shortest = Math.min(shortest, sum);
        }
        System.out.println(shortest);
    }
}
