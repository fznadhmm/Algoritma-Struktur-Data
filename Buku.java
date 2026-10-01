public class Buku extends Entity {
    private String penulis;
    private int jumlahHalaman;

    public Buku(String judul, String penulis, int jumlahHalaman){
        setNama(judul);
        this.penulis = penulis;
        this.jumlahHalaman = jumlahHalaman;
    }

    public String getPenulis(){
        return penulis;
    }

    public int getJumlahHalaman(){
        return jumlahHalaman;
    }
   
    public void tampilkanDetail(){
        System.out.println("Buku: " + getNama() + " | Penulis" + penulis + " | Halaman " + jumlahHalaman);
    }
    
}
