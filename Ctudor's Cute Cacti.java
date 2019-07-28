import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Ctudors_Cute_Cacti {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        int[] yswitch = new int[n];
        int[] xswitch = new int[n];
        ArrayList<String> switches = new ArrayList<>();
        HashSet<String> elements = new HashSet<>();
        HashMap<String, Integer> content = new HashMap<>();
        for (int i = 0; i < q; i++) {
            line = in.readLine().split(" ");
            int y = Integer.parseInt(line[1]) - 1;
            int x = Integer.parseInt(line[2]) - 1;
            String str = y + " " + x;
            if (line[0].equals("1")) {
                yswitch[y]++;
                xswitch[x]++;
                switches.add(str);
                if (elements.contains(str)) content.put(str, content.get(str) + 1);
                else content.put(str, 1);
                elements.add(str);
            } else {
                int val = yswitch[y] + xswitch[x];
                if (elements.contains(str)) val -= content.get(str);
                System.out.println(val % 2 == 0 ? 0 : 1);
            }
        }
    }
}
