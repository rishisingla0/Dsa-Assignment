package Week2;

import java.util.Scanner;

public class DiagonalMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int n = sc.nextInt();

        int[] diagonal = new int[n];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();

                if (i == j) {
                    diagonal[i] = value;
                }
            }
        }

        System.out.println("Stored diagonal elements:");

        for (int i = 0; i < n; i++) {
            System.out.print(diagonal[i] + " ");
        }

        sc.close();
    }
} 
