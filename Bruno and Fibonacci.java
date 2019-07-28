import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bruno_and_Fibonacci {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String dna = in.readLine();
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        for (int i = 2; fib.get(i-1) <= n; i++) fib.add(fib.get(i-1) + fib.get(i-2));
        ArrayList<Integer> apos = new ArrayList<>();
        for (int i = 0; i < n; i++) if (dna.charAt(i) == 'A') apos.add(i+1);
        for (int i : fib) {
            if (i != 0 && i <= n) {
                if (dna.charAt(i-1) != 'A') {
                    System.out.println("Bruno, GO TO SLEEP");
                    System.exit(0);
                }
            }
        }
        for (int i : apos) {
            if (!fib.contains(i)) {
                System.out.println("Bruno, GO TO SLEEP");
                System.exit(0);
            }
        }
        System.out.println("That's quite the observation!");
    }
}
