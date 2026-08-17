package Week2;

import java.util.Scanner;

public class LowerTriangularMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int n = sc.nextInt();

        int[] lower = new int[n * (n + 1) / 2];

        System.out.println("Enter matrix elements:");

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int value = sc.nextInt();

                if (i >= j) {
                    lower[index] = value;
                    index++;
                }
            }
        }

        System.out.println("Stored elements:");

        for (int i = 0; i < lower.length; i++) {
            System.out.print(lower[i] + " ");
        }

        sc.close();
    }
}