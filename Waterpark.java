import java.util.ArrayList;
import java.util.Scanner;

public class Waterpark {
    // Hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ArrayList<Integer> adj[] = new ArrayList[n];
        ArrayList<Integer> reverseAdj[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        while (a != 0) {
            adj[a - 1].add(b - 1);
            reverseAdj[b - 1].add(a - 1);
            a = in.nextInt();
            b = in.nextInt();
            in.nextLine();
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) for (int j : reverseAdj[i]) dp[i] += dp[j];
        System.out.println(dp[n-1]);
    }
}
