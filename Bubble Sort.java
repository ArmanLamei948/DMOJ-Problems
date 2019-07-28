import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bubble_Sort {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        String[] line = in.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(line[i]);
        print(arr);
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    changed = true;
                    print(arr);
                }
            }
        }
    }
    static void print (int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
