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
        if (checkWord(word)) { //sprawdza czy zdanie jest poprawne
            System.out.println("Zaszyfrowany tekst:");
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
    Funckja isSpace() sprawdza czy char jest spacją. 
    Przyjmuje jako argument symbol (char)
    Jeżeli tak zwraca true, jeżeli nie zwraca false.
     */
    static boolean isSpace(char a) {
        if (a == ' ') {
            return true;
        } else {
            return false;
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
            if (isSpace(word.charAt(i))) { //sprawdza czy znak jest spacją
                code += ' ';
                continue;
            }
            key %= 26;
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
