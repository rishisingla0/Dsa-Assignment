package Week2;

import java.util.HashSet;
import java.util.Scanner;

public class DistinctElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> distinct = new HashSet<>();

        for (int i = 0; i < n; i++) {
            distinct.add(arr[i]);
        }

        System.out.println("Number of distinct elements = " + distinct.size());

        sc.close();
    }
}