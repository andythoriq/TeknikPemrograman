package menus;

import java.util.List;
import java.util.Map;

public class ShowMenus {
    protected static final List<String> MENU_MAHASISWA = List.of(
            "1. Lihat Mata Kuliah Hari Ini",
            "2. Masukkan Kode Matkul untuk Absen",
            "0. Logout"
    );

    protected static final List<String> MENU_DOSEN = List.of(
            "1. Lihat History Absensi",
            "2. Lihat Absensi Hari Ini",
            "3. Lihat Mata Kuliah Hari Ini",
            "0. Logout"
    );

    protected static final Map<Integer, String> ACTION_MAHASISWA = Map.of(
            1, "Menampilkan mata kuliah hari ini...",
            2, "Masukkan kode mata kuliah: ",
            0, "Logout berhasil."
    );

    protected static final Map<Integer, String> ACTION_DOSEN = Map.of(
            1, "Menampilkan history absensi...",
            2, "Lihat Absensi Hari Ini...",
            3, "Matakuliah hari ini...",
            0, "Logout berhasil."
    );
}
