import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        boolean[][] black = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String row = in.readLine();
            for (int j = 0; j < m; j++) black[i][j] = row.charAt(j) == '#';
        }
        double start = System.nanoTime() / Math.pow(10, 9);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!black[i][j]) continue;
                for (int k = j+1; k < m; k++) {
                    if (!black[i][k]) continue;
                    for (int y = i+1; y < n; y++) {
                        if (black[y][j] && black[y][k]) {
                            System.out.println("no");
                            System.exit(0);
                        }
                    }
                }
                if (System.nanoTime() / Math.pow(10, 9) - start >= 1) {
                    System.out.println("yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("yes");
    }
}
