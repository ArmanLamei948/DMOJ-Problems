import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bananas {
   // hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String word = in.readLine();
        while (!word.equals("X")) {
            System.out.println(Monkey(word) ? "YES" : "NO");
            word = in.readLine();
        }
    }
    static boolean Monkey (String s) {
        if (A_Word(s)) return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'N' && A_Word(s.substring(0, i)) && Monkey(s.substring(i+1))) return true;
        }
        return false;
    }
    static boolean A_Word (String s) {
        int n = s.length();
        return s.equals("A") || (n >= 3 && s.charAt(0) == 'B' && Monkey(s.substring(1, n-1)) && s.charAt(n-1) == 'S');
    }
}
