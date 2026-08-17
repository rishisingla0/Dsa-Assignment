package Week2;

import java.util.Scanner;

public class UpperTriangularMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int n = sc.nextInt();

        int[] upper = new int[n * (n + 1) / 2];

        System.out.println("Enter matrix elements:");

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = sc.nextInt();

                if (i <= j) {
                    upper[index] = value;
                    index++;
                }
            }
        }

        System.out.println("Stored elements:");

        for (int value : upper) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}
