import java.util.ArrayList;
import java.util.Scanner;

public class Its_Tough_Being_a_Teen {

    static ArrayList<int[]> perms = new ArrayList<>();

    public static void main(String[] args) {
        boolean[][] before = new boolean[8][8];
        before[1][7] = true;
        before[1][4] = true;
        before[2][1] = true;
        before[3][4] = true;
        before[3][5] = true;
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        while (a != 0) {
            before[a][b] = true;
            a = in.nextInt();
            b = in.nextInt();
        }
        permGen("");
        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] perm : perms) {
            boolean valid = true;
            for (int i = 0; i < 7 && valid; i++) {
                for (int j = i + 1; j < 7 && valid; j++) valid = !before[perm[j]][perm[i]];
            }
            if (valid) ans.add(perm);
        }
        if (!ans.isEmpty()) {
            for (int i = 0; i < 7 && ans.size() >= 2; i++) {
                int min = 7;
                for (int[] arr : ans) min = Math.min(min, arr[i]);
                for (int j = 0; j < ans.size(); j++) {
                    if (ans.get(j)[i] != min) {
                        ans.remove(j);
                        j--;
                    }
                }
            }
            for (int[] arr : ans) for (int i : arr) System.out.print(i + " ");
        } else System.out.println("Cannot complete these tasks. Going to bed.");
    }
    static void permGen (String perm) {
        if (perm.length() == 7) {
            int[] arr = new int[7];
            for (int i = 0; i < 7; i++) arr[i] = Integer.parseInt(perm.substring(i, i+1));
            perms.add(arr);
        }
        else for (int i = 1; i <= 7; i++) if (!perm.contains(i + "")) permGen(perm + i);
    }
}
