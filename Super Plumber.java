import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Super_Plumber {

    static int[][] grid;
    static int[][][] dp;
    static int[][] moves = { {-1, 0}, {0, -1}, {1, 0} };
    static int r;
    static int c;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        while (!line[0].equals("0")) {
            r = Integer.parseInt(line[0]);
            c = Integer.parseInt(line[1]);
            grid = new int[r][c];
            dp = new int[r][c][3];
            for (int i = 0; i < r; i++) {
                String row = in.readLine();
                for (int j = 0; j < c; j++) {
                    Arrays.fill(dp[i][j], -1);
                    switch (row.charAt(j)) {
                        case '*': {
                            grid[i][j] = -1;
                        }
                        case '.': {
                            break;
                        }
                        default: {
                            grid[i][j] = Integer.parseInt(row.substring(j, j + 1));
                            break;
                        }
                    }
                }
            }
            Arrays.fill(dp[r-1][0], grid[r-1][0]);
            int a = Solve(r-1, c-1, 0);
            int b = Solve(r-1, c-1, 1);
            int d = Solve(r-1, c-1, 2);
            System.out.println(Math.max(Math.max(a, b), d));
            line = in.readLine().split(" ");
        }
    }
    static int Solve (int y, int x, int dir) {
        if (dp[y][x][dir] != -1 || grid[y][x] == -1) return dp[y][x][dir];
        int y2 = y + moves[dir][0];
        int x2 = x + moves[dir][1];
        if (0 <= y2 && y2 < r && 0 <= x2 && x2 < c && grid[y2][x2] != -1) {
            for (int i = 0; i < 3; i++) {
                if ((i == 0 && dir != 2) || (i == 2 && dir != 0) || i == 1) {
                    dp[y][x][dir] = Math.max(dp[y][x][dir], Solve(y2, x2, i));
                }
            }
        }
        if (dp[y][x][dir] != -1) dp[y][x][dir] += grid[y][x];
        return dp[y][x][dir];
    }
}
