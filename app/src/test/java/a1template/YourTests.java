// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

public class YourTests {
    @Test
    public void encodeTests(){
        CaesarCipher classUnderTest = new CaesarCipher(8);
        assertEquals("123!!!", classUnderTest.encode("123!!!"));
        
        classUnderTest = new CaesarCipher(-3);
        assertEquals("wklv lvq'w yhub vhfuhw.", classUnderTest.encode("this isn't very secret."));

        classUnderTest = new CaesarCipher(0);
        assertEquals("this isn't very secret.", classUnderTest.encode("tHis iSn't veRy sEcreT."));
    }

    @Test
    public void decodeTests() {
        CaesarCipher classUnderTest = new CaesarCipher(1);
        assertEquals("x y z", classUnderTest.decode("a b c", -3));

        classUnderTest = new CaesarCipher(-3);
        assertEquals("~z~", classUnderTest.decode("~a~", -1));
    }

}