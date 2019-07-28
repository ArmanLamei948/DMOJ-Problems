import java.util.*;

public class Subsets {
   // Hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> adj[] = new ArrayList[256];
        for (int i = 0; i < 256; i++) adj[i] = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        boolean[] contained = new boolean[256];
        for (int i = 0; i < n; i++) {
            int a = in.next().charAt(0);
            in.next();
            int b = in.next().charAt(0);
            adj[a].add(b);
            if (!contained[a]) {
                characters.add((char) a);
                contained[a] = true;
            }
            if (!contained[b]) {
                if (Character.toString((char) b).toUpperCase().equals(Character.toString((char) b))) {
                    characters.add((char) b);
                    contained[b] = true;
                }
            }
        }
        Collections.sort(characters);
        for (char i : characters) {
            ArrayList<String> ans = new ArrayList<>();
            int root = i;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(root);
            boolean[] visited = new boolean[256];
            visited[root] = true;
            while (!queue.isEmpty()) {
                int v = queue.remove();
                for (int j : adj[v]) {
                    if (!visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                        if (adj[j].isEmpty()) {
                            String temp = Character.toString((char) j);
                            if (temp.toLowerCase().equals(temp)) ans.add(temp);
                        }
                    }
                }
            }
            Collections.sort(ans);
            System.out.print(i + " = {");
            if (!ans.isEmpty()) System.out.print(ans.get(0));
            for (int j = 1; j < ans.size(); j++) System.out.print("," + ans.get(j));
            System.out.println("}");
        }
    }
}
