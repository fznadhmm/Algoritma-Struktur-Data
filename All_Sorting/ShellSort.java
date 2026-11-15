package All_Sorting;

import java.util.Scanner;

public class ShellSort {

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

    static int hitungPanjang(Node head) {
        int n = 0;
        Node p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }

    static Node shellSort(Node head) {
        int n = hitungPanjang(head);
        for (int gap = n / 2; gap >= 1; gap = gap / 2) {
            System.out.println("Gap = " + gap);
            boolean ada = true;
            int putaran = 0;
            while (ada) {
                ada = false;
                Node p = head;
                Node q = head;
                for (int k = 0; k < gap; k++) {
                    q = q.next;
                }
                while (q != null) {
                    banding++;
                    if (p.data > q.data) {
                        swap(p, q);
                        ada = true;
                    }
                    p = p.next;
                    q = q.next;
                }
                if (ada) {
                    putaran++;
                    System.out.println("   putaran " + putaran + " : " + teks(head));
                }
            }
            if (putaran == 0) {
                System.out.println("   tidak ada pertukaran");
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
        System.out.println("=== SHELL SORT ===");
        System.out.println("Data awal : " + teks(list.head));
        System.out.println();

        list.head = shellSort(list.head);

        System.out.println();
        System.out.println("Hasil akhir          : " + teks(list.head));
        System.out.println("Jumlah perbandingan  : " + banding);
        System.out.println("Jumlah tukar/pindah  : " + tukar);
        in.close();
    }
}
