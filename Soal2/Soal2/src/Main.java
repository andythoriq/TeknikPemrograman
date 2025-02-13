public class Main {
    public static void main(String[] args) {
        int i = 42;
        String s = (i < 40) ? "life" : (i > 50) ? "universe" : "everything";
        //           false               false
        System.out.println(s);
    }
}

// jika true : jika false
// karena jawaban selalu false, maka pilihan akan selalu ke kanan

// 1. cek (i < 40)
// 2. karena false, maka java akan memilih (i > 50)
// 3. cek (i > 50)
// 4. karena false, maka java akan memilih "everything"