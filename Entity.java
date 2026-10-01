public abstract class Entity {
    private String nama;

    public Entity() {
    }

    public Entity(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}