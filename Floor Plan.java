import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Floor_Plan {
    // hello there
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int floor = Integer.parseInt(in.readLine());
        int r = Integer.parseInt(in.readLine());
        int c = Integer.parseInt(in.readLine());
        char[][] grid = new char[r][c];
        boolean[][] marked = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String line = in.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'I') marked[i][j] = true;
            }
        }
        int cells = r*c;
        int[][] moves = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
        ArrayList<Integer> adj[] = new ArrayList[cells];
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                adj[y*c + x] = new ArrayList<>();
                if (!marked[y][x]) {
                    for (int[] move : moves) {
                        int newY = y + move[0];
                        int newX = x + move[1];
                        if (newY >= 0 && newY < r && newX >= 0 && newX < c && !marked[newY][newX]) {
                            adj[y * c + x].add(newY * c + newX);
                        }
                    }
                }
            }
        }
        ArrayList<Integer> areas = new ArrayList<>();
        for (int i = 0; i < cells; i++) {
            if (!marked[i/c][i%c]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                marked[i/c][i%c] = true;
                int area = 1;
                while (!queue.isEmpty()) {
                    int v = queue.remove();
                    for (int j : adj[v]) {
                        if (!marked[j/c][j%c]) {
                            queue.add(j);
                            marked[j/c][j% c] = true;
                            area++;
                        }
                    }
                }
                areas.add(area);
            }
        }
        Collections.sort(areas);
        int rooms = 0;
        for (int i = areas.size()-1; i >= 0 && floor >= areas.get(i); i--) {
            floor -= areas.get(i);
            rooms++;
        }
        if (rooms == 1) System.out.println(rooms + " room, " + floor + " square metre(s) left over");
        else System.out.println(rooms + " rooms, " + floor + " square metre(s) left over");
    }
}
