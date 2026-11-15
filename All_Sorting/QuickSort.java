package All_Sorting;

import java.util.Scanner;

public class QuickSort {

    static int banding = 0;
    static int tukar = 0;
    static int kedalaman = 0;

    static String teks(Node h) {
        if (h == null) {
            return "-";
        }
        String s = "";
        Node p = h;
        while (p != null) {
            s = s + p.data;
            if (p.next != null) {
                s = s + " ";
            }
            p = p.next;
        }
        return s;
    }

    static String spasi() {
        String s = "";
        for (int i = 0; i < kedalaman; i++) {
            s = s + "    ";
        }
        return s;
    }

    static void swap(Node a, Node b) {
        int t = a.data;
        a.data = b.data;
        b.data = t;
        tukar++;
    }

    static Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pivot = head;
        Node p = head.next;
        pivot.next = null;

        Node kiriHead = null, kiriTail = null;
        Node kananHead = null, kananTail = null;

        while (p != null) {
            Node berikutnya = p.next;
            p.next = null;
            banding++;
            if (p.data <= pivot.data) {
                if (kiriHead == null) {
                    kiriHead = p;
                } else {
                    kiriTail.next = p;
                }
                kiriTail = p;
            } else {
                if (kananHead == null) {
                    kananHead = p;
                } else {
                    kananTail.next = p;
                }
                kananTail = p;
            }
            tukar++;
            p = berikutnya;
        }

        System.out.println(spasi() + "Pivot = " + pivot.data + " | kiri: [" + teks(kiriHead) + "] | kanan: [" + teks(kananHead) + "]");

        kedalaman++;
        kiriHead = quickSort(kiriHead);
        kananHead = quickSort(kananHead);
        kedalaman--;

        pivot.next = kananHead;
        Node hasil = pivot;
        if (kiriHead != null) {
            Node t = kiriHead;
            while (t.next != null) {
                t = t.next;
            }
            t.next = pivot;
            hasil = kiriHead;
        }
        System.out.println(spasi() + "Gabung : " + teks(hasil));
        return hasil;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        System.out.print("Masukkan jumlah data: ");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Data ke-" + (i + 1) + ": ");
            list.tambah(in.nextInt());
        }

        System.out.println();
        System.out.println("=== QUICK SORT ===");
        System.out.println("Data awal : " + teks(list.head));
        System.out.println();

        list.head = quickSort(list.head);

        System.out.println();
        System.out.println("Hasil akhir          : " + teks(list.head));
        System.out.println("Jumlah perbandingan  : " + banding);
        System.out.println("Jumlah tukar/pindah  : " + tukar);
        in.close();
    }
}
