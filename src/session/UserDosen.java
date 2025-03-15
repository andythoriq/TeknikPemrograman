package session;

import models.Dosen;
import java.util.Optional;

public class UserDosen extends User {
    private Optional<Dosen> dosen;

    public UserDosen(Dosen dosen) {
        this.dosen = Optional.ofNullable(dosen);
    }

    public void logout() {
        dosen.ifPresent(d -> System.out.println(d.nama() + " telah logout."));
        this.dosen = Optional.empty();
    }

    public boolean isLoggedIn() {
        return dosen.isPresent();
    }

    public Optional<Dosen> getDosen() {
        return dosen;
    }
}
