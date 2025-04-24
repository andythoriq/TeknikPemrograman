package model;

public class Product<T> {
    private T code;
    private String name;

    public Product(T code, String name) {
        this.code = code;
        this.name = name;
    }

    public T getCode() { return code; }

    public String toString() {
        return "[" + code + "] " + name;
    }
}
