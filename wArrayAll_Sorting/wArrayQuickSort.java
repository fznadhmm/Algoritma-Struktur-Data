package wArrayAll_Sorting;
import java.util.Scanner;

public class wArrayQuickSort {

    static int partition(int[] l, int lb, int ub) {
        int p = l[lb];
        int cariBesar = lb + 1;
        int cariKecil = ub;

        while (cariBesar <= cariKecil) {
            while (cariBesar <= ub && l[cariBesar] <= p) {
                cariBesar++;
            }
            while (l[cariKecil] > p) {
                cariKecil--;
            }
            if (cariBesar < cariKecil) {
                int t = l[cariBesar];
                l[cariBesar] = l[cariKecil];
                l[cariKecil] = t;
            }
        }
        // taruh pivot di posisi akhirnya
        l[lb] = l[cariKecil];
        l[cariKecil] = p;
        return cariKecil;
    }

    // Quick Sort: bagi dua sub-list berdasarkan pivot, lalu rekursif
    static void quickSort(int[] l, int low, int high) {
        if (low < high) {
            int pi = partition(l, low, high);
            quickSort(l, low, pi - 1);
            quickSort(l, pi + 1, high);
        }
    }

    static void cetak(int[] l) {
        for (int i = 0; i < l.length; i++) {
            System.out.print(l[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan jumlah data: ");
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Data ke-" + (i + 1) + ": ");
            data[i] = in.nextInt();
        }
        System.out.print("Sebelum diurutkan: ");
        cetak(data);
        quickSort(data, 0, data.length - 1);
        System.out.print("Setelah diurutkan (Quick Sort): ");
        cetak(data);
        in.close();
    }
}
