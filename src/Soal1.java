import java.math.BigInteger;
import java.util.Scanner;

public class Soal1 {

    private static Scanner inp = new Scanner(System.in);
    private static int n;

    public static void main(String[] args) {

        System.out.print("Berapa bilangan yang ingin anda masukkan? ");
        n = inp.nextInt();
//        inp.nextLine();
        BigInteger[] num_list = new BigInteger[n];

        // menerima input dari user
        for (int i = 0; i < n; i++) {
            num_list[i] = inp.nextBigInteger();
        }

        // membandingkan tiap input dari user
        for (int i = 0; i < n; i++) {
            if (num_list[i].compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 ||
                    num_list[i].compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
                System.out.println(num_list[i] + " cannot be fitted anywhere");
            } else {
                System.out.println(num_list[i] + " can be fitted in");
                if (num_list[i].compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0 &&
                        num_list[i].compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0) {
                    System.out.println("* byte");
                }
                if (num_list[i].compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0 &&
                        num_list[i].compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0) {
                    System.out.println("* short");
                }
                if (num_list[i].compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0 &&
                        num_list[i].compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0) {
                    System.out.println("* int");
                }
                System.out.println("* long");
            }
        }
    }
}
