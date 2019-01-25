/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malotaCipher;

import malotaCipher.Main;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam Małota
 */
public class CezarTest {

    @Test
    public void testBeta() {
        assertEquals("BEBN",Main.beta("ADAM",1));
    }
    //TODO: MORE TESTS
}
