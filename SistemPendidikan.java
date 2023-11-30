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
        String[] jamSplit = jam.split("-");

        // Memastikan format jam sesuai dengan yang diharapkan
        if (jamSplit.length != 2 || !isValidFormat(jamSplit[0]) || !isValidFormat(jamSplit[1])) {
            System.out.println("Format jam tidak sesuai. Gunakan format '00:00-00:00'.");
            return false;
        }

        String jamSelesai = hitungJamSelesai(jamSplit[1]); // Hitung waktu selesai berdasarkan jam mulai

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

    private boolean isValidFormat(String jam) {
        return jam.matches("^\\d{2}:\\d{2}$");
    }

    public void tampilkanJadwalKuliah() {
        System.out.println("\nJadwal Kuliah:");
        for (JadwalKuliah jadwal : jadwalKuliahList) {
            jadwal.tampilkanJadwal();
            System.out.println("----------------------");
        }
    }

    public void inputJadwal() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Masukkan nama mata kuliah ke-" + (i + 1) + ": ");
                String namaMataKuliah = scanner.nextLine();

                System.out.print("Masukkan hari kuliah (Senin, Selasa, Rabu, Kamis, Jumat): ");
                String hari = scanner.nextLine();

                System.out.print("Masukkan jam kuliah (format 00:00 - 00:00): ");
                String jam = scanner.nextLine();

                // Pilih jenis mata kuliah
                System.out.println("Pilih jenis mata kuliah (1, 2, 3): ");
                int jenisMataKuliah = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline

                MataKuliah mataKuliah;
                switch (jenisMataKuliah) {
                    case 1:
                        mataKuliah = new MataKuliah1(namaMataKuliah);
                        break;
                    case 2:
                        mataKuliah = new MataKuliah2(namaMataKuliah);
                        break;
                    case 3:
                        mataKuliah = new MataKuliah3(namaMataKuliah);
                        break;
                    default:
                        System.out.println("Jenis mata kuliah tidak valid.");
                        return;
                }

                boolean berhasilTambah = tambahJadwalKuliah(mataKuliah, hari, jam);

                if (!berhasilTambah) {
                    System.out.println("Apakah Anda ingin mengisi jadwal kembali? (y/n)");
                    String jawaban = scanner.nextLine().toLowerCase();

                    if (jawaban.equals("y")) {
                        i--; // Mengurangi i agar pengguna tetap mengisi untuk mata kuliah ke-i
                    } else if (jawaban.equals("n")) {
                        continue; // Melanjutkan ke mata kuliah berikutnya
                    } else {
                        System.out.println("Pilihan tidak valid. Menghentikan input.");
                        return;
                    }
                }

                System.out.println("----------------------------------------------");
            }
        }

        System.out.println("Total mahasiswa: " + getTotalMahasiswa());
        tampilkanJadwalKuliah();
    }

    public int getTotalMahasiswa() {
        return totalMahasiswa;
    }
}