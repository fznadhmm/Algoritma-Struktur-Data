package wArrayAll_Sorting;
import java.util.Scanner;

public class wArrayShellSort {

    static void shellSort(int[] l) {
        int n = l.length;
        for (int gap = n / 2; gap >= 1; gap = gap / 2) {
            for (int i = gap; i < n; i++) {
                int temp = l[i];
                int j = i;
                while (j >= gap && l[j - gap] > temp) {
                    l[j] = l[j - gap];
                    j = j - gap;
                }
                l[j] = temp;
            }
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
        shellSort(data);
        System.out.print("Setelah diurutkan (Shell Sort): ");
        cetak(data);
        in.close();
    }
}
