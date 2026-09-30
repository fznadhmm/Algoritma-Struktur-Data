public class MainLinkedList {
    public static void main(String[] args) {
        LinkedList rakBuku = new LinkedList();

        // 1. Membuat beberapa objek Buku
        Buku buku1 = new Buku("Laskar Pelangi", "Andrea Hirata", 529);
        Buku buku2 = new Buku("Bumi Manusia", "Pramoedya Ananta Toer", 535);
        Buku buku3 = new Buku("Filosofi Teras", "Henry Manampiring", 346);

        System.out.println("\n--- 1. INSERTION (PENAMBAHAN DATA) ---");

        System.out.println("\n[Kondisi Awal Rak masih kosong]:");
        System.out.print("Isi Rak : ");
        rakBuku.display();

        System.out.println("\n-> Menambahkan 'Laskar Pelangi' (insertLast)...");
        rakBuku.insertLast(buku1);
        System.out.print("Sesudah : ");
        rakBuku.display();

        System.out.println("\n-> Menambahkan 'Bumi Manusia' (insertLast)...");
        rakBuku.insertLast(buku2);
        System.out.print("Sesudah : ");
        rakBuku.display();

        System.out.println("\n-> Menambahkan 'Filosofi Teras' di Paling Depan (insertFirst)...");
        rakBuku.insertFirst(buku3);
        System.out.print("Sesudah : ");
        rakBuku.display();

        System.out.println("\n--- 2. DELETION (PENGHAPUSAN DATA) ---");

        System.out.println("\n[Sebelum Delete First]:");
        System.out.print("Isi Rak : ");
        rakBuku.display();

        System.out.println("-> Menghapus buku paling depan (deleteFirst)...");
        rakBuku.deleteFirst();
        System.out.print("[Sesudah Delete First] : ");
        rakBuku.display();

        System.out.println("\n[Sebelum Delete Last]:");
        System.out.print("Isi Rak : ");
        rakBuku.display();

        System.out.println("-> Menghapus buku paling belakang (deleteLast)...");
        rakBuku.deleteLast();
        System.out.print("[Sesudah Delete Last]  : ");
        rakBuku.display();

       System.out.println("\n--- 3. SEARCH (PENCARIAN DATA) ---");
        Buku cari1 = new Buku("Laskar Pelangi", "", 0);
        Buku cari2 = new Buku("Harry Potter", "", 0);

        System.out.println("Apakah 'Laskar Pelangi' ada di rak? " + rakBuku.search(cari1));
        System.out.println("Apakah 'Harry Potter' ada di rak? " + rakBuku.search(cari2));
    }
}