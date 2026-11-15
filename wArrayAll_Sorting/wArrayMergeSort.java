package wArrayAll_Sorting;
import java.util.Scanner;

public class wArrayMergeSort {

  
    static void merge(int[] l, int kiri, int tengah, int kanan) {
        int[] hasil = new int[kanan - kiri + 1];
        int i = kiri;          
        int j = tengah + 1;    
        int k = 0;             

        while (i <= tengah && j <= kanan) {
            if (l[i] <= l[j]) {
                hasil[k] = l[i];
                i++;
            } else {
                hasil[k] = l[j];
                j++;
            }
            k++;
        }
        while (i <= tengah) { 
            hasil[k] = l[i];
            i++;
            k++;
        }
        while (j <= kanan) {   
            hasil[k] = l[j];
            j++;
            k++;
        }
        for (int x = 0; x < hasil.length; x++) {   
            l[kiri + x] = hasil[x];
        }
    }


    static void mergeSort(int[] l, int kiri, int kanan) {
        if (kiri < kanan) {
            int tengah = (kiri + kanan) / 2;
            mergeSort(l, kiri, tengah);
            mergeSort(l, tengah + 1, kanan);
            merge(l, kiri, tengah, kanan);
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
        mergeSort(data, 0, data.length - 1);
        System.out.print("Setelah diurutkan (Merge Sort): ");
        cetak(data);
        in.close();
    }
}
