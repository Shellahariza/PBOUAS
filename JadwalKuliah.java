class JadwalKuliah {
    private MataKuliah mataKuliah;
    private String hari;
    private String jamMulai;
    private String jamSelesai;

    public JadwalKuliah(MataKuliah mataKuliah, String hari, String jamMulai, String jamSelesai) {
        this.mataKuliah = mataKuliah;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
    }

    public boolean bentrok(JadwalKuliah jadwalLain) {
        // Logika cek bentrok jadwal
        // Misalnya, jika hari sama dan rentang jam saling bersinggungan
        return this.hari.equalsIgnoreCase(jadwalLain.hari) &&
               (this.jamMulai.compareTo(jadwalLain.jamSelesai) < 0) &&
               (this.jamSelesai.compareTo(jadwalLain.jamMulai) > 0);
    }

    public void tampilkanJadwal() {
        System.out.println("Mata Kuliah: " + mataKuliah.getNamaMataKuliah() +
                           "\nHari: " + hari +
                           "\nJam: " + jamMulai + " - " + jamSelesai);
    }
}
