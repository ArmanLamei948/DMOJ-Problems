import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Countdown {
    // hello there
    static ArrayList<Integer> adj[];
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int k = 1; k <= t; k++) {
            String[] line = in.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
            HashMap<String, Integer> conv = new HashMap<>();
            int last = 0;
            adj = new ArrayList[1000];
            ArrayList<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                line = in.readLine().split(" ");
                if (!conv.containsKey(line[0])) {
                    conv.put(line[0], last);
                    adj[last] = new ArrayList<>();
                    names.add(line[0]);
                    last++;
                }
                for (int j = 0; j < Integer.parseInt(line[1]); j++) {
                    if (!conv.containsKey(line[j+2])) {
                        conv.put(line[j+2], last);
                        adj[last] = new ArrayList<>();
                        names.add(line[j+2]);
                        last++;
                    }
                    adj[conv.get(line[0])].add(conv.get(line[j+2]));
                }
            }
            int m = names.size();
            Queue<String> people[] = new Queue[m];
            for (int i = 0; i < m; i++) people[i] = new LinkedList<>();
            ArrayList<Integer> nums = new ArrayList<>();
            Collections.sort(names);
            for (String i : names) {
                depth = new int[m];
                dfs(conv.get(i));
                int ans = 0;
                for (int j = 0; j < m; j++) if (depth[j] == d) ans++;
                nums.add(ans);
                people[ans].add(i);
            }
            Collections.sort(nums);
            for (int i = 0; i < m; i++) {
                ArrayList<String> temp = new ArrayList<>(people[i]);
                Collections.sort(temp);
                people[i] = new LinkedList<>(temp);
            }
            System.out.println("Tree " + k + ":");
            for (int i = m-1; i >= m-3 && nums.get(i) != 0; i--) {
                System.out.println(people[nums.get(i)].remove() + " " + nums.get(i));
            }
            for (int i = m-4; i >= 0 && nums.get(i).equals(nums.get(m-3)) && nums.get(i) != 0; i--) {
                System.out.println(people[nums.get(i)].remove() + " " + nums.get(i));
            }
        }
    }
    static void dfs (int v) {
        for (int i : adj[v]) {
            depth[i] = depth[v] + 1;
            dfs(i);
        }
    }
}
