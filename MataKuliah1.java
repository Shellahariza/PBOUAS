// Subclass 1 dari MataKuliah
class MataKuliah1 extends MataKuliah implements Interface1, Interface2 {
    public MataKuliah1(String namaMataKuliah) {
        super(namaMataKuliah);
    }

    @Override
    public void displayInfo() {
        System.out.println("Ini adalah Mata Kuliah 1: " + getNamaMataKuliah());
    }

    @Override
    public void methodInterface1() {
        System.out.println("Implementasi dari Interface1 pada MataKuliah1");
    }

    @Override
    public void methodInterface2() {
        System.out.println("Implementasi dari Interface2 pada MataKuliah1");
    }
}
