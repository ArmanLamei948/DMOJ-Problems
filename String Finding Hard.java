import java.util.Scanner;

public class StringFindingHard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        char[] t = in.next().toCharArray();
        int n = s.length;
        int m = t.length;
        int[] start = new int[m];
        int i = 1;
        int j = 0;
        while (i < m) {
            if (t[i] == t[j]) {
                start[i] = j + 1; // start after that character
                i++;
                j++;
            } else {
                if (j == 0) i++;
                else j = start[j - 1];
            }
        }
        i = 0;
        j = 0;
        int len = 0;
        while (i < n && len < m) {
            if (s[i] == t[j]) {
                len++;
                i++;
                j++;
            } else {
                if (j == 0) i++;
                else j = start[j - 1];
                len = j;
            }
        }
        System.out.println(len == m ? i - len : -1);
    }
}
