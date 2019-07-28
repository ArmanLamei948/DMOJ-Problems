import java.util.Arrays;
import java.util.Scanner;

public class LCS {
// hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int n = a.length();
        int m = b.length();
        String[][] dp = new String[n+1][m+1];
        for (String[] i : dp) Arrays.fill(i, "");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    if (dp[i-1][j-1].length() >= dp[i][j].length()) dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
