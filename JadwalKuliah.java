class JadwalKuliah {
    private MataKuliah mataKuliah;
    private String hari;
    private String jam;

    public JadwalKuliah(MataKuliah mataKuliah, String hari, String jam) {
        this.mataKuliah = mataKuliah;
        this.hari = hari;
        this.jam = jam;
    }

    public boolean bentrok(JadwalKuliah jadwalLain) {
        // Mengubah hari menjadi huruf kecil sebelum membandingkan
        String hariLower = this.hari.toLowerCase();
        String hariLainLower = jadwalLain.hari.toLowerCase();

        return hariLower.equals(hariLainLower) && this.jam.equals(jadwalLain.jam);
    }

    public void tampilkanJadwal() {
        System.out.println("Mata Kuliah: " + mataKuliah.getNamaMataKuliah() + "\nHari: " + hari + "\nJam: " + jam);
    }
}