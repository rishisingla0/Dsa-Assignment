import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingTwoQueues {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    // Push element into stack
    static void push(int value) {
        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println(value + " pushed into stack.");
    }

    // Pop element from stack
    static void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Popped: " + q1.remove());
    }

    // Peek top element
    static void peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top element: " + q1.peek());
    }

    // Check if stack is empty
    static void isEmpty() {
        System.out.println(q1.isEmpty() ? "Stack is empty." : "Stack is not empty.");
    }

    // Display stack
    static void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack: " + q1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Stack Using Two Queues ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Is Empty");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    isEmpty();
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}