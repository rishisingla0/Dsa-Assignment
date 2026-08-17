import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        int min = 0;
        int max = n - 1;
        int position = -1;

        while (min <= max) {
            int mid = min + (max-min)/2;

            if (arr[mid] == target) {
                position = mid;
                break;
            } 
            else if (target < arr[mid]) {
                max = mid - 1;
            } 
            else {
                min = mid + 1;
            }
        }

        if (position != -1) {
            System.out.println("Element found at index: " + position);
        } else {
            System.out.println("Element not found.");
        }

        sc.close();
    }
}