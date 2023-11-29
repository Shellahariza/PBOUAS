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

        JadwalKuliah jadwalBaru = new JadwalKuliah(mataKuliah, hariLower, jam);

        while (jadwalBentrok(jadwalBaru)) {
            System.out.println("Jadwal bentrok dengan mata kuliah lain.");

            // Tanyakan apakah pengguna ingin mencoba jadwal lain
            Scanner scanner = new Scanner(System.in);
            System.out.print("Apakah Anda ingin mencoba jadwal lain? (y/n): ");
            String jawaban = scanner.nextLine().toLowerCase();

            if (jawaban.equals("y")) {
                // Meminta input jadwal baru
                System.out.print("Masukkan hari kuliah (Senin, Selasa, Rabu, Kamis, Jumat): ");
                hari = scanner.nextLine();
                System.out.print("Masukkan jam kuliah (format 00:00 - 00:00): ");
                jam = scanner.nextLine();

                // Mengubah hari menjadi huruf kecil
                hariLower = hari.toLowerCase();

                // Membuat objek jadwal baru dengan input yang baru
                jadwalBaru = new JadwalKuliah(mataKuliah, hariLower, jam);
            } else {
                // Jika pengguna tidak ingin mencoba jadwal lain
                return false;
            }
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

    public int getTotalMahasiswa() {
        return totalMahasiswa;
    }

    public void tampilkanJadwalKuliah() {
        System.out.println("\nJadwal Kuliah:");
        for (JadwalKuliah jadwal : jadwalKuliahList) {
            jadwal.tampilkanJadwal();
            System.out.println("----------------------");
        }
    }
}