// Subclass 3 dari MataKuliah
class MataKuliah3 extends MataKuliah implements Interface2, Interface3 {
    public MataKuliah3(String namaMataKuliah) {
        super(namaMataKuliah);
    }

    @Override
    public void displayInfo() {
        System.out.println("Ini adalah Mata Kuliah 3: " + getNamaMataKuliah());
    }

    @Override
    public void methodInterface2() {
        System.out.println("Implementasi dari Interface2 pada MataKuliah3");
    }

    @Override
    public void methodInterface3() {
        System.out.println("Implementasi dari Interface3 pada MataKuliah3");
    }
}