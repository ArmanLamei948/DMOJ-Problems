import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Air_Travel_Planning {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 5; k++) {
            HashMap<String, ArrayList<String>> adj = new HashMap<>();
            HashMap<String, ArrayList<Integer>> cost = new HashMap<>();
            HashMap<String, Integer> shortest = new HashMap<>();
            int n = Integer.parseInt(in.readLine());
            ArrayList<String> unVisited = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] line = in.readLine().split(" ");
                if (!adj.containsKey(line[0])) {
                    unVisited.add(line[0]);
                    shortest.put(line[0], Integer.MAX_VALUE/2);
                    adj.put(line[0], new ArrayList<>());
                    cost.put(line[0], new ArrayList<>());
                }
                if (!adj.containsKey(line[1])) {
                    unVisited.add(line[1]);
                    shortest.put(line[1], Integer.MAX_VALUE/2);
                    adj.put(line[1], new ArrayList<>());
                    cost.put(line[1], new ArrayList<>());
                }
                adj.get(line[0]).add(line[1]);
                cost.get(line[0]).add(Integer.parseInt(line[2]));
            }
            shortest.put("YYZ", 0);
            while (!unVisited.isEmpty()) {
                String min = unVisited.get(0);
                int index = 0;
                for (int i = 1; i < unVisited.size(); i++) {
                    String node = unVisited.get(i);
                    if (shortest.get(node) < shortest.get(min)) {
                        min = node;
                        index = i;
                    }
                }
                unVisited.remove(index);
                for (int i = 0; i < adj.get(min).size(); i++) {
                    String node = adj.get(min).get(i);
                    shortest.put(node, Math.min(shortest.get(node), shortest.get(min) + cost.get(min).get(i)));
                }
            }
            System.out.println(shortest.get("SEA"));
        }
    }
}
