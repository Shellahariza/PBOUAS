// Subclass 2 dari MataKuliah
class MataKuliah2 extends MataKuliah implements Interface1, Interface3 {
    public MataKuliah2(String namaMataKuliah) {
        super(namaMataKuliah);
    }

    @Override
    public void displayInfo() {
        System.out.println("Ini adalah Mata Kuliah 2: " + getNamaMataKuliah());
    }

    @Override
    public void methodInterface1() {
        System.out.println("Implementasi dari Interface1 pada MataKuliah2");
    }

    @Override
    public void methodInterface3() {
        System.out.println("Implementasi dari Interface3 pada MataKuliah2");
    }
}
