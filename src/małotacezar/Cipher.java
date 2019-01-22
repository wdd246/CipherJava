package małotacezar;

public class Cipher {

    private int offset = 13;
    private String alfa;

    public Cipher(String alphabet) {
        alfa = alphabet;
    }

    public Cipher() {
        alfa = Alphabet.UpperCaseENG;
    }

    public void setOffset(int key) {
        this.offset = key;
    }

    public int getOffset() {
        return this.offset;
    }

    public String encryptASCII(String string) {
        String code = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') { //sprawdza czy znak jest spacją. Jeżeli tak przepisuje.
                code += ' ';
                continue;
            }
            this.offset %= 26; // ilość znaków od A do Z
            int c = string.charAt(i) + offset; //dodaje do wartości znaku wartość klucza

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
        return code;

    }

    public String encrypt(String string) {
        //String alfa = "ABCDEFGHIJKLMNOPQRSTUWVXYZ"; //alafbet
        int alfalen = alfa.length(); //długość alfabetu

        //String s = ""; //wynik końcowy
        StringBuilder s = new StringBuilder();//wynik końcowy

        this.offset %= alfalen; //klucz o odpowieniej długości

        for (int i = 0; i < string.length(); ++i) {
            char ch = string.charAt(i);
            int idx = alfa.indexOf(ch);

            idx = (idx + this.offset + alfalen) % alfalen;
            ch = alfa.charAt(idx);
            //s += ch; //wolnijesza metoda konkatenacji
            s.append(ch); //szybsza metoda stringBuilder

        }
        return s.toString();
    }

    String decrypt(String string) {
        return null;
    }
}
