import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeating {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] count = new int[256];
        Queue<Character> queue = new LinkedList<>();

        System.out.println("First non-repeating character after each character:");

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            count[ch]++;
            queue.add(ch);

            while (!queue.isEmpty() && count[queue.peek()] > 1) {
                queue.remove();
            }

            if (queue.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }

        sc.close();
    }
}