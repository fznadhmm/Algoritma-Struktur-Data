package All_Sorting;

import java.util.Scanner;

public class InsertionSort {

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

    static Node insertionSort(Node head) {
        Node urut = null;
        Node cur = head;
        int langkah = 0;
        while (cur != null) {
            langkah++;
            Node berikutnya = cur.next;
            int nilai = cur.data;
            boolean depan = false;
            if (urut == null) {
                depan = true;
            } else {
                banding++;
                if (cur.data < urut.data) {
                    depan = true;
                }
            }
            if (depan) {
                cur.next = urut;
                urut = cur;
            } else {
                Node p = urut;
                while (p.next != null) {
                    banding++;
                    if (p.next.data <= cur.data) {
                        p = p.next;
                    } else {
                        break;
                    }
                }
                cur.next = p.next;
                p.next = cur;
            }
            tukar++;
            System.out.println("Langkah " + langkah + " : sisip " + nilai);
            System.out.println("           sudah urut : " + teks(urut));
            System.out.println("           belum urut : " + teks(berikutnya));
            cur = berikutnya;
        }
        return urut;
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
        System.out.println("=== INSERTION SORT ===");
        System.out.println("Data awal : " + teks(list.head));
        System.out.println();

        list.head = insertionSort(list.head);

        System.out.println();
        System.out.println("Hasil akhir          : " + teks(list.head));
        System.out.println("Jumlah perbandingan  : " + banding);
        System.out.println("Jumlah tukar/pindah  : " + tukar);
        in.close();
    }
}
