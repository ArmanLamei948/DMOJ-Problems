import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Safe_Square {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        boolean[][] snake = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String row = in.readLine();
            for (int j = 0; j < c; j++) snake[i][j] = row.charAt(j) == 'S';
        }
        int[][] moves = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!snake[i][j]) {
                    int bad = 0;
                    int total = 0;
                    for (int[] move : moves) {
                        int y = i + move[0];
                        int x = j + move[1];
                        if (y >= 0 && y < r && x >= 0 && x < c) {
                            if (snake[y][x]) bad++;
                            total++;
                        }
                    }
                    if ((double) bad / total < 0.5) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
