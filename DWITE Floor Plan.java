import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Floor_Plan {
// hello there
    static char[][] grid;
    static boolean[][] visited;
    static int r;
    static int c;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        r = Integer.parseInt(in.readLine());
        c = Integer.parseInt(in.readLine());
        grid = new char[r][c];
        int[] xInterest = new int[5];
        int[] yInterest = new int[5];
        for (int i = 0; i < r; i++) {
            grid[i] = in.readLine().toCharArray();
            char a = '1';
            char b = '5';
            for (int j = 0; j < c; j++) {
                if (a <= grid[i][j] && grid[i][j] <= b) {
                    xInterest[grid[i][j] - a] = j;
                    yInterest[grid[i][j] - a] = i;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            visited = new boolean[r][c];
            ans = 0;
            Search(yInterest[i], xInterest[i]);
            System.out.println(ans);
        }
    }
    static void Search (int y, int x) {
        if (visited[y][x] || grid[y][x] == '#') return;
        visited[y][x] = true;
        ans++;
        if (y+1 < r) Search(y+1, x);
        if (y-1 >= 0) Search(y-1, x);
        if (x+1 < c) Search(y, x+1);
        if (x-1 >= 0) Search(y, x-1);
    }
}
