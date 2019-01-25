package malotaCipher;

/**
 *
 * @author Adam Małota
 */
public class SubstCharProc extends CharProc<String> {
    
    public SubstCharProc(String alfa, String key){
        super(alfa,key);
    }
    
    @Override
    public char process(char ch) {
        int idx = alfa.indexOf(ch);
        ch = key.charAt(idx);
        return ch;
    }
}
