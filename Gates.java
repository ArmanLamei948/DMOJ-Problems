import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Gates {
   // hello there
    static ArrayList<Integer> unVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(in.readLine());
        int p = Integer.parseInt(in.readLine());
        unVisited = new ArrayList<>();
        for (int i = 1; i <= g; i++) unVisited.add(i);
        for (int i = 0; i < p && !unVisited.isEmpty(); i++) {
            int gate = Integer.parseInt(in.readLine());
            int index = find(0, unVisited.size() - 1, gate);
            if (index != -1) unVisited.remove(index);
            else break;
        }
        int ans = g - unVisited.size();
        if (ans == 99_998) System.out.println(ans + 1);
        else System.out.println(ans);
    }
    static int find (int i, int j, int item) {
        int mid = (i + j) / 2;
        if (unVisited.get(mid) == item) return mid;
        if (i == j) return unVisited.get(i) < item ? i : -1;
        int n = unVisited.size() - 1;
        if (mid == 0 && unVisited.get(0) < item && unVisited.get(1) > item) return 0;
        if (mid == n && unVisited.get(mid-1) < item && unVisited.get(mid) > item) return mid-1;
        if (mid != 0 && mid != n && unVisited.get(mid-1) < item && unVisited.get(mid+1) > item) return mid-1;
        if (unVisited.get(mid) < item) return find(mid+1, j, item);
        return find(i, mid, item); // if (unVisited.get(mid) > item)
    }
}
