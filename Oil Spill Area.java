import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Oil_Spill_Area {
// hello there
    static char[][] grid;
    static HashSet<Integer> visited;
    static int[][] moves = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            grid = new char[10][10];
            int ay = -1;
            int ax = -1;
            for (int y = 0; y <= 9; y++) {
                String line = in.readLine();
                for (int x = 0; x <= 9; x++) {
                    grid[y][x] = line.charAt(x);
                    if (grid[y][x] == 'A') {
                        ay = y;
                        ax = x;
                    }
                }
            }
            visited = new HashSet<>();
            Search(ay, ax);
            System.out.println(visited.size());
            in.readLine();
        }
    }
    static void Search (int y, int x) {
        int cell = y*10+x;
        if (visited.contains(cell)) return;
        visited.add(cell);
        for (int[] move : moves) {
            int y2 = y + move[0];
            int x2 = x + move[1];
            if (grid[y2][x2] == '#') Search(y2, x2);
        }
    }
}
