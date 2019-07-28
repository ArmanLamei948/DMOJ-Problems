import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Golf {
   // Hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        int[] dp = new int[d+1];
        int[] clubs = new int[c];
        boolean[] club = new boolean[5281];
        for (int i = 0; i < c; i++) {
            clubs[i] = Integer.parseInt(in.readLine());
            club[clubs[i]] = true;
        }
        Arrays.sort(clubs);
        for (int i = 1; i <= d; i++) {
            if (club[i]) dp[i] = 1;
            else {
                for (int j = c-1; j >= 0; j--) {
                    int temp = i - clubs[j];
                    if (temp >= 1 && dp[temp] != 0) {
                        dp[i] = dp[temp] + 1;
                        break;
                    }
                }
            }
        }
        System.out.println(dp[d] == 0 ? "Roberta acknowledges defeat." : "Roberta wins in " + dp[d] + " strokes.");
    }
}
