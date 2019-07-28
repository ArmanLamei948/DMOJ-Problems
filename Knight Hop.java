import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] moves = {{-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        ArrayList<Integer> adj[] = new ArrayList[64];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int cell = i * 8 + j;
                adj[cell] = new ArrayList<>();
                for (int[] move : moves) {
                    int y = i + move[0];
                    int x = j + move[1];
                    if (0 <= y && y < 8 && 0 <= x && x < 8) adj[cell].add(y * 8 + x);
                }
            }
        }
        Scanner in = new Scanner(System.in);
        int sy = in.nextInt() - 1;
        int sx = in.nextInt() - 1;
        int dy = in.nextInt() - 1;
        int dx = in.nextInt() - 1;
        int start = sy * 8 + sx;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[64];
        visited[start] = true;
        int[] depth = new int[64];
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
        System.out.println(depth[dy * 8 + dx]);
    }
}
