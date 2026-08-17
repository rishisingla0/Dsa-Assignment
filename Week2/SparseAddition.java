package Week2;

import java.util.Scanner;

public class SparseAddition {

    static int[][] createTriplet(int[][] matrix, int rows, int cols) {
        int nonZero = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    nonZero++;
                }
            }
        }

        int[][] triplet = new int[nonZero + 1][3];

        triplet[0][0] = rows;
        triplet[0][1] = cols;
        triplet[0][2] = nonZero;

        int k = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    triplet[k][0] = i;
                    triplet[k][1] = j;
                    triplet[k][2] = matrix[i][j];
                    k++;
                }
            }
        }

        return triplet;
    }

    static int[][] add(int[][] a, int[][] b) {

        int i = 1;
        int j = 1;
        int k = 1;

        int maxSize = a.length + b.length;
        int[][] result = new int[maxSize][3];

        result[0][0] = a[0][0];
        result[0][1] = a[0][1];

        while (i < a.length && j < b.length) {

            if (a[i][0] == b[j][0] &&
                a[i][1] == b[j][1]) {

                int sum = a[i][2] + b[j][2];

                if (sum != 0) {
                    result[k][0] = a[i][0];
                    result[k][1] = a[i][1];
                    result[k][2] = sum;
                    k++;
                }

                i++;
                j++;
            }

            else if (a[i][0] < b[j][0] ||
                    (a[i][0] == b[j][0] &&
                     a[i][1] < b[j][1])) {

                result[k][0] = a[i][0];
                result[k][1] = a[i][1];
                result[k][2] = a[i][2];

                i++;
                k++;
            }

            else {
                result[k][0] = b[j][0];
                result[k][1] = b[j][1];
                result[k][2] = b[j][2];

                j++;
                k++;
            }
        }

        while (i < a.length) {
            result[k][0] = a[i][0];
            result[k][1] = a[i][1];
            result[k][2] = a[i][2];

            i++;
            k++;
        }

        while (j < b.length) {
            result[k][0] = b[j][0];
            result[k][1] = b[j][1];
            result[k][2] = b[j][2];

            j++;
            k++;
        }

        result[0][2] = k - 1;

        int[][] finalResult = new int[k][3];

        for (int x = 0; x < k; x++) {
            finalResult[x][0] = result[x][0];
            finalResult[x][1] = result[x][1];
            finalResult[x][2] = result[x][2];
        }

        return finalResult;
    }

    static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(
                matrix[i][0] + " " +
                matrix[i][1] + " " +
                matrix[i][2]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] a = new int[rows][cols];
        int[][] b = new int[rows][cols];

        System.out.println("Enter first matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter second matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int[][] tripletA = createTriplet(a, rows, cols);
        int[][] tripletB = createTriplet(b, rows, cols);

        int[][] sum = add(tripletA, tripletB);

        System.out.println("\nResult after addition:");

        display(sum);

        sc.close();
    }
}