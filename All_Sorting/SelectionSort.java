package All_Sorting;

import java.util.Scanner;

public class SelectionSort {

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

    static Node selectionSort(Node head) {
        int langkah = 0;
        for (Node i = head; i != null && i.next != null; i = i.next) {
            langkah++;
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                banding++;
                if (j.data < min.data) {
                    min = j;
                }
            }
            System.out.print("Langkah " + langkah + " : terkecil = " + min.data);
            if (min != i) {
                swap(i, min);
                System.out.print(", ditukar ke posisi " + langkah);
            } else {
                System.out.print(", sudah di posisi " + langkah);
            }
            System.out.println();
            System.out.println("           " + teks(head));
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
        System.out.println("=== SELECTION SORT ===");
        System.out.println("Data awal : " + teks(list.head));
        System.out.println();

        list.head = selectionSort(list.head);

        System.out.println();
        System.out.println("Hasil akhir          : " + teks(list.head));
        System.out.println("Jumlah perbandingan  : " + banding);
        System.out.println("Jumlah tukar/pindah  : " + tukar);
        in.close();
    }
}
