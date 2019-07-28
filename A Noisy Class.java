import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
// hello there
public class A_Noisy_Class {

    static ArrayList<Integer> adj[];
    static HashSet<Integer> visited[];
    static HashSet<Integer> unVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        adj = new ArrayList[n];
        visited = new HashSet[n];
        unVisited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            visited[i] = new HashSet<>();
            unVisited.add(i);
        }
        for (int i = 0; i < m; i++) {
            String[] line = in.readLine().split(" ");
            adj[Integer.parseInt(line[0]) - 1].add(Integer.parseInt(line[1]) - 1);
        }
        boolean cycle = false;
        while (!unVisited.isEmpty() && !cycle) {
            for (int i : unVisited) {
                unVisited.remove(i);
                if (Cycle_Detected(i)) cycle = true;
                break;
            }
        }
        System.out.println(cycle ? "N" : "Y");
    }
    static boolean Cycle_Detected (int v) {
        for (int i : adj[v]) {
            if (visited[v].contains(i)) return true;
            visited[v].add(i);
            unVisited.remove(i);
            return Cycle_Detected(i);
        }
        return false;
    }
