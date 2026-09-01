import java.util.*;

public class InterLeaveQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        if (n % 2 != 0) {
            System.out.println("Enter an even number of elements.");
            sc.close();
            return;
        }

        System.out.println("Enter queue elements:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            if (i < n / 2) {
                first.add(value);
            } else {
                second.add(value);
            }
        }

        Queue<Integer> result = new LinkedList<>();

        while (!first.isEmpty()) {
            result.add(first.remove());
            result.add(second.remove());
        }

        System.out.println("Interleaved queue:");

        while (!result.isEmpty()) {
            System.out.print(result.remove() + " ");
        }

        sc.close();
    }
}