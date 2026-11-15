package All_Sorting;

import java.util.Scanner;

public class BubbleSort {

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

    static Node bubbleSort(Node head) {
        boolean b = true;
        Node batas = null;
        int putaran = 0;
        while (b && head != batas) {
            b = false;
            putaran++;
            Node p = head;
            while (p.next != batas) {
                banding++;
                if (p.data > p.next.data) {
                    swap(p, p.next);
                    b = true;
                }
                p = p.next;
            }
            batas = p;
            System.out.println("Putaran " + putaran + " : " + teks(head));
            if (!b) {
                System.out.println("           (tidak ada swap, berhenti)");
            }
        }
        return head;
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
        System.out.println("=== BUBBLE SORT ===");
        System.out.println("Data awal : " + teks(list.head));
        System.out.println();

        list.head = bubbleSort(list.head);

        System.out.println();
        System.out.println("Hasil akhir          : " + teks(list.head));
        System.out.println("Jumlah perbandingan  : " + banding);
        System.out.println("Jumlah tukar/pindah  : " + tukar);
        in.close();
    }
}
