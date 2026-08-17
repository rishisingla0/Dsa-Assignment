package Week2;

import java.util.Scanner;

public class SparseTranspose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int nonZero = 0;

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();

                if (matrix[i][j] != 0) {
                    nonZero++;
                }
            }
        }

        int[][] triplet = new int[nonZero + 1][3];

        triplet[0][0] = rows;
        triplet[0][1] = cols;
        triplet[0][2] = nonZero;

        int index = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    triplet[index][0] = i;
                    triplet[index][1] = j;
                    triplet[index][2] = matrix[i][j];
                    index++;
                }
            }
        }

        int[][] transpose = new int[nonZero + 1][3];

        transpose[0][0] = cols;
        transpose[0][1] = rows;
        transpose[0][2] = nonZero;

        for (int i = 1; i <= nonZero; i++) {
            transpose[i][0] = triplet[i][1];
            transpose[i][1] = triplet[i][0];
            transpose[i][2] = triplet[i][2];
        }

        System.out.println("\nTriplet Representation:");

        for (int i = 0; i <= nonZero; i++) {
            System.out.println(
                triplet[i][0] + " " +
                triplet[i][1] + " " +
                triplet[i][2]
            );
        }

        System.out.println("\nTranspose:");

        for (int i = 0; i <= nonZero; i++) {
            System.out.println(
                transpose[i][0] + " " +
                transpose[i][1] + " " +
                transpose[i][2]
            );
        }

        sc.close();
    }
}
