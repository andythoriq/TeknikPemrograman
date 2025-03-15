package collections;

import models.Dosen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DataDosen {
    private ArrayList<Dosen> dataDosen;
    private Map<String, String> dosenMap;

    public DataDosen() {
        this.dataDosen = new ArrayList<>();
        this.dosenMap = new HashMap<>();
    }

    public void tambahDosen(Dosen dosen) {
        dataDosen.add(dosen);
        dosenMap.put(dosen.nid(), dosen.nama());
    }

    public Optional<Dosen> getByNid(String nid) {
        return dataDosen.stream()
                .filter(d -> d.nid().equals(nid))
                .findFirst();
    }
}
