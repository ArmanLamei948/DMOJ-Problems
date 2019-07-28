import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Strategic_Bombing {
   // hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] adj = new boolean[26][26];
        boolean[][] road = new boolean[26][26];
        String line = in.readLine();
        while (!line.equals("**")) {
            int a = line.charAt(0) - 65;
            int b = line.charAt(1) - 65;
            adj[a][b] = true;
            adj[b][a] = true;
            road[a][b] = true;
            line = in.readLine();
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[26];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i = 0; i < adj[v].length; i++) {
                if (adj[v][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        if (visited[1]) {
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                for (int j = i+1; j < 26; j++) {
                    if (adj[i][j]) {
                        adj[i][j] = false;
                        adj[j][i] = false;
                        queue = new LinkedList<>();
                        queue.add(0);
                        visited = new boolean[26];
                        visited[0] = true;
                        while (!queue.isEmpty()) {
                            int v = queue.remove();
                            for (int k = 0; k < adj[v].length; k++) {
                                if (adj[v][k] && !visited[k]) {
                                    queue.add(k);
                                    visited[k] = true;
                                }
                            }
                        }
                        adj[i][j] = true;
                        adj[j][i] = true;
                        if (!visited[1]) {
                            if (road[i][j]) System.out.println((char) (i+65) + "" + (char) (j+65));
                            else System.out.println((char) (j+65) + "" + (char) (i+65));
                            ans++;
                        }
                    }
                }
            }
            System.out.println("There are " + ans + " disconnecting roads.");
        }
        else System.out.println("There are 0 disconnecting roads.");
    }
}
