import java.util.Scanner;

public class Water_Damage {
// hello there
    static int c;
    static int r;
    static char[][] grid;
    static boolean[][] down;
    static boolean[][] right;
    static int xfin;
    static int yfin;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int w = in.nextInt();
            in.nextLine();
            c = in.nextInt();
            in.nextLine();
            r = in.nextInt();
            in.nextLine();
            grid = new char[r][c];
            boolean[][] interest = new boolean[r][c];
            for (int y = 0; y < r; y++) {
                String line = in.nextLine();
                for (int x = 0; x < c; x++) {
                    grid[y][x] = line.charAt(x);
                    interest[y][x] = grid[y][x] == 'A';
                }
            }
            down = new boolean[r][c];
            for (int y = 0; y < r-1; y++) for (int x = 0; x < c; x++) down[y][x] = grid[y+1][x] != '#';
            right = new boolean[r][c];
            for (int y = 0; y < r; y++) for (int x = 0; x < c-1; x++) right[y][x] = grid[y][x+1] != '#';
            xfin = 0;
            yfin = 0;
            int ans = 0;
            for (int j = 0; j < w; j++) {
                Place(0, 0);
                if (interest[yfin][xfin]) ans++;
            }
            System.out.println(ans);
        }
    }
    static void Place (int y, int x) {
        if (down[y][x]) Place(y+1, x);
        else if (right[y][x]) Place(y, x+1);
        else {
            if (y >= 1) down[y-1][x] = false;
            if (x >= 1) right[y][x-1] = false;
            xfin = x;
            yfin = y;
        }
    }
}
