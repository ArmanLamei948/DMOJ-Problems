import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lottery {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int k = 0; k < t; k++) {
            String expr = in.readLine();
            ArrayList<Integer> aslocs = new ArrayList<>();
            ArrayList<Integer> mlocs = new ArrayList<>();
            int n = expr.length();
            for (int i = 0; i < n; i++) {
                char temp = expr.charAt(i);
                if ((temp < '0' || temp > '9') && temp != ' ') {
                    if (temp == 'X') mlocs.add(i);
                    else aslocs.add(i);
                }
            }
            ArrayList<Integer> oins = new ArrayList<>();
            ArrayList<Integer> cins = new ArrayList<>();
            int e = aslocs.isEmpty() ? n : aslocs.get(0);
            for (int i = 0; i < mlocs.size()-1 && mlocs.get(i) < e; i++) {
                oins.add(0);
                cins.add(Math.min(mlocs.get(i+1), e)-1);
            }
            int m = aslocs.size();
            for (int i = 0; i < m; i++) {
                if (i != 0) {
                    oins.add(0);
                    cins.add(aslocs.get(i) - 1);
                }
                int fin = i == m-1 ? n+1 : aslocs.get(i+1);
                for (int j = aslocs.get(i)+1; j < fin-1; j++) {
                    if (expr.charAt(j) == 'X') {
                        int index = mlocs.indexOf(j);
                        oins.add(aslocs.get(i)+2);
                        cins.add(index != mlocs.size() - 1 && mlocs.get(index+1) < fin ? mlocs.get(index+1)-1 : fin-1);
                    }
                }
            }
            ArrayList<Character> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) ans.add(expr.charAt(i));
            int[] displacement = new int[1000];
            for (int i = 0; i < oins.size(); i++) {
                ans.add(oins.get(i) + displacement[oins.get(i)], '(');
                for (int j = oins.get(i); j < ans.size(); j++) displacement[j]++;
                ans.add(cins.get(i) + displacement[cins.get(i)], ')');
                for (int j = cins.get(i); j < ans.size(); j++) displacement[j]++;
            }
            for (char i : ans ) System.out.print(i);
            System.out.println();
        }
    }
}
