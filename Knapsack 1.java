import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Knapsack {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            line = in.readLine().split(" ");
            weight[i] = Integer.parseInt(line[0]);
            value[i] = Integer.parseInt(line[1]);
        }
        long[] prev = new long[w+1];
        for (int i = 1; i <= n; i++) {
            long[] cur = new long[w+1];
            for (int j = 1; j <= w; j++) {
                cur[j] = Math.max(prev[j], cur[j-1]);
                if (j >= weight[i]) cur[j] = Math.max(cur[j], value[i] + prev[j-weight[i]]);
            }
            prev = cur.clone();
        }
        System.out.println(prev[w]);
    }
}
