package malotaCipher;

import static java.awt.SystemColor.text;
import java.util.Scanner;

/**
 * @author Adam Małota
 */
public class Cezar {

    public static void main(String[] args) {
        
        /*
        ----------------------------------------
        Program funkcyjny & encode(String slowo, int kluicz)
         */
        
        Scanner in = new Scanner(System.in);

        System.out.println("Wpisz zdanie używając alfabetu łacińskiego oraz spacji (1-30 znaków)");

        int key = 13; //klucz 

        String word = in.nextLine();
        if (checkWord(word) && checkKey(key)) { //sprawdza czy klucz i zdanie jest poprawne
            System.out.println("Zacipherowany tekst kluczem " + key + " :");
            encode(word, key); //koduje zdanie za pomoca cipheru cezara
        }
        /*
        ----------------------------------------
        Jedna funkcja beta(String slowo,int klucz)
         */
        
        beta("ADAM",13);
        
        /*
        ---------------------------------------
        Klasa Cipher
        */
        
        Cipher cipher = new Cipher(new CesarCharProc(Alphabet.UpperCaseENG,1));
  
        //cipher.setKey(13); //default 13
        System.out.println("cipher.encrypt = "+cipher.encrypt("ADA"));
        System.out.println("cipher.decrypt = "+cipher.decrypt("BEB"));
        
        //System.out.println("cipher.encryptASCII = "+cipher.encryptASCII("ADAM",cipher.getKey()));
        //System.out.println("cipher.decryptASCII = "+cipher.decryptASCII("NQNZ",cipher.getKey()));
  
    }
    
    /*
        ----------------------------------------
        Program funkcyjny & encode(String slowo, int kluicz)
         */
    /*
    Funkcja checkWord() Sprawdza zdanie względem poprawności A-Z oraz spacja.
    Przyjnuje jako argument zdanie (String).
    Jeżeli zdanie jest poprawne zwraca true, jeżeli nie jest poprawne wywołuje wyjatek.
     */
    static boolean checkWord(String word) {
        if (word != null && word.matches("^[A-Z][A-Z ]{0,30}$")) {
            return true;
        } else {
            throw new IllegalArgumentException("Wpisz poprawne zdanie");
        }
    }

    /*
    Funkcja checkKey() sprawdza klucz względem wielokrotności 26 lub 0,
    tak aby wynik kodowania uległ zmienie względem wartości pocztkowej.
    Przyjnuje jako argument klucz (Integer).
    Jeżeli klucz jest poprawny zwraca true, jeżeli nie jest poprawny wywołuje wyjatek.
     */
    static boolean checkKey(int key) {
        if (key != 0 && key % 26 != 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Wpisz poprawny klucz. Ten klucz nie zmienia wyniku");
        }
    }

    /*
    Funkcja encode() koduje zdanie za pomoca cipheru cezara.
    Przyjmuje jako argumenty zdanie (String) oraz klucz (int).
    Zwraca zacipherowany tekst w konsoli.
     */
    static void encode(String word, int key) {
        String code = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') { //sprawdza czy znak jest spacją. Jeżeli tak przepisuje.
                code += ' ';
                continue;
            }
            key %= 26; // ilość znaków od A do Z
            int c = word.charAt(i) + key; //dodaje do wartości znaku wartość klucza

            if (c >= 'A' && c <= 'Z') {
                code += (char) c;
            }
            if (c > 'Z') {
                code += (char) (c - 'Z' + 'A' - 1); //jeżeli znak z kluczem nie mieści się w zakresie, zakres zaczynamy od początku
            }
            if (c < 'A') {
                code += (char) (c + 'Z' - 'A' + 1); //jeżeli znak jest mniejszy niż zakres, zakres zaczynamy od tyłu
            }
        }
        System.out.println(code); //wyświetlamy wynik
    }
    
    /*
        ----------------------------------------
        Jedna funkcja beta(String slowo,int klucz)
         */
    /*
    ----------------------------------------------------------------------------
    Funkcja beta() koduje zdanie za pomoca cipheru cezara z ustalonym alfabetem.
    Zwraca zacipherowany tekst w konsoli.
     */
    static String beta(String word, int key) {
        String alfa = "ABCDEFGHIJKLMNOPQRSTUWVXYZ"; //alafbet
        int alfalen = alfa.length(); //długość alfabetu
        
        //String s = ""; //wynik końcowy
        StringBuilder s = new StringBuilder();//wynik końcowy

        key%=alfalen; //klucz o odpowieniej długości
        
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            int idx = alfa.indexOf(ch);

            idx = (idx + key + alfalen) % alfalen;
            ch = alfa.charAt(idx);
            //s += ch; //wolnijesza metoda konkatenacji
            s.append(ch); //szybsza metoda stringBuilder
            
        }
        System.out.println(word + " = " + s);
        return s.toString();
    }
}
