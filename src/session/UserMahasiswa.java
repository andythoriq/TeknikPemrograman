package session;

import models.Mahasiswa;
import java.util.Optional;

public class UserMahasiswa extends User {
    private Optional<Mahasiswa> mahasiswa;

    public UserMahasiswa(Optional<Mahasiswa> mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public void logout() {
        mahasiswa.ifPresent(m -> System.out.println(m.nama() + " telah logout."));
        this.mahasiswa = Optional.empty();
    }

    public boolean isLoggedIn() {
        return mahasiswa.isPresent();
    }

    public Optional<Mahasiswa> getMahasiswa() {
        return mahasiswa;
    }
}
