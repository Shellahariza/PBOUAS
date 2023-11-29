import java.util.ArrayList;
import java.util.Scanner;

class SistemPendidikan {
    private int totalMahasiswa;
    private ArrayList<JadwalKuliah> jadwalKuliahList;

    public SistemPendidikan() {
        this.totalMahasiswa = 0;
        this.jadwalKuliahList = new ArrayList<>();
    }

    public void daftarMahasiswa() {
        totalMahasiswa++;
        System.out.println("Seorang mahasiswa telah mendaftar dalam sistem pendidikan.");
    }

    public boolean tambahJadwalKuliah(MataKuliah mataKuliah, String hari, String jam) {
        // Mengubah hari menjadi huruf kecil sebelum menambahkan jadwal
        String hariLower = hari.toLowerCase();
        String jamSelesai = hitungJamSelesai(jam); // Hitung waktu selesai berdasarkan jam mulai

        JadwalKuliah jadwalBaru = new JadwalKuliah(mataKuliah, hariLower, jam, jamSelesai);

        if (jadwalBentrok(jadwalBaru)) {
            System.out.println("Jadwal bentrok dengan mata kuliah lain.");
            return false; // Mengembalikan false jika terdapat tabrakan jadwal
        }

        // Tambahkan jadwal baru jika tidak ada tabrakan
        jadwalKuliahList.add(jadwalBaru);
        System.out.println("Jadwal kuliah ditambahkan untuk mata kuliah: " + mataKuliah.getNamaMataKuliah());
        return true;
    }

    private boolean jadwalBentrok(JadwalKuliah jadwalBaru) {
        // Cek tabrakan dengan jadwal yang sudah ada
        for (JadwalKuliah jadwal : jadwalKuliahList) {
            if (jadwalBaru.bentrok(jadwal)) {
                return true;
            }
        }
        return false;
    }

    private String hitungJamSelesai(String jamMulai) {
        // Logika sederhana untuk menghitung waktu selesai berdasarkan jam mulai
        // Misalnya, kita anggap setiap kuliah berdurasi satu jam
        int jam = Integer.parseInt(jamMulai.substring(0, 2));
        int menit = Integer.parseInt(jamMulai.substring(3));
        
        int jamSelesai = jam + 1;
        return String.format("%02d:%02d", jamSelesai, menit);
    }

    public void tampilkanJadwalKuliah() {
        System.out.println("\nJadwal Kuliah:");
        for (JadwalKuliah jadwal : jadwalKuliahList) {
            jadwal.tampilkanJadwal();
            System.out.println("----------------------");
        }
    }
}