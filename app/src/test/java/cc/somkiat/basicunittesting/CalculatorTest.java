package cc.somkiat.basicunittesting;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Roy on 11/10/2017.
 */

public class CalculatorTest {

    @Test
    public void sevenplustwoequalnine(){
        Calculator calculator = new Calculator();
        int resault = calculator.plus(7,2);
        assertEquals(9,resault);


    }
}
