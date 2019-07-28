import java.util.Scanner;

public class Quantum_Operations {
    // hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int r = in.nextInt();
        int c = in.nextInt();
        in.nextLine();
        int[][] tensorproduct = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) tensorproduct[i][j] = in.nextInt();
            in.nextLine();
        }
        for (int i = 1; i < n; i++) {
            r = in.nextInt();
            c = in.nextInt();
            in.nextLine();
            int[][] prev = tensorproduct.clone();
            int r2 = prev.length;
            int c2 = prev[0].length;
            int[][] next = new int[r][c];
            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) next[y][x] = in.nextInt();
                in.nextLine();
            }
            int r3 = r * r2;
            int c3 = c * c2;
            tensorproduct = new int[r3][c3];
            int index = 0;
            for (int y1 = 0; y1 < r2; y1++) {
                for (int y2 = 0; y2 < r; y2++) {
                    for (int x1 = 0; x1 < c2; x1++) {
                        for (int x2 = 0; x2 < c; x2++) {
                            tensorproduct[index/c3][index%c3] = prev[y1][x1] * next[y2][x2];
                            index++;
                        }
                    }
                }
            }
        }
        int[] ans = new int[6];
        for (int i = 0; i < 6; i += 2) ans[i] = Integer.MIN_VALUE;
        for (int i = 1; i < 6; i += 2) ans[i] = Integer.MAX_VALUE;
        for (int[] i : tensorproduct) {
            int sum = 0;
            for (int j : i) {
                sum += j;
                ans[0] = Math.max(ans[0], j);
                ans[1] = Math.min(ans[1], j);
            }
            ans[2] = Math.max(ans[2], sum);
            ans[3] = Math.min(ans[3], sum);
        }
        for (int x = 0; x < tensorproduct[0].length; x++) {
            int sum = 0;
            for (int y = 0; y < tensorproduct.length; y++) sum += tensorproduct[y][x];
            ans[4] = Math.max(ans[4], sum);
            ans[5] = Math.min(ans[5], sum);
        }
        for (int i : ans) System.out.println(i);
    }
}
