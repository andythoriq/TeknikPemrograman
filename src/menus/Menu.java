package menus;

import collections.DataMataKuliah;
import collections.HistoryAbsensi;
import services.Absensi;
import session.UserDosen;
import session.UserMahasiswa;
import java.util.Scanner;

public class Menu extends ShowMenus {
    private static final Scanner scanner = new Scanner(System.in);

    private UserMahasiswa mahasiswa;
    private UserDosen dosen;
    private DataMataKuliah dataMatkul;
    private HistoryAbsensi dataAbsensi;
    private Absensi absensi;

    // Constructor untuk Mahasiswa
    public Menu(UserMahasiswa mahasiswa, DataMataKuliah dataMatkul, HistoryAbsensi dataAbsensi) {
        this.mahasiswa = mahasiswa;
        this.dataMatkul = dataMatkul;
        this.dataAbsensi = dataAbsensi;
    }

    // Constructor untuk Dosen
    public Menu(UserDosen dosen, DataMataKuliah dataMatkul, HistoryAbsensi dataAbsensi) {
        this.dosen = dosen;
        this.dataMatkul = dataMatkul;
        this.dataAbsensi = dataAbsensi;
    }

    // Method untuk menampilkan menu mahasiswa
    public void showMenuMhs() {
        boolean loop = true;
        while (loop) {
            System.out.println("===== MENU MAHASISWA =====");
            MENU_MAHASISWA.forEach(System.out::println);
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (ACTION_MAHASISWA.containsKey(pilihan)) {
                System.out.println(ACTION_MAHASISWA.get(pilihan));

                switch (pilihan) {
                    case 1 -> dataMatkul.tampilkanMataKuliahHariIni();
                    case 2 -> {
                        String kodeMatkul = scanner.nextLine();

                        this.absensi = new Absensi(mahasiswa, dataMatkul, kodeMatkul);
                        dataAbsensi.tambahAbsensi(this.absensi);
                        System.out.println("Absensi berhasil");
                    }
                    case 0 -> {
                        loop = false;
                        mahasiswa.logout();
                    }
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Method untuk menampilkan menu dosen
    public void showMenuDosen() {
        boolean loop = true;
        while (loop) {
            System.out.println("===== MENU DOSEN =====");
            MENU_DOSEN.forEach(System.out::println);
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (ACTION_DOSEN.containsKey(pilihan)) {
                System.out.println(ACTION_DOSEN.get(pilihan));

                switch (pilihan) {
                    case 1 -> dataAbsensi.tampilkanRiwayatAbsensi();
                    case 2 -> dataAbsensi.tampilkanAbsensiHariIni();
                    case 3 -> dataMatkul.tampilkanMataKuliahHariIni();
                    case 0 -> {
                        loop = false;
                        dosen.logout();
                    }
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
