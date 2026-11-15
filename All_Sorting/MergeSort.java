package All_Sorting;

import java.util.Scanner;

public class MergeSort {

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

    static Node cariTengah(Node head) {
        Node p = head;
        Node q = head.next;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

    static Node merge(Node a, Node b) {
        Node awal = new Node(0);
        Node ekor = awal;
        while (a != null && b != null) {
            banding++;
            if (a.data <= b.data) {
                ekor.next = a;
                a = a.next;
            } else {
                ekor.next = b;
                b = b.next;
            }
            ekor = ekor.next;
            tukar++;
        }
        while (a != null) {
            ekor.next = a;
            a = a.next;
            ekor = ekor.next;
            tukar++;
        }
        while (b != null) {
            ekor.next = b;
            b = b.next;
            ekor = ekor.next;
            tukar++;
        }
        return awal.next;
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tengah = cariTengah(head);
        Node kanan = tengah.next;
        tengah.next = null;

        System.out.println(spasi() + "Bagi   : [" + teks(head) + "] | [" + teks(kanan) + "]");

        kedalaman++;
        Node a = mergeSort(head);
        Node b = mergeSort(kanan);
        kedalaman--;

        String kiriTeks = teks(a);
        String kananTeks = teks(b);
        Node hasil = merge(a, b);
        System.out.println(spasi() + "Gabung : [" + kiriTeks + "] + [" + kananTeks + "] = [" + teks(hasil) + "]");
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
        System.out.println("=== MERGE SORT ===");
        System.out.println("Data awal : " + teks(list.head));
        System.out.println();

        list.head = mergeSort(list.head);

        System.out.println();
        System.out.println("Hasil akhir          : " + teks(list.head));
        System.out.println("Jumlah perbandingan  : " + banding);
        System.out.println("Jumlah tukar/pindah  : " + tukar);
        in.close();
    }
}
