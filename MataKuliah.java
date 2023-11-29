abstract class MataKuliah {
    private String namaMataKuliah;

    public MataKuliah(String namaMataKuliah) {
        this.namaMataKuliah = namaMataKuliah;
    }

    public String getNamaMataKuliah() {
        return namaMataKuliah;
    }

    // Abstract method yang akan diimplementasikan oleh subclass
    public abstract void displayInfo();
}