package collections;

import services.Absensi;
import java.time.LocalDate;
import java.util.*;


public class HistoryAbsensi {
    private List<Absensi> riwayatAbsensi;
    private Set<String> absensiHariIni;

    public HistoryAbsensi() {
        this.riwayatAbsensi = new ArrayList<>();
        this.absensiHariIni = new HashSet<>();
    }

    public void tambahAbsensi(Absensi absen) {
        absen.getMahasiswa().ifPresentOrElse(
                mahasiswa -> {
                    if (absensiHariIni.contains(mahasiswa.nim())) {
                        System.out.println("Mahasiswa dengan NIM " + mahasiswa.nim() + " sudah absen hari ini.");
                        return;
                    }
                    absensiHariIni.add(mahasiswa.nim()); // Simpan hanya NIM untuk absensi hari ini
                    riwayatAbsensi.add(absen); // Simpan objek Absensi ke riwayat lengkap
                },
                () -> System.out.println("Mahasiswa tidak ditemukan, absensi gagal.")
        );
    }

    public List<Absensi> getRiwayatAbsensi() {
        return Collections.unmodifiableList(riwayatAbsensi);
    }

    public Set<String> getAbsensiHariIni() {
        return Collections.unmodifiableSet(absensiHariIni);
    }

    public void tampilkanRiwayatAbsensi() {
        if (riwayatAbsensi.isEmpty()) {
            System.out.println("Belum ada riwayat absensi.");
            return;
        }
        System.out.println("=== Riwayat Absensi ===");
        for (Absensi absen : riwayatAbsensi) {
            System.out.println(absen);
        }
    }

    public void tampilkanAbsensiHariIni() {
        if (absensiHariIni.isEmpty()) {
            System.out.println("Belum ada absensi hari ini.");
            return;
        }
        System.out.println("=== Absensi Hari Ini (" + LocalDate.now() + ") ===");
        for (String nim : absensiHariIni) {
            System.out.println("Mahasiswa dengan NIM: " + nim);
        }
    }


    public int hitungTotalAbsensi(String nim) {
        return (int) riwayatAbsensi.stream()
                .map(Absensi::getMahasiswa)
                .flatMap(Optional::stream)  // Mengubah Optional<Mahasiswa> menjadi Mahasiswa
                .filter(mahasiswa -> mahasiswa.nim().equals(nim))
                .count();
    }
}
