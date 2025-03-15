package collections;

import models.MataKuliah;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class DataMataKuliah {
    private ArrayList<MataKuliah> dataMataKuliah;
    private Map<String, String> mataKuliahMap;

    public DataMataKuliah() {
        this.dataMataKuliah = new ArrayList<>();
        this.mataKuliahMap = new HashMap<>();
    }

    public void tambahMataKuliah(MataKuliah mataKuliah) {
        dataMataKuliah.add(mataKuliah);
        mataKuliahMap.put(mataKuliah.kode(), mataKuliah.nama());
    }

    public List<MataKuliah> getMataKuliahHariIni() {
        String hariIni = getHariSekarang();
        List<MataKuliah> hasil = new ArrayList<>();
        for (MataKuliah mk : dataMataKuliah) {
            if (mk.hari().equalsIgnoreCase(hariIni)) {
                hasil.add(mk);
            }
        }
        return hasil;
    }

    public void tampilkanMataKuliahHariIni() {
        List<MataKuliah> matkulHariIni = getMataKuliahHariIni();
        if (matkulHariIni.isEmpty()) {
            System.out.println("Tidak ada mata kuliah hari ini.");
        } else {
            System.out.println("Mata kuliah hari ini:");
            for (MataKuliah mk : matkulHariIni) {
                System.out.println("Kode: " + mk.kode() + " | Nama: " + mk.nama());
            }
        }
    }

    private String getHariSekarang() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
    }
}
