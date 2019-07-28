import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test_Scores {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        long k = Integer.parseInt(line[2]);
        int[] x = new int[n];
        int[] y = new int[n];
        long score = 0;
        Queue<Integer> indexes[] = new Queue[1_000_001];
        for (int i = 0; i <= 1_000_000; i++) indexes[i] = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            line = in.readLine().split(" ");
            x[i] = Integer.parseInt(line[0]);
            score += x[i];
            y[i] = Integer.parseInt(line[1]);
            indexes[y[i]].add(i);
        }
        long req = n * k;
        Arrays.sort(y);
        long hours = 0;
        for (int i = 0; i < n && score < req; i++) {
            int cur = x[indexes[y[i]].remove()];
            long increase = Math.min(req - score, m - cur);
            hours += increase * y[i];
            score += increase;
        }
        System.out.println(hours);
    }
}
