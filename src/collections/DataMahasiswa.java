package collections;

import models.Mahasiswa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataMahasiswa {
    private ArrayList<Mahasiswa> dataMahasiswa;
    private Map<String, String> mahasiswaMap;

    public DataMahasiswa() {
        this.dataMahasiswa = new ArrayList<>();
        this.mahasiswaMap = new HashMap<>();
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        dataMahasiswa.add(mahasiswa);
        mahasiswaMap.put(mahasiswa.nim(), mahasiswa.nama());
    }

    public Optional<Mahasiswa> getByNim(String nim) {
        return dataMahasiswa.stream()
                .filter(m -> m.nim().equals(nim))
                .findFirst();
    }

}
