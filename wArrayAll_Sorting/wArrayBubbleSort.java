package wArrayAll_Sorting;
import java.util.Scanner;

public class wArrayBubbleSort {

    static void swap(int[] l, int a, int b) {
        int t = l[a];
        l[a] = l[b];
        l[b] = t;
    }

    static void bubbleSort(int[] l) {
        int n = l.length;
        boolean b = true;             
        while (n >= 1 && b) {
            b = false;
            for (int i = 0; i < n - 1; i++) {
                if (l[i] > l[i + 1]) {
                    swap(l, i, i + 1);
                    b = true;
                }
            }
            n--;                   
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
        bubbleSort(data);
        System.out.print("Setelah diurutkan (Bubble Sort): ");
        cetak(data);
        in.close();
    }
}
