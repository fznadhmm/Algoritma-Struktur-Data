package All_Sorting;

public class MyLinkedList {
    Node head;
    Node tail;

    void tambah(int data) {
        Node baru = new Node(data);
        if (head == null) {
            head = baru;
            tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
    }
}
