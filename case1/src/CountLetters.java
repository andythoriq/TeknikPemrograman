// ****************************************************************
// CountLetters.java
//
// Reads a word or phrase from the standard input and prints the
// number of occurrences of each letter in that word.
//
// Now handles non-letter characters gracefully.
//
// ****************************************************************

import java.util.Scanner;

public class CountLetters {
    public static void main(String[] args) {
        int[] counts = new int[26];
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String word = scan.nextLine();

        word = word.toUpperCase();

        for (int i = 0; i < word.length(); i++) {
            try {
                char ch = word.charAt(i);
                counts[ch - 'A']++;
            } catch (ArrayIndexOutOfBoundsException e) {
                // Karakter bukan huruf (misalnya spasi, tanda baca), abaikan saja
            }
        }

        System.out.println("\nLetter frequencies:");
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.println((char) (i + 'A') + ": " + counts[i]);
            }
        }

        scan.close();
    }
}
