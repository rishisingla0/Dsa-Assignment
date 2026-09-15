import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingOneQueue {

    static Queue<Integer> queue = new LinkedList<>();

    // Push element into stack
    static void push(int value) {
        int size = queue.size();

        queue.add(value);

        // Move previous elements behind the new element
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }

        System.out.println(value + " pushed into stack.");
    }

    // Pop element from stack
    static void pop() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Popped: " + queue.remove());
    }

    // Peek top element
    static void peek() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top element: " + queue.peek());
    }

    // Check if stack is empty
    static void isEmpty() {
        System.out.println(queue.isEmpty()
                ? "Stack is empty."
                : "Stack is not empty.");
    }

    // Display stack
    static void display() {
        if (queue.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack: " + queue);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Stack Using One Queue ---");
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