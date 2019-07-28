import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Alex_and_Animal_Rights {
// hello there
    static char[][] grid;
    static TreeSet<Integer> unVisited;
    static int c;
    static boolean monkey;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        grid = new char[r][c];
        unVisited = new TreeSet<>();
        for (int i = 0; i < r; i++) {
            String next = in.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = next.charAt(j);
                if (grid[i][j] != '#') unVisited.add(i*c+j);
            }
        }
        int ans = 0;
        while (!unVisited.isEmpty()) {
            monkey = false;
            for (int i : unVisited) {
                Search(i/c, i%c);
                if (monkey) ans++;
                break;
            }
        }
        System.out.println(ans);
    }
    static void Search (int y, int x) {
        int cell = y*c+x;
        if (grid[y][x] == 'M') monkey = true;
        if (unVisited.contains(cell)) {
            unVisited.remove(cell);
            Search(y-1, x);
            Search(y+1, x);
            Search(y, x-1);
            Search(y, x+1);
        }
    }
}
