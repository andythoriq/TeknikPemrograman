package pages;

import interfaces.InputCRUD;
import java.util.Scanner;

public class Pages implements InputCRUD {
    protected Scanner scanner;

    public Pages() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Input harus berupa angka!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public String inputString(String prompt) {
        System.out.print(prompt);
        scanner.nextLine();
        return scanner.nextLine();
    }

    @Override
    public double inputDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("❌ Input harus berupa angka!");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
