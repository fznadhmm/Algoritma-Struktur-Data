class Node {
    Entity data;
    Node next;

    public Node(Entity data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head = null;
    Node tail = null;

    public void insertLast(Entity data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertFirst(Entity data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void deleteFirst() {
        if (head == null) return;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (head == null) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public boolean search(Entity target) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(target)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}