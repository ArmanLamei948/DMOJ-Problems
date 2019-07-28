import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BattlePositions {

    static int[] seg, lazy;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int stations = Integer.parseInt(in.readLine());
        int troops = Integer.parseInt(in.readLine());
        int waves = Integer.parseInt(in.readLine());
        seg = new int[4 * stations];
        lazy = new int[4 * stations];
        for (int i = 0; i < waves; i++) {
            String[] line = in.readLine().split(" ");
            int l = Integer.parseInt(line[0]) - 1;
            int r = Integer.parseInt(line[1]) - 1;
            int inc = Integer.parseInt(line[2]);
            update(0, stations - 1, 0, l, r, inc);
        }
        int ans = 0;
        for (int i = 0; i < stations; i++) if (sum(0, stations - 1, 0, i, i) < troops) ans++;
        System.out.println(ans);
    }

    static int update (int i, int j, int node, int l, int r, int inc) {
        seg[node] += lazy[node];
        int a = 2 * node + 1;
        int b = a + 1;
        if (i != j) {
            lazy[a] += lazy[node];
            lazy[b] += lazy[node];
        }
        lazy[node] = 0;
        if (l <= i && r >= j) {
            seg[node] += inc;
            if (i != j) {
                lazy[a] += inc;
                lazy[b] += inc;
            }
            return seg[node];
        }
        if (l > j || r < i) return 0;
        int mid = (i + j) / 2;
        return seg[node] = update(i, mid, a, l, r, inc) + update(mid + 1, j, b, l, r, inc);
    }

    static int sum (int i, int j, int node, int l, int r) {
        seg[node] += lazy[node];
        int a = 2 * node + 1;
        int b = a + 1;
        if (i != j) {
            lazy[a] += lazy[node];
            lazy[b] += lazy[node];
        }
        lazy[node] = 0;
        if (l <= i && r >= j) return seg[node];
        if (l > j || r < i) return 0;
        int mid = (i + j) / 2;
        return sum(i, mid, a, l, r) + sum(mid + 1, j, b, l, r);
    }
}
