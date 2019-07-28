import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Word_Wrap {
    // hello there
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 10; k++) {
            int c = Integer.parseInt(in.readLine());
            String[] words = in.readLine().split(" ");
            int i = 0;
            int j = 0;
            int l = 0;
            String prev = "";
            while (i < words.length) {
                if (l == 0) {
                    if (words[i].length() <= c) {
                        l += words[i].length();
                        System.out.print(words[i]);
                        prev = "\n";
                        i++;
                        j = 0;
                    }
                    else {
                        if (j+c >= words[i].length()) {
                            System.out.println(words[i].substring(j));
                            j = 0;
                            i++;
                        }
                        else {
                            System.out.println(words[i].substring(j, j + c));
                            j += c;
                        }
                        prev = "";
                    }
                }
                else if (1 + l + words[i].length() <= c) {
                    l += words[i].length() + 1;
                    System.out.print(" " + words[i]);
                    j = 0;
                    prev = "\n";
                    i++;
                }
                else {
                    l = 0;
                    j = 0;
                    System.out.println();
                    prev = "";
                }
            }
            System.out.println(prev + "=====");
        }
    }
}
