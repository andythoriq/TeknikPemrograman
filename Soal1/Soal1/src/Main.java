public class Main {
    public static void main(String[] args) {
        byte angka1 = 125;
        byte angka2 = 6;
        byte hasil = (byte) (angka1 + angka2);

        System.out.println("Hasil 1 " + hasil);
        // expected hasil adalah 131
        // hasil sebenarnya 1 -125
    }
}

//penjelasan
//byte dalam java memiliki rentang dari -128 sampai 127 (256)
//jika nilai melebihi 127 maka akan terjadi overflow
// karena 131 melebihi batas, yaitu 127, maka terjadi overflow
// yang akan dilakukan java adalah melakukan perhitungan 131 - 256 = -125
