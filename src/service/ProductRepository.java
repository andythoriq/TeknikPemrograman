package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

// Inheritance interface Generic Class
public class ProductRepository<T extends Product> implements Repository<T> {
    private List<T> productList = new ArrayList<>();

    @Override
    public void save(T item) {
        productList.add(item);
    }

    @Override
    public List<T> findAll() {
        return productList;
    }

    public <K> T findByCode(K code) {
        for (T p : productList) {
            if (p.getCode().toString().equalsIgnoreCase(code.toString())) return p;
        }
        return null;
    }
}
