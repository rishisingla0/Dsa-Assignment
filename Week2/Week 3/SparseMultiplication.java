import java.util.Scanner;

public class SparseMultiplication {

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

    static int[][] multiply(int[][] a, int[][] b) {

        int rowsA = a[0][0];
        int colsA = a[0][1];

        int rowsB = b[0][0];
        int colsB = b[0][1];

        if (colsA != rowsB) {
            return null;
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 1; i < a.length; i++) {

            int row = a[i][0];
            int col = a[i][1];
            int valueA = a[i][2];

            for (int j = 1; j < b.length; j++) {

                if (b[j][0] == col) {

                    int column = b[j][1];
                    int valueB = b[j][2];

                    result[row][column] += valueA * valueB;
                }
            }
        }

        return createTriplet(result, rowsA, colsB);
    }

    static void display(int[][] triplet) {
        for (int i = 0; i < triplet.length; i++) {
            System.out.println(
                triplet[i][0] + " " +
                triplet[i][1] + " " +
                triplet[i][2]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows of first matrix: ");
        int rowsA = sc.nextInt();

        System.out.print("Enter columns of first matrix: ");
        int colsA = sc.nextInt();

        System.out.print("Enter rows of second matrix: ");
        int rowsB = sc.nextInt();

        System.out.print("Enter columns of second matrix: ");
        int colsB = sc.nextInt();

        int[][] matrixA = new int[rowsA][colsA];
        int[][] matrixB = new int[rowsB][colsB];

        System.out.println("Enter first matrix:");

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter second matrix:");

        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }

        int[][] tripletA = createTriplet(matrixA, rowsA, colsA);
        int[][] tripletB = createTriplet(matrixB, rowsB, colsB);

        int[][] result = multiply(tripletA, tripletB);

        if (result == null) {
            System.out.println("Matrix multiplication is not possible.");
        } else {
            System.out.println("\nResult in triplet form:");
            display(result);
        }

        sc.close();
    }
}
