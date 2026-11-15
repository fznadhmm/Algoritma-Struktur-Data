# Sorting dengan Linked List (Java)

Program ini mengimplementasikan enam algoritma pengurutan data (sorting) pada **singly linked list** yang dibuat sendiri, tanpa memakai library bawaan Java untuk struktur data maupun sorting.

- Nama : _isi nama_
- NIM : _isi NIM_
- Kelas : _isi kelas_

## Algoritma yang Diimplementasikan

| File | Algoritma | Cara kerja singkat |
|---|---|---|
| `BubbleSort.java` | Bubble Sort | Membandingkan dua node bersebelahan dan menukar isinya jika urutannya salah, diulang sampai tidak ada pertukaran. |
| `SelectionSort.java` | Selection Sort | Mencari node dengan data terkecil, lalu menaruhnya di posisi yang tepat. |
| `InsertionSort.java` | Insertion Sort | Mengambil node dari bagian belum urut, lalu menyisipkannya ke posisi yang tepat di bagian yang sudah urut. |
| `ShellSort.java` | Shell Sort | Membandingkan dua node dengan jarak (gap) tertentu, mulai dari `n/2` lalu dibagi 2 sampai 1. |
| `MergeSort.java` | Merge Sort | Membagi list menjadi dua, mengurutkan masing-masing, lalu menggabungkannya. |
| `QuickSort.java` | Quick Sort | Memakai node pertama sebagai pivot, membagi list menjadi bagian kiri (≤ pivot) dan kanan (> pivot), lalu mengurutkan keduanya secara rekursif. |

## Struktur File

```
All_Sorting/
├── Node.java            -> satu simpul linked list (data dan next)
├── MyLinkedList.java    -> linked list buatan sendiri (head, tail, tambah)
├── BubbleSort.java
├── SelectionSort.java
├── InsertionSort.java
├── ShellSort.java
├── MergeSort.java
└── QuickSort.java
```

Semua file berada dalam package `All_Sorting`.

- **`Node`** menyimpan satu nilai (`data`) dan penunjuk ke node berikutnya (`next`).
- **`MyLinkedList`** menyimpan `head` dan `tail`, dengan method `tambah()` untuk menambah node di akhir list.

## Cara Menjalankan

### Lewat VS Code

Buka salah satu file sort (misalnya `BubbleSort.java`), lalu klik tombol **Run** di atas method `main`.

### Lewat terminal

Dari folder yang berisi folder `All_Sorting`:

```
javac All_Sorting/*.java
java All_Sorting.BubbleSort
```

Ganti `BubbleSort` dengan nama sort lain yang ingin dijalankan (`SelectionSort`, `InsertionSort`, `ShellSort`, `MergeSort`, atau `QuickSort`).

## Cara Pemakaian

Program meminta jumlah data lalu isinya, kemudian menampilkan proses pengurutan langkah demi langkah.

Contoh (Bubble Sort, data `4 8 2 7 9 6 5 1 3`):

```
Masukkan jumlah data: 9
Data ke-1: 4
...
=== BUBBLE SORT ===
Data awal : 4 8 2 7 9 6 5 1 3

Putaran 1 : 4 2 7 8 6 5 1 3 9
Putaran 2 : 2 4 7 6 5 1 3 8 9
Putaran 3 : 2 4 6 5 1 3 7 8 9
Putaran 4 : 2 4 5 1 3 6 7 8 9
Putaran 5 : 2 4 1 3 5 6 7 8 9
Putaran 6 : 2 1 3 4 5 6 7 8 9
Putaran 7 : 1 2 3 4 5 6 7 8 9
Putaran 8 : 1 2 3 4 5 6 7 8 9
           (tidak ada swap, berhenti)

Hasil akhir          : 1 2 3 4 5 6 7 8 9
Jumlah perbandingan  : 36
Jumlah tukar/pindah  : 23
```

Di akhir, setiap program menampilkan **jumlah perbandingan** dan **jumlah tukar/pindah node** sehingga perbedaan antar algoritma dapat dibandingkan.

Hasil untuk data `4 8 2 7 9 6 5 1 3`:

| Sort | Perbandingan | Tukar/pindah |
|---|---|---|
| Bubble | 36 | 23 |
| Selection | 36 | 7 |
| Insertion | 19 | 9 |
| Shell | 53 | 11 |
| Merge | 17 | 29 |
| Quick | 17 | 17 |

Angka ini akan berbeda jika datanya berbeda. "Tukar/pindah" berarti penukaran isi node (Bubble, Selection, Shell), penyambungan ulang node (Insertion, Merge), atau pemindahan node ke sub-list kiri/kanan (Quick).

## Kompleksitas Waktu

| Algoritma | Terbaik | Rata-rata | Terburuk |
|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) |
| Selection Sort | O(n²) | O(n²) | O(n²) |
| Insertion Sort | O(n) | O(n²) | O(n²) |
| Shell Sort | O(n log n) | bergantung gap | O(n²) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) |

## Catatan Implementasi

- Satu-satunya library yang dipakai adalah `java.util.Scanner` untuk membaca input. Tidak ada `Arrays.sort`, `ArrayList`, `LinkedList`, atau fungsi sort bawaan.
- Pada Bubble, Selection, dan Shell Sort, yang ditukar adalah isi `data` antar node, sedangkan penunjuk `next` tidak berubah.
- Pada Insertion, Merge, dan Quick Sort, node disambung ulang lewat penunjuk `next`.
- Karena singly linked list tidak bisa diakses lewat indeks, Shell Sort memakai dua penunjuk (`p` dan `q`) yang dijaga berjarak sebesar gap.
