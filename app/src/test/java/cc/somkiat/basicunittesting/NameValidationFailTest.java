package cc.somkiat.basicunittesting;

import org.junit.Test;
import static  org.junit.Assert.*;

/**
 * Created by Roy on 11/10/2017.
 */

public class NameValidationFailTest {

    @Test
    public void nameisnull(){
        NameValidation validation = new NameValidation();
        boolean result = validation.isEmpty("");
        assertFalse("it cannot be null",result);
    }
}
