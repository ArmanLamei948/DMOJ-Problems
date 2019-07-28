import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // hello there
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        ArrayList<ArrayList<Integer>> testCases = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < lines; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                temp.add(scanner.nextInt());
            }
            testCases.add(temp);
            scanner.nextLine();
        }


        ArrayList<ArrayList<Integer>> cells1 = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(0);
            cells1.add(temp);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(2);
        temp.add(1);
        cells1.add(temp);


        ArrayList<ArrayList<Integer>> cells2 = new ArrayList<>();
        for (int j = 0; j <= 4; j++) {
            for (int i = 5; i <= 19; i++) {
                temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                cells2.add(temp);
            }
        }

        for (int i = 6; i <= 8; i++) {
            temp = new ArrayList<>();
            temp.add(i);
            temp.add(5);
            cells2.add(temp);
        }

        temp = new ArrayList<>();
        temp.add(7);
        temp.add(6);
        cells2.add(temp);

        for (int i = 10; i <= 14; i++) {
            for (int j = 5; j <= 9; j++) {
                temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                cells2.add(temp);
            }
        }

        for (int i = 11; i <= 13; i++) {
            temp = new ArrayList<>();
            temp.add(i);
            temp.add(10);
            cells2.add(temp);
        }

        temp = new ArrayList<>();
        temp.add(12);
        temp.add(11);
        cells2.add(temp);

        for (int i = 16; i <= 18; i++) {
            temp = new ArrayList<>();
            temp.add(i);
            temp.add(5);
            cells2.add(temp);
        }

        temp = new ArrayList<>();
        temp.add(17);
        temp.add(6);
        cells2.add(temp);
        for (int i = 0; i < testCases.size(); i++) {
            int m = testCases.get(i).get(0);
            int x = testCases.get(i).get(1);
            int y = testCases.get(i).get(2);
            if (m == 1) {
                temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                if (cells1.contains(temp)) {
                    System.out.println("crystal");
                }
                else {
                    System.out.println("empty");
                }
            }
            else {
                int divisor = (int) Math.pow(5, m-2);
                x /= divisor;
                y /= divisor;
                temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                if (cells2.contains(temp)) {
                    System.out.println("crystal");
                }
                else {
                    System.out.println("empty");
                }
            }
        }
    }
}
