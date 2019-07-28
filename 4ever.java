import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] length = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
        int[] place3 = {0, 8, 7, 7};
        int[] placeten = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6};
        int[] teens = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
        do {
            String str = n + "";
            int len = str.length();
            int m = (int) Math.ceil(len / 3.0);
            String[] split = new String[m];
            int first = (len - 1) % 3;
            split[0] = str.substring(0, first + 1);
            int index = 1;
            for (int i = first + 1; i < len; i += 3) {
                split[index] = str.substring(i, i + 3);
                index++;
            }
            n = 0;
            for (int i = 0; i < m; i++) {
                int c3 = Integer.parseInt(split[i].substring(0, 1));
                if (!split[i].equals("000")) n += place3[m - i - 1];
                len = split[i].length();
                int c = Integer.parseInt(split[i].substring(len - 1));
                if (len >= 2) {
                    int c2 = Integer.parseInt(split[i].substring(len - 2, len - 1));
                    n += placeten[c2];
                    if (c2 == 1) n += teens[c];
                    else n += length[c];
                    if (len == 3 && c3 != 0) n += 7 + length[c3];
                } else if (c3 != 0) n += length[c];
            }
            System.out.println(n);
        } while (n != 4);
    }
}
