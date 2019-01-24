package malotaCipher;

/**
 *
 * @author Adam Małota
 * @param <T>
 */
public abstract class CharProc<T> {
    protected String alfa;
    protected T key;
    
    public CharProc(String alfa, T key){
        this.alfa=alfa;
        this.key=key;
    }
    
    public abstract char process(char c);
}
