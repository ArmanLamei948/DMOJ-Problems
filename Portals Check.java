import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PortalsCheck {

    static int[] disj;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(in.readLine());
            HashMap<String, Integer> indexes = new HashMap<>();
            disj = new int[n];
            for (int j = 1; j < n; j++) disj[j] = j;
            int index = 0;
            for (int j = 0; j < n; j++) {
                String[] line = in.readLine().split(" ");
                if (line[0].equals("p")) {
                    for (int k = 1; k <= 2; k++) {
                        if (!indexes.containsKey(line[k])) {
                            indexes.put(line[k], index);
                            index++;
                        }
                    }
                    disj[find(indexes.get(line[1]))] = find(indexes.get(line[2]));
                } else {
                    boolean ans;
                    if (line[1].equals(line[2])) ans = true;
                    else if (!indexes.containsKey(line[1]) || !indexes.containsKey(line[2])) ans = false;
                    else if (find(indexes.get(line[1])) == find(indexes.get(line[2]))) ans = true;
                    else ans = false;
                    System.out.println(ans ? "connected" : "not connected");
                }
            }
        }
    }

    static int find (int n) {
        if (disj[n] == n) return n;
        return disj[n] = find(disj[n]);
    }
}
