import java.util.*;

public class Spreadsheet {
   // hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[90];
        ArrayList<Integer> adj[] = new ArrayList[90];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                int cell = i * 9 + j;
                adj[cell] = new ArrayList<>();
                String item = in.next();
                try {
                    values[cell] = Integer.parseInt(item);
                }
                catch (NumberFormatException e) {
                    values[cell] = -1;
                    String[] temp = item.split("\\+");
                    for (String pos : temp) {
                        adj[cell].add((pos.charAt(0) - 65) * 9 + Integer.parseInt(pos.substring(1)) - 1);
                    }
                }
            }
        }
        int[][] references = new int[90][2];
        for (int i = 0; i < 90; i++) {
            references[i][1] = i;
            if (values[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.add(i);
                boolean[] instack = new boolean[90];
                instack[i] = true;
                boolean[] visited = new boolean[90];
                visited[i] = true;
                boolean defined = true;
                while (!stack.isEmpty() && defined) {
                    int v = stack.lastElement();
                    for (int j : adj[v]) {
                        if (instack[j]) {
                            defined = false;
                            break;
                        }
                        if (!visited[j]) {
                            stack.add(j);
                            instack[j] = true;
                            visited[j] = true;
                            break;
                        }
                    }
                    if (v == stack.lastElement()) {
                        instack[v] = false;
                        stack.pop();
                    }
                }
                if (defined) {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    visited = new boolean[90];
                    visited[i] = true;
                    int cur = 0;
                    while (!queue.isEmpty()) {
                        int v = queue.remove();
                        int prev = cur;
                        for (int j : adj[v]) {
                            cur = prev + 1;
                            if (!visited[j]) {
                                queue.add(j);
                                visited[j] = true;
                            }
                        }
                    }
                    references[i][0] = cur;
                }
            }
        }
        for (int i = 1; i < 90; i++) {
            if (references[i-1][0] > references[i][0]) {
                int temp1 = references[i][0];
                references[i][0] = references[i-1][0];
                references[i-1][0] = temp1;
                int temp2 = references[i][1];
                references[i][1] = references[i-1][1];
                references[i-1][1] = temp2;
                i = 0;
            }
        }
        for (int[] i : references) {
            if (i[0] != 0) {
                values[i[1]] = 0;
                for (int j : adj[i[1]]) values[i[1]] += values[j];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                int cell = i * 9 + j;
                if (values[cell] != -1) System.out.print(values[cell] + " ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }
}
