import java.util.Scanner;

public class Simple_Queue {

    static int[] queue = new int[5];
    static int front = -1;
    static int rear = -1;

    static boolean isEmpty() {
        return front == -1 || front > rear;
    }

    static boolean isFull() {
        return rear == queue.length - 1;
    }

    static void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = value;

        System.out.println("Element inserted.");
    }

    static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Deleted element: " + queue[front]);
        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n----- SIMPLE QUEUE -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. isEmpty");
            System.out.println("4. isFull");
            System.out.println("5. Display");
            System.out.println("6. Peek");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    int value = sc.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    System.out.println("Queue empty: " + isEmpty());
                    break;

                case 4:
                    System.out.println("Queue full: " + isFull());
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    peek();
                    break;

                case 7:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}