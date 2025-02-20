public class FloatingPoints {
    public static void main(String[] args) {
        double x = 92.98;
        System.out.println(x);
        int rounded = (int) Math.round(x); // math round jika >= 5 maka dibulatkan ke atas
        System.out.println(rounded);
    }
}
