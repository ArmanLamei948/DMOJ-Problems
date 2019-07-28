import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Vacation {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            String[] line = in.readLine().split(" ");
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(line[j]);
                for (int k = 0; k < 3; k++) if (j != k) dp[i][j] = Math.max(dp[i][j], arr[j] + dp[i-1][k]);
            }
        }
        System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
