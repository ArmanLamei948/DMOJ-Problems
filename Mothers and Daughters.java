import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Mothers_and_Daughters {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        HashMap<String, ArrayList<String>> daughters = new HashMap<>();
        HashMap<String, String> mothers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            if (daughters.containsKey(line[0])) daughters.get(line[0]).add(line[1]);
            else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(line[1]);
                daughters.put(line[0], temp);
            }
            mothers.put(line[1], line[0]);
        }
        for (int i = 0; i < 10; i++) {
            String person = in.readLine();
            String forbidden = mothers.get(person);
            int cousins = 0;
            for (String j : daughters.get(mothers.get(forbidden))) {
                if (!j.equals(forbidden) && daughters.containsKey(j)) cousins += daughters.get(j).size();
            }
            System.out.println("Cousins: " + cousins + ", Sisters: " + (daughters.get(forbidden).size() - 1));
        }
    }
}
