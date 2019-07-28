import java.util.ArrayList;
import java.util.Scanner;

public class Love {

    static String str, let;
    static long[] dp;
    static ArrayList<Integer> loc[] = new ArrayList[4];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        str = in.next();
        let = "evol";
        int n = str.length();
        dp = new long[n];
        loc = new ArrayList[4];
        for (int i = 0; i < 4; i++) loc[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp[i] = str.charAt(i) == 'l' ? 1 : -1;
            int index = let.indexOf(str.charAt(i));
            if (index != -1) loc[index].add(i);
        }
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) ans += solve(i, 0);
        System.out.println(ans);
    }

    static long solve (int n, int depth) {
        if (str.charAt(n) != let.charAt(depth)) return 0;
        if (dp[n] != -1) return dp[n];
        dp[n] = 0;
        for (int i : loc[depth + 1]) if (i < n) dp[n] += solve(i, depth + 1);
        return dp[n];
    }
}
