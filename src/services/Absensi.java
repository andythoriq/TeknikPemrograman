package services;

import collections.DataMataKuliah;
import models.Mahasiswa;
import models.MataKuliah;
import session.UserMahasiswa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Absensi {
    private UserMahasiswa userMahasiswa;
    private String nim;
    private Optional<MataKuliah> mataKuliah;
    private LocalDateTime waktuAbsensi;

    public Absensi(UserMahasiswa userMahasiswa, DataMataKuliah dataMatkul, String kodeMatkul) {
        this.userMahasiswa = userMahasiswa;
        this.nim = userMahasiswa.getMahasiswa().map(Mahasiswa::nim).orElse("-");
        this.waktuAbsensi = LocalDateTime.now();

        List<MataKuliah> matkulHariIni = dataMatkul.getMataKuliahHariIni();

        this.mataKuliah = matkulHariIni.stream()
                .filter(matkul -> matkul.kode().equals(kodeMatkul))
                .findFirst();

        if (mataKuliah.isEmpty()) {
            throw new IllegalArgumentException("Kode mata kuliah tidak valid atau tidak tersedia hari ini.");
        }
    }

    public Optional<Mahasiswa> getMahasiswa() {
        return userMahasiswa.getMahasiswa();
    }

    public Optional<MataKuliah> getMataKuliah() {
        return mataKuliah;
    }

    public LocalDateTime getWaktuAbsensi() {
        return waktuAbsensi;
    }

    @Override
    public String toString() {
        return "Absensi{" +
                ", nim=" + this.nim +
                ", mataKuliah=" + mataKuliah.map(MataKuliah::nama).orElse("Tidak Ditemukan") +
                ", kodeMatkul=" + mataKuliah.map(MataKuliah::kode).orElse("Tidak Ditemukan") +
                ", waktuAbsensi=" + waktuAbsensi +
                '}';
    }
}
