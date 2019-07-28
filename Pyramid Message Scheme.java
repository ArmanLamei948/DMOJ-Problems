import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pyramid_Message_Scheme {
   // hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        in.nextLine();
        for (int i = 0; i < l; i++) {
            int n = in.nextInt();
            in.nextLine();
            String[] list = new String[n+1];
            ArrayList<String> names = new ArrayList<>();
            for (int j = 1; j <= n; j++) list[j] = in.nextLine();
            list[0] = list[n];
            names.add(list[0]);
            for (String j : list) if (!names.contains(j)) names.add(j);
            ArrayList<Integer> adj[] = new ArrayList[names.size()];
            for (int j = 0; j < names.size(); j++) adj[j] = new ArrayList<>();
            for (int j = 0; j < n; j++) adj[names.indexOf(list[j])].add(names.indexOf(list[j+1]));
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            boolean[] visited = new boolean[names.size()];
            visited[0] = true;
            int[] depth = new int[names.size()];
            while (!queue.isEmpty()) {
                int v = queue.remove();
                for (int j : adj[v]) {
                    if (!visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                        depth[j] = depth[v] + 10;
                    }
                }
            }
            int max = 0;
            for (int j : depth) if (j > max) max = j;
            System.out.println(n*10 - max*2);
        }
    }
}
