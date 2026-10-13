
import java.util.Scanner;

public class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head = null;

    static void insertBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

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

    static void insertBefore(int key, int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == key) {
            insertBeginning(value);
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Node not found.");
        } else {
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    static void insertAfter(int key, int value) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    static void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
    }

    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    static void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Node not found.");
        } else {
            temp.next = temp.next.next;
        }
    }

    static void search(int key) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Found at position: " + position);
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println("Node not found.");
    }

    static void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Singly Linked List ---");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert before a value");
            System.out.println("4. Insert after a value");
            System.out.println("5. Delete from beginning");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete a specific value");
            System.out.println("8. Search");
            System.out.println("9. Display");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    insertBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    insertEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter existing value: ");
                    int beforeKey = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int beforeValue = sc.nextInt();
                    insertBefore(beforeKey, beforeValue);
                    break;

                case 4:
                    System.out.print("Enter existing value: ");
                    int afterKey = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int afterValue = sc.nextInt();
                    insertAfter(afterKey, afterValue);
                    break;

                case 5:
                    deleteBeginning();
                    break;

                case 6:
                    deleteEnd();
                    break;

                case 7:
                    System.out.print("Enter value to delete: ");
                    deleteNode(sc.nextInt());
                    break;

                case 8:
                    System.out.print("Enter value to search: ");
                    search(sc.nextInt());
                    break;

                case 9:
                    display();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}
