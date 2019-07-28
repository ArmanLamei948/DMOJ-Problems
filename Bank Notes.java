import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Banknotes {
// hello there
    static int[] b;
    static int[] c;
    static int[][] used;
    static int[] dp;
    static int n;


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        b = new int[n];
        String[] line = in.readLine().split(" ");
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(line[i]);
        c = new int[n];
        line = in.readLine().split(" ");
        for (int i = 0; i < n; i++) c[i] = Integer.parseInt(line[i]);
        int k = Integer.parseInt(in.readLine());
        dp = new int[k+1];
        Arrays.fill(dp, 20_002);
        dp[0] = 0;
        used = new int[k+1][n+1];
        System.out.println(Solve(k));
    }
    static int Solve (int num) {
        if (dp[num] != 20_002) return dp[num];
        dp[num] = 20_001;
        int c1 = num;
        int c2 = 0;
        for (int i = 1; i <= n; i++) {
            int temp = num - b[i-1];
            if (temp < 0) continue;
            int prev = Solve(temp);
            if (used[temp][i] != c[i-1] && prev < dp[num]) {
                c1 = temp;
                c2 = i;
                dp[num] = prev + 1;
            }
        }
        used[num] = used[c1].clone();
        used[num][c2]++;
        return dp[num];
    }
}
