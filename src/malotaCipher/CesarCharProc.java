package malotaCipher;

/**
 *
 * @author Student
 */
public class CesarCharProc extends CharProc<Integer>{
    
    public CesarCharProc(String alfa, int key){
        super(alfa,key);
    }
    
    /**
     *
     * @param ch
     * @return
     */
    @Override
    public char process(char ch) {
        int alfalen = alfa.length();
        int idx = alfa.indexOf(ch);

         idx = (idx + this.key + alfalen) % alfalen;
         ch = alfa.charAt(idx);
         return ch;
    }
    
}
