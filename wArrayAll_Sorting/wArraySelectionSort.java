package wArrayAll_Sorting;
import java.util.Scanner;

public class wArraySelectionSort {


    static void selectionSort(int[] l) {
        int n = l.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;                       
            for (int j = i + 1; j < n; j++) {
                if (l[j] < l[min]) {
                    min = j;
                }
            }
            int t = l[i];                     
            l[i] = l[min];
            l[min] = t;
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
        selectionSort(data);
        System.out.print("Setelah diurutkan (Selection Sort): ");
        cetak(data);
        in.close();
    }
}
