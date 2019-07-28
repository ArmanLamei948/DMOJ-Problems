import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // hello there
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] adj = new int[9999];
        for (int i = 0; i < n; i++) {
            adj[in.nextInt() - 1] = in.nextInt() - 1;
            in.nextLine();
        }
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        while (a != 0) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(a-1);
            boolean[] visited = new boolean[9999];
            visited[a-1] = true;
            int[] depth = new int[9999];
            Arrays.fill(depth, -1);
            while (!queue.isEmpty()) {
                int v = queue.remove();
                int i = adj[v];
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    depth[i] = depth[v] + 1;
                }
            }
            int ans = depth[b-1];
            if (ans == -1) System.out.println("No");
            else System.out.println("Yes " + ans);
            a = in.nextInt();
            b = in.nextInt();
            in.nextLine();
        }
    }
}
