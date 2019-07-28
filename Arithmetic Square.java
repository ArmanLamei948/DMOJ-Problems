import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[][] grid;
    static int xs = 0;
    static String[][] parity;
    static int[][] moves = { {0, 2}, {0, -2}, {2, 0}, {-2, 0} };
   // hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        grid = new int[3][3];
        parity = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                parity[i][j] = "unknown";
                String temp = in.next();
                if (temp.equals("X")) {
                    grid[i][j] = Integer.MAX_VALUE;
                    xs++;
                }
                else {
                    grid[i][j] = Integer.parseInt(temp);
                    parity[i][j] = grid[i][j] % 2 == 0 ? "even" : "odd";
                }
            }
        }
        Update();
        if (grid[1][1] == Integer.MAX_VALUE) {
            grid[1][1] = 0;
            Update();
        }
        if (grid[0][0] == Integer.MAX_VALUE) {
            grid[0][0] = parity[0][0].equals("even") ? 0 : 1;
            Update();
        }
        if (grid[0][2] == Integer.MAX_VALUE) {
            grid[0][2] = parity[0][2].equals("even") ? 0 : 1;
            Update();
        }
        if (grid[2][0] == Integer.MAX_VALUE) {
            grid[2][0] = parity[2][0].equals("even") ? 0 : 1;
            Update();
        }
        if (grid[2][2] == Integer.MAX_VALUE) {
            grid[2][2] = parity[2][2].equals("even") ? 0 : 1;
            Update();
        }
        for (int[] i : grid) {
            for (int j : i) System.out.print(j + " ");
            System.out.println();
        }
    }
    static void Update () {
        boolean updating = true;
        while (updating) {
            updating = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] != Integer.MAX_VALUE) continue;
                    ArrayList<Integer> known = new ArrayList<>();
                    for (int y = 0; y < 3; y++) if (grid[y][j] != Integer.MAX_VALUE) known.add(y);
                    if (known.size() == 2) {
                        int a = known.get(0);
                        int b = known.get(1);
                        if (a == 0 && b == 1) grid[2][j] = 2 * grid[1][j] - grid[0][j];
                        if (a == 0 && b == 2) grid[1][j] = (grid[0][j] + grid[2][j]) / 2;
                        if (a == 1 && b == 2) grid[0][j] = 2 * grid[1][j] - grid[2][j];
                        xs--;
                        updating = true;
                        continue;
                    }
                    known.clear();
                    for (int x = 0; x < 3; x++) if (grid[i][x] != Integer.MAX_VALUE) known.add(x);
                    if (known.size() == 2) {
                        int a = known.get(0);
                        int b = known.get(1);
                        if (a == 0 && b == 1) grid[i][2] = 2 * grid[i][1] - grid[i][0];
                        if (a == 0 && b == 2) grid[i][1] = (grid[i][0] + grid[i][2]) / 2;
                        if (a == 1 && b == 2) grid[i][0] = 2 * grid[i][1] - grid[i][2];
                        xs--;
                        updating = true;
                        continue;
                    }
                }
            }
        }
        updating = true;
        while (updating) {
            updating = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!parity[i][j].equals("unknown")) continue;
                    for (int[] move : moves) {
                        int y = i + move[0];
                        int x = j + move[1];
                        if (0 <= y && y <= 2 && 0 <= x && x <= 2 && !parity[y][x].equals("unknown")) {
                            parity[i][j] = parity[y][x];
                            updating = true;
                            break;
                        }
                    }
                }
            }
        }
    }
}
