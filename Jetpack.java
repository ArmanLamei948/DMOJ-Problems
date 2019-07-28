import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Jetpack {

    static boolean[][] marked;
    static int[][] prev;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        marked = new boolean[10][n];
        for (int i = 0; i < 10; i++) {
            String row = in.readLine();
            for (int j = 0; j < n; j++) marked[i][j] = row.charAt(j) == 'X';
        }
        prev = new int[10][n];
        prev[9][0] = -1;
        search(9, 1, 9);
        search(8, 1, 9);
        int[] path = new int[n];
        path[0] = 9;
        boolean iterate = true;
        for (int y = 0; y < 10 && iterate; y++) {
            if (prev[y][n-1] != 0) {
                int v1 = y;
                int v2 = n - 1;
                int index = n - 1;
                while (prev[v1][v2] != -1) {
                    path[index] = v1;
                    v1 = prev[v1][v2];
                    v2--;
                    index--;
                }
                iterate = false;
            }
        }
        boolean pressing = false;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (((path[i] < path[i-1]) || (path[i] == path[i-1] && path[i] == 0)) && !pressing) {
                pressing = true;
                start.add(i-1);
            } else if (((path[i] > path[i-1]) || (path[i] == path[i-1] && path[i] == 9)) && pressing) {
                pressing = false;
                end.add(i-1);
            }
        }
        int m = start.size();
        if (m > end.size()) end.add(n-1);
        System.out.println(m);
        for (int i = 0; i < m; i++) System.out.println(start.get(i) + " " + (end.get(i) - start.get(i)));
    }
    static void search (int ycur, int xcur, int yprev) {
        if (marked[ycur][xcur]) return;
        marked[ycur][xcur] = true;
        prev[ycur][xcur] = yprev;
        if (xcur == n - 1) return;
        search(Math.max(ycur - 1, 0), xcur + 1, ycur);
        search(Math.min(ycur + 1, 9), xcur + 1, ycur);
    }
}
