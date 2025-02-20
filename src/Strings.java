import java.util.Scanner;

public class Strings
{
    private static Scanner inpt = new Scanner(System.in);

    private String A;
    private String B;

    public String getA()
    {
        return this.A;
    }

    public void setA(String str)
    {
        this.A = str;
    }

    public String getB()
    {
        return this.B;
    }

    public void setB(String str)
    {
        this.B = str;
    }

    public int sum_len(String A, String B)
    {
        return A.length() + B.length();
    }

    public boolean cek_lexicographic(String A, String B)
    {
        return A.compareTo(B) > 0;
    }

    public String input(String prompt)
    {
        System.out.print(prompt);
        return inpt.nextLine();
    }

    public String capitalize(String str)
    {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

class Main
{
    public static void main(String[] args)
    {
        Strings str = new Strings();
        // input A
        str.setA(str.input("Masukkan nilai A: "));

        // input B
        str.setB(str.input("Masukkan nilai B: "));

        System.out.println(
                str.sum_len(str.getA(), str.getB())
        );

        // cek if (A > B)
        if (str.cek_lexicographic(str.getA(), str.getB())) {
            System.out.println("Yes A is Larger than B");
        } else {
            System.out.println("No A is not larger than B");
        }

        // print A B dengan capitalize
            System.out.println(
                    str.capitalize(str.getA()) + " " + str.capitalize(str.getB())
            );
    }
}