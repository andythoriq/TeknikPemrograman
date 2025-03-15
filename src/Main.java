import collections.DataDosen;
import collections.DataMahasiswa;
import collections.DataMataKuliah;
import collections.HistoryAbsensi;
import menus.Menu;
import models.Dosen;
import models.Mahasiswa;
import models.MataKuliah;
import services.Absensi;
import session.UserDosen;
import session.UserMahasiswa;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi data
        DataMahasiswa dataMahasiswa = new DataMahasiswa();
        DataDosen dataDosen = new DataDosen();
        DataMataKuliah dataMataKuliah = new DataMataKuliah();
        HistoryAbsensi historyAbsensi = new HistoryAbsensi();

        // Tambahkan beberapa Mahasiswa
        dataMahasiswa.tambahMahasiswa(new Mahasiswa("220001", "Adi"));
        dataMahasiswa.tambahMahasiswa(new Mahasiswa("220002", "Budi"));
        dataMahasiswa.tambahMahasiswa(new Mahasiswa("220003", "Citra"));

        // Tambahkan beberapa Dosen
        dataDosen.tambahDosen(new Dosen("D001", "Dr. Anwar"));
        dataDosen.tambahDosen(new Dosen("D002", "Prof. Siti"));

        // Tambahkan beberapa Mata Kuliah
        dataMataKuliah.tambahMataKuliah(new MataKuliah("MK001", "Pemrograman Java", "Senin"));
        dataMataKuliah.tambahMataKuliah(new MataKuliah("MK002", "Struktur Data", "Sabtu"));
        dataMataKuliah.tambahMataKuliah(new MataKuliah("MK003", "Basis Data", "Sabtu"));

        while (true) {
            System.out.println("===== LOGIN =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Dosen");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();

                    Optional<Mahasiswa> mahasiswaOpt = dataMahasiswa.getByNim(nim);
                    if (mahasiswaOpt.isEmpty()) {
                        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
                        return;
                    }

                    UserMahasiswa sessionMhs = new UserMahasiswa(mahasiswaOpt);
                    System.out.println("Login berhasil! Selamat datang, " +
                            sessionMhs.getMahasiswa().map(Mahasiswa::nama).orElse("Tidak ditemukan"));

                    Menu menuMhs = new Menu(sessionMhs, dataMataKuliah, historyAbsensi);
                    menuMhs.showMenuMhs();
                }
                case 2 -> {
                    System.out.print("Masukkan NID: ");
                    String nid = scanner.nextLine();

                    Optional<Dosen> dosenOpt = dataDosen.getByNid(nid);
                    if (dosenOpt.isEmpty()) {
                        System.out.println("Dosen dengan NID " + nid + " tidak ditemukan.");
                        return;
                    }

                    UserDosen sessionDosen = new UserDosen(dosenOpt.get());
                    System.out.println("Login berhasil! Selamat datang, " + sessionDosen.getDosen().map(Dosen::nama)
                            .orElse("Tidak ditemukan"));

                    Menu menuDosen = new Menu(sessionDosen, dataMataKuliah, historyAbsensi);
                    menuDosen.showMenuDosen();
                }
                case 0 -> {
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
