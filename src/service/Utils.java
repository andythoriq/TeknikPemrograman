package service;

import java.util.List;

public class Utils {
    // Generic Method
    public static <T> void printAll(List<T> list) {
        System.out.println("== Daftar ==");
        for (T item : list) {
            System.out.println(item);
        }
    }
}
