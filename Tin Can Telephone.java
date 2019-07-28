import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tin_Can_Telephone {

    static double lowx1, lowy1, highx1, highy1, lowx2, lowy2, highx2, highy2;
    static double x1, y1, x2, y2;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        double xr = Double.parseDouble(line[0]);
        double yr = Double.parseDouble(line[1]);
        double xj = Double.parseDouble(line[2]);
        double yj = Double.parseDouble(line[3]);
        lowx1 = Math.min(xr, xj);
        lowy1 = Math.min(yr, yj);
        highx1 = Math.max(xr, xj);
        highy1 = Math.max(yr, yj);
        boolean verticalA = xj == xr;
        double m = Double.POSITIVE_INFINITY;
        double b = Double.POSITIVE_INFINITY;
        if (!verticalA) {
            m = (yj - yr) / (xj - xr);
            b = yj - m * xj;
        }
        int n = Integer.parseInt(in.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            line = in.readLine().split(" ");
            int c2 = line.length - 1;
            double[] points = new double[c2];
            for (int j = 0; j < c2; j++) {
                points[j] = Double.parseDouble(line[j+1]);
                if (j % 2 != 0 && j >= 3) {
                    y2 = points[j];
                    x2 = points[j-1];
                    y1 = points[j-2];
                    x1 = points[j-3];
                    lowx2 = Math.min(x1, x2);
                    highx2 = Math.max(x1, x2);
                    lowy2 = Math.min(y2, y1);
                    highy2 = Math.max(y2, y1);
                    boolean verticalB = x1 == x2;
                    if (verticalA && verticalB) {
                        if (x1 == xj && ((lowy2 >= lowy1 && lowy2 <= highy1) || (lowy1 >= lowy2 && lowy1 <= highy2))) {
                            ans++;
                            break;
                        }
                    }
                    else if (verticalA) {
                        double m2 = (y2 - y1) / (x2 - x1);
                        double b2 = y2 - m2 * x2;
                        double xp = xj;
                        double yp = m2 * xp + b2;
                        if (Obstruct(xp, yp)) {
                            ans++;
                            break;
                        }
                    }
                    else if (verticalB) {
                        double xp = x1;
                        double yp = m * xp + b;
                        if (Obstruct(xp, yp)) {
                            ans++;
                            break;
                        }
                    }
                    else {
                        double m2 = (y2 - y1) / (x2 - x1);
                        double b2 = y2 - m2 * x2;
                        if (m == m2) {
                            boolean total = (lowx1 <= lowx2 && highx1 >= highx2) || (lowx2 <= lowx1 && highx2 >= highx1);
                            boolean partial = (lowx2 >= lowx1 && lowx2 <= highx1) || (lowx1 >= lowx2 && lowx1 <= highx2);
                            if (b == b2 && (total || partial)) {
                                ans++;
                                break;
                            }
                        }
                        else {
                            double xp = (b2 - b) / (m - m2);
                            double yp = m2 * xp + b2;
                            if (Obstruct(xp, yp)) {
                                ans++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static boolean Obstruct (double xp, double yp) {
        boolean condition1 = xp >= lowx1 && xp <= highx1 && yp >= lowy1 && yp <= highy1;
        boolean condition2 = xp >= lowx2 && xp <= highx2 && yp >= lowy2 && yp <= highy2;
        return condition1 && condition2;
    }
}
