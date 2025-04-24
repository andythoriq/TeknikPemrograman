package service;

import java.util.List;

// Interface Generic Classes
public interface Repository<T> {
    void save(T item);
    List<T> findAll();
}
