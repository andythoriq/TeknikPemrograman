public class ConvertDataType
{
    static short methodOne(long l)
    {
        int i = (int) l; // dari long ke int
        return (short) i; // dari int ke short (keluar method)
    }

    public static void main(String[] args)
    {
        double d = 10.25; // MULAI DARI SINI : nilai awal
        float f = (float) d; // dari double ke float
        byte b = (byte) methodOne((long) f); // dari float ke long (mausk ke method), (setelah keluar) berubah ke byte
        System.out.println(b);
    }
}
