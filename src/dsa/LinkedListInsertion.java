package dsa;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListInsertion {

    // Insert at beginning
    public static Node insertAtBeginning(Node head, int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    // Insert at end
    public static Node insertAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // Insert at specific position (1-based index)
    public static Node insertAtPosition(Node head, int value, int pos) {
        Node newNode = new Node(value);

        if (pos == 1) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // Print list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = null;

        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 20);
        System.out.print("After inserting at beginning: ");
        printList(head);

        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 40);
        System.out.print("After inserting at end: ");
        printList(head);

        head = insertAtPosition(head, 25, 3);
        System.out.print("After inserting 25 at position 3: ");
        printList(head);
    }
}