
import java.util.Scanner;

public class DeleteOccurrences {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head = null;

    static void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    static void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    static int deleteOccurrences(int key) {
        int count = 0;

        // Delete matching nodes from the beginning
        while (head != null && head.data == key) {
            head = head.next;
            count++;
        }

        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
                count++;
            } else {
                temp = temp.next;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter list elements:");

        for (int i = 0; i < n; i++) {
            insertEnd(sc.nextInt());
        }

        System.out.print("Enter key to delete: ");
        int key = sc.nextInt();

        int count = deleteOccurrences(key);

        System.out.println("Count: " + count);
        System.out.print("Updated Linked List: ");
        display();

        sc.close();
    }
}
