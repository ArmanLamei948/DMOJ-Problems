import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] respiration;
    static int[] photosynthesis;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 10; k++) {
            int[] cows = new int[4];
            String[] line = in.readLine().split(" ");
            for (int i = 0; i < 4; i++) cows[i] = Integer.parseInt(line[i]);
            photosynthesis = new int[4];
            line = in.readLine().split(" ");
            for (int i = 0; i < 4; i++) {
                photosynthesis[i] = Integer.parseInt(line[i]);
                if (i == 0 && photosynthesis[0] == 0) photosynthesis[0] = 1;
                if (i == 1 && photosynthesis[1] == 0) photosynthesis[1] = 1;
            }
            max = cows[1];
            respiration = new int[4];
            line = in.readLine().split(" ");
            for (int i = 0; i < 4; i++) respiration[i] = Integer.parseInt(line[i]);
            // 0: photosynthesize, 1: respiratize
            Solve(cows, 0);
            Solve(cows, 1);
            System.out.println(max);
        }
    }

    static void Solve(int[] cows, int dir) {
        int[] copy = cows.clone();
        max = Math.max(max, copy[1]);
        if (dir == 0) {
            int photomax = Math.min(copy[0] / photosynthesis[0], cows[2] / photosynthesis[1]);
            copy[0] -= photosynthesis[0] * photomax;
            copy[2] -= photosynthesis[1] * photomax;
            copy[1] += photosynthesis[3] * photomax;
            copy[3] += photosynthesis[2] * photomax;
            if (photomax != 0) Solve(copy, 1);
        } else if (copy[3] >= respiration[0] && copy[1] >= respiration[1]) {
            copy[3] -= respiration[0];
            copy[1] -= respiration[1];
            copy[0] += respiration[2];
            copy[2] += respiration[3];
            Solve(copy, 0);
            Solve(copy, 1);
        }
    }
}
