import java.util.Scanner;

public class ParseInts {
    public static void main(String[] args) {
        int val, sum = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        Scanner scanLine = new Scanner(scan.nextLine());

        // Perulangan membaca setiap token di dalam input
        while (scanLine.hasNext()) {
            try {
                val = Integer.parseInt(scanLine.next()); // Parsing token menjadi integer
                sum += val; // Jika sukses, tambahkan ke total sum
            } catch (NumberFormatException e) {
                // Jika ada kata yang bukan angka, abaikan saja
            }
        }

        System.out.println("The sum of the integers on this line is: " + sum);

        scan.close();
        scanLine.close();
    }
}
