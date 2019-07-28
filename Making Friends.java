import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Making_Friends {
// hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Arman arman = new Arman();
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        line = in.readLine().split(" ");
        for (int i = 0; i < n; i++) arman.add(Integer.parseInt(line[i]));
        arman.fix();
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arman.get(n-1);
            arman.replace(n-1, Math.max(arman.get(n-1) - 1, 0));
        }
        System.out.println(sum);
    }
}
class Arman {
    ArrayList<Integer> temp = new ArrayList<>();
    void add (int item) {
        if (!temp.isEmpty()) temp.add(index(item, 0, temp.size() - 1), item);
        else temp.add(item);
    }
    int index (int item, int i, int j) {
        if (i == j) return i;
        int mid = (i + j) / 2;
        if (item == temp.get(mid)) return mid;
        if (item > temp.get(mid)) return index(item, mid + 1, j);
        return index(item, i, mid); // if (item < temp.get(mid))
    }
    int size () {
        return temp.size();
    }
    int get (int index) {
        return temp.get(index);
    }
    void fix () {
        int item = temp.get(temp.size() - 1);
        temp.add(index(item, 0, temp.size() - 1), item);
        temp.remove(temp.size() - 1);
    }
    void replace (int index, int replacer) {
        int location = index(replacer, 0, temp.size() - 1);
        temp.add(location, replacer);
        if (location <= index) temp.remove(index + 1);
        else temp.remove(index);
    }
}
