package małotacezar;

import java.util.Scanner;

/**
 * @author Adam Małota
 */
public class Cezar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Wpisz zdanie używając alfabetu łacińskiego oraz spacji (1-30 znaków)");

        int key = 13; //klucz 

        String word = in.nextLine();
        if (checkWord(word) && checkKey(key)) { //sprawdza czy klucz i zdanie jest poprawne
            System.out.println("Zaszyfrowany tekst kluczem " + key + " :");
            encode(word, key); //koduje zdanie za pomoca szyfru cezara
        }
    }

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
    Funkcja encode() koduje zdanie za pomoca szyfru cezara.
    Przyjmuje jako argumenty zdanie (String) oraz klucz (int).
    Zwraca zaszyfrowany tekst w konsoli.
     */
    static void encode(String word, int key) {
        String code = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)==' ') { //sprawdza czy znak jest spacją. Jeżeli tak przepisuje.
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
}
