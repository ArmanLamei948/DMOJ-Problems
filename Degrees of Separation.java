import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Degrees_of_Separation {
    // Hello there
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> adj[] = new ArrayList[49];
        for (int i = 0; i < 49; i++) adj[i] = new ArrayList<>();
        adj[0].add(2); adj[0].add(5);
        adj[1].add(5);
        adj[2].add(3); adj[2].add(4); adj[2].add(5); adj[2].add(14);
        adj[3].add(2); adj[3].add(4); adj[3].add(5);
        adj[4].add(2); adj[4].add(3); adj[4].add(5);
        adj[5].add(0); adj[5].add(1); adj[5].add(2); adj[5].add(3); adj[5].add(4); adj[5].add(6);
        adj[6].add(5); adj[6].add(7);
        adj[7].add(6); adj[7].add(8);
        adj[8].add(7); adj[8].add(9); adj[8].add(11);
        adj[9].add(8); adj[9].add(10);
        adj[10].add(9); adj[10].add(11);
        adj[11].add(8); adj[11].add(10); adj[11].add(12);
        adj[12].add(11); adj[12].add(13); adj[12].add(14);
        adj[13].add(12);
        adj[14].add(2); adj[14].add(12);
        adj[15].add(16); adj[15].add(17);
        adj[16].add(15); adj[16].add(17);
        adj[17].add(15); adj[17].add(16);
        char command = in.readLine().charAt(0);
        while (command != 'q') {
            int x = Integer.parseInt(in.readLine()) - 1;
            switch (command) {
                case 'i': {
                    int y = Integer.parseInt(in.readLine()) - 1;
                    if (!adj[x].contains(y)) {
                        adj[x].add(y);
                        adj[y].add(x);
                    }
                    break;
                }
                case 'd': {
                    int y = Integer.parseInt(in.readLine()) - 1;
                    if (adj[x].contains(y)) {
                        adj[x].remove(adj[x].indexOf(y));
                        adj[y].remove(adj[y].indexOf(x));
                        break;
                    }
                }
                case 'n': {
                    System.out.println(adj[x].size());
                    break;
                }
                case 'f': {
                    ArrayList<Integer> friends = new ArrayList<>();
                    for (int i : adj[x]) {
                        for (int j : adj[i]) {
                             if (!friends.contains(j) && !adj[x].contains(j) && j != x) friends.add(j);
                        }
                    }
                    System.out.println(friends.size());
                    break;
                }
                case 's': {
                    int y = Integer.parseInt(in.readLine()) - 1;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(x);
                    boolean[] visited = new boolean[49];
                    visited[x] = true;
                    int[] depth = new int[49];
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
                    if (depth[y] == 0) System.out.println("Not connected");
                    else System.out.println(depth[y]);
                    break;
                }
            }
            command = in.readLine().charAt(0);
        }
    }
}
