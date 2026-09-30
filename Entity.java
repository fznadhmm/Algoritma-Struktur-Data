public abstract class Entity {
    private String nama;

    public Entity(){
    }

    public Entity(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    @Override 
    public String toString(){
        return nama;
    }

    @Override 
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity other = (Entity) obj;
        return nama.equalsIgnoreCase(other.nama);
    }


}
