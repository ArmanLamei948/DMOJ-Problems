import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Portals {

    static char[][] grid;
    static boolean[][] visited;
    static int[] pstarty;
    static int[] pstartx;
    static int[] pendy;
    static int[] pendx;
    static int r;
    static int c;
    static int area;
    static char a = 'a';
    static char j = 'j';
    static char A = 'A';
    static char J = 'J';
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        r = Integer.parseInt(in.readLine());
        c = Integer.parseInt(in.readLine());
        grid = new char[r][c];
        int[] xinterest = new int[5];
        int[] yinterest = new int[5];
        pstarty = new int[10];
        pstartx = new int[10];
        pendy = new int[10];
        pendx = new int[10];
        for (int y = 0; y < r; y++) {
            grid[y] = in.readLine().toCharArray();
            for (int x = 0; x < c; x++) {
                char one = '1';
                char five = '5';
                if (one <= grid[y][x] && grid[y][x] <= five) {
                    int temp = grid[y][x] - one;
                    xinterest[temp] = x;
                    yinterest[temp] = y;
                }
                if (a <= grid[y][x] && grid[y][x] <= j) {
                    int temp = grid[y][x] - a;
                    pstarty[temp] = y;
                    pstartx[temp] = x;
                }
                if (A <= grid[y][x] && grid[y][x] <= J) {
                    int temp = grid[y][x] - A;
                    pendy[temp] = y;
                    pendx[temp] = x;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            area = 0;
            visited = new boolean[r][c];
            Search(yinterest[i], xinterest[i]);
            System.out.println(area);
        }
    }
    static void Search (int y, int x) {
        if (visited[y][x] || grid[y][x] == '#') return;
        visited[y][x] = true;
        area++;
        if (a <= grid[y][x] && grid[y][x] <= j) Search(pendy[grid[y][x] - a], pendx[grid[y][x] - a]);
        if (y+1 < r) Search(y+1, x);
        if (y-1 >= 0) Search(y-1, x);
        if (x+1 < c) Search(y, x+1);
        if (x-1 >= 0) Search(y, x-1);
    }
}
