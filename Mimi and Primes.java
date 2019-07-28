import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Mimi_and_Primes {
    // hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] line = in.readLine().split(" ");
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) nums[i] = Long.parseLong(line[i]);
        if (n >= 2) {
            Arrays.sort(nums);
            ArrayList<Long> factors = Factors(nums[0]);
            ArrayList<Long> common = new ArrayList<>();
            for (long i : factors) if (nums[1] % i == 0) common.add(i);
            for (int i = 2; i < n; i++) {
                ArrayList<Integer> indexes = new ArrayList<>();
                int len = common.size();
                for (int j = 0; j < len; j++) if (nums[i] % common.get(j) != 0) indexes.add(j);
                Collections.sort(indexes);
                int s = indexes.size() - 1;
                for (int j = s; j >= 0; j--) {
                    int index = indexes.get(j);
                    common.remove(index);
                }
            }
            long gcf = common.get(common.size() - 1);
            long prime = -1;
            factors = Factors(gcf);
            for (long i : factors) if (Factors(i).size() == 2) prime = Math.max(i, prime);
            if (prime == -1) System.out.println("DNE");
            else System.out.println(prime);
        }
        else System.out.println(nums[0]);
    }
    static ArrayList<Long> Factors (long num) {
        double sqrt = Math.sqrt(num);
        int len = (int) sqrt;
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 1; i <= len; i++) if (num % i == 0) factors.add(i);
        int s = factors.size() - 1;
        for (int i = s; i >= 0; i--) if (factors.get(i) != sqrt) factors.add(num / factors.get(i));
        return factors;
    }
}
