import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DisjointSetTest {

    static int[] disj;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        disj = new int[n + 1];
        for (int i = 1; i <= n; i++) disj[i] = i;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            line = in.readLine().split(" ");
            int x = find(Integer.parseInt(line[0]));
            int y = find(Integer.parseInt(line[1]));
            if (x != y) {
                disj[x] = y;
                ans.add(i);
            }
        }
        if (ans.size() != n - 1) System.out.println("Disconnected Graph");
        else for (int i : ans) System.out.println(i);
    }

    static int find (int n) {
        if (disj[n] == n) return n;
        return disj[n] = find(disj[n]);
    }
}
