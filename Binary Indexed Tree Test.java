import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryIndexedTreeTest {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        long[] sumSeg = new long[4 * n];
        long[] countSeg = new long[400_004];
        int[] arr = new int[n];
        line = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
            update(0, n - 1, 0, i, arr[i], sumSeg);
            int sum = (int) sum(0, 100_000, 0, arr[i], arr[i], countSeg);
            update(0, 100_000, 0, arr[i], sum + 1, countSeg);
        }
        for (int i = 0; i < m; i++) {
            line = in.readLine().split(" ");
            int a = Integer.parseInt(line[1]);
            char c = line[0].charAt(0);
            if (c == 'C') {
                a--;
                int b = Integer.parseInt(line[2]);
                int sum = (int) sum(0, 100_000, 0, arr[a], arr[a], countSeg);
                update(0, 100_000, 0, arr[a], sum - 1, countSeg);
                update(0, n - 1, 0, a, b, sumSeg);
                sum = (int) sum(0, 100_000, 0, b, b, countSeg);
                update(0, 100_000, 0, b, sum + 1, countSeg);
                arr[a] = b;
            }
            if (c == 'S') System.out.println(sum(0, n - 1, 0, a - 1, Integer.parseInt(line[2]) - 1, sumSeg));
            if (c == 'Q') System.out.println(sum(0, 100_000, 0, 0, a, countSeg));
        }
    }

    static void update (int i, int j, int node, int index, int val, long[] seg) {
        if (i == j) seg[node] = val;
        else {
            int mid = (i + j) / 2;
            if (i <= index && index <= mid) update(i, mid, 2 * node + 1, index, val, seg);
            else update(mid + 1, j, 2 * node + 2, index, val, seg);
            seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
        }
    }

    static long sum (int i, int j, int node, int l, int r, long[] seg) {
        if (l <= i && r >= j) return seg[node];
        if (l > j || r < i) return 0;
        int mid = (i + j) / 2;
        return sum(i, mid, 2 * node + 1, l, r, seg) + sum(mid + 1, j, 2 * node + 2, l, r, seg);
    }
}
