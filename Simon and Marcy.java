import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Simon_and_Marcy {
    // Hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int c = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] princesses = new int[c+1];
        int[] time = new int[c+1];
        for (int i = 1; i <= c; i++) {
            line = in.readLine().split(" ");
            princesses[i] = Integer.parseInt(line[0]);
            time[i] = Integer.parseInt(line[1]);
        }
        int[][] dp = new int[c+1][m+1];
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (j >= time[i]) dp[i][j] = Math.max(dp[i][j], princesses[i] + dp[i-1][j-time[i]]);
            }
        }
        System.out.println(dp[c][m]);
    }
}
