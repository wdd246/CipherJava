package malotaCipher;
/**
 * @author Adam Małota
 */
public class Cipher {

    private int key;
    private String alfa = "ABCDEFGHIJKLMNOPQRSTUWVXYZ";
    private CharProc cp;

    public Cipher(CharProc cp){
        this.cp = cp;
    }

    public Cipher() {
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }

//    public String encryptASCII(String string, int key) {
//        String code = "";
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == ' ') { //sprawdza czy znak jest spacją. Jeżeli tak przepisuje.
//                code += ' ';
//                continue;
//            }
//            this.key %= 26; // ilość znaków od A do Z
//            int c = string.charAt(i) + key; //dodaje do wartości znaku wartość klucza
//
//            if (c >= 'A' && c <= 'Z') {
//                code += (char) c;
//            }
//            if (c > 'Z') {
//                code += (char) (c - 'Z' + 'A' - 1); //jeżeli znak z kluczem nie mieści się w zakresie, zakres zaczynamy od początku
//            }
//            if (c < 'A') {
//                code += (char) (c + 'Z' - 'A' + 1); //jeżeli znak jest mniejszy niż zakres, zakres zaczynamy od tyłu
//            }
//        }
//        return code;
//
//    }
    
    String decrypt(String string) {
        return process(string);
    }
    
    public String encrypt(String string){
        return process(string);
    }

    public String process(String string) {
        //String alfa = "ABCDEFGHIJKLMNOPQRSTUWVXYZ"; //alafbet
        int alfalen = alfa.length(); //długość alfabetu

        //String s = ""; //wynik końcowy
        StringBuilder s = new StringBuilder();//wynik końcowy

        this.key %= alfalen; //klucz o odpowieniej długości

        for (int i = 0; i < string.length(); ++i) {
            char ch = string.charAt(i);
            ch = cp.process(ch);
            s.append(ch); //szybsza metoda stringBuilder

        }
        return s.toString();
    }

//    String decryptASCII(String string, int key) {
//        return encryptASCII(string,-this.key);
//    }
    
}
