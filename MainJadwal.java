import java.util.Scanner;

public class MainJadwal {
    public static void main(String[] args) {
        SistemPendidikan sistemPendidikan = new SistemPendidikan();
        sistemPendidikan.daftarMahasiswa();

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

                sistemPendidikan.tambahJadwalKuliah(mataKuliah, hari, jam);
                System.out.println("----------------------------------------------");
            }
        }

        System.out.println("Total mahasiswa: " + sistemPendidikan.getTotalMahasiswa());
        sistemPendidikan.tampilkanJadwalKuliah();
    }
}
