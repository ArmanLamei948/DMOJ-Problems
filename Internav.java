import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Internav {
// hello there
    static char[][] grid;
    static int r;
    static int c;
    static boolean[][] marked;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(in.readLine());
        r = Integer.parseInt(in.readLine());
        grid = new char[r][c];
        int[] xrooms = new int[10];
        int[] yrooms = new int[10];
        Arrays.fill(xrooms, -1);
        Arrays.fill(yrooms, -1);
        marked = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = in.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = line.charAt(j);
                marked[i][j] = grid[i][j] == '#';
                if (49 <= grid[i][j] && grid[i][j] <= 57) {
                    xrooms[grid[i][j] - 48] = j;
                    yrooms[grid[i][j] - 48] = i;
                }
            }
        }
        Search(yrooms[1], xrooms[1]);
        for (int i = 1; i <= 9; i++) {
            if (yrooms[i] != -1 && xrooms[i] != -1 && marked[yrooms[i]][xrooms[i]]) System.out.print(i + " ");
        }
    }
    static void Search (int y, int x) {
        marked[y][x] = true;
        if (grid[y][x] == '#') return;
        if (y + 1 < r && !marked[y+1][x])  Search(y+1, x);
        if (y - 1 >= 0 && !marked[y-1][x]) Search(y-1, x);
        if (x + 1 < c && !marked[y][x+1]) Search(y, x+1);
        if (x - 1 >= 0 && !marked[y][x-1]) Search(y, x-1);
    }
}
