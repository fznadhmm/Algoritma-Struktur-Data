package wArrayAll_Sorting;
import java.util.Scanner;

public class wArrayInsertionSort {

  
    static void insertionSort(int[] l) {
        int n = l.length;
        for (int i = 1; i < n; i++) {
            int kunci = l[i];
            int j = i - 1;
            while (j >= 0 && l[j] > kunci) {
                l[j + 1] = l[j];            
                j--;
            }
            l[j + 1] = kunci;
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
        insertionSort(data);
        System.out.print("Setelah diurutkan (Insertion Sort): ");
        cetak(data);
        in.close();
    }
}
