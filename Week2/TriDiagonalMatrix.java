package Week2;

import java.util.Scanner;

public class TriDiagonalMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int n = sc.nextInt();

        int[] lower = new int[n - 1];
        int[] main = new int[n];
        int[] upper = new int[n - 1];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = sc.nextInt();

                if (i == j) {
                    main[i] = value;
                } 
                else if (i == j + 1) {
                    lower[j] = value;
                } 
                else if (j == i + 1) {
                    upper[i] = value;
                }
            }
        }

        System.out.println("\nMain diagonal:");
        for (int value : main) {
            System.out.print(value + " ");
        }

        System.out.println("\nLower diagonal:");
        for (int value : lower) {
            System.out.print(value + " ");
        }

        System.out.println("\nUpper diagonal:");
        for (int value : upper) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}
