package malotaCipher;

/**
 *
 * @author Student
 */
public class CesarCharProc extends CharProc<Integer>{
    
    public CesarCharProc(String alfa, int key){
        super(alfa,key);
    }
    
    @Override
    public char process(char ch) {
        int alfalen = alfa.length();
        int idx = alfa.indexOf(ch);
        this.key = key;

        idx = (idx + this.key + alfalen) % alfalen;
        ch = alfa.charAt(idx);
        return ch;
    }
    
}
