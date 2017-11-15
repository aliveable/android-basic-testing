package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.Check.NameCheck;
import cc.somkiat.basicunittesting.exception.InputNameEmptyExc;
import cc.somkiat.basicunittesting.exception.NameNotEngExc;
import static org.junit.Assert.assertTrue;

/**
 * Created by 58070012 on 11/14/2017.
 */

public class NameValidationCheck {

    @Test(expected = InputNameEmptyExc.class)
    public void nameIsEmpty()throws InputNameEmptyExc{
        String name = "";
        NameCheck nameCheck = new NameCheck(name);
        nameCheck.nameNotEmpty();
    }

    @Test(expected = NameNotEngExc.class)
    public void namenoteng()throws NameNotEngExc{
        String name = "จันโอชา";
        NameCheck nameCheck = new NameCheck(name);
        nameCheck.nameNotEng();
    }

    @Test
    public void nameiseng()throws NameNotEngExc{
        String name = "alive";
        NameCheck nameCheck = new NameCheck(name);
        assertTrue("Need `true` f",nameCheck.nameNotEng());

    }


    @Test(expected = NameNotEngExc.class)
    public void namecontainSpecial()throws NameNotEngExc{
        String name = "";
        NameCheck nameCheck = new NameCheck(name);
        nameCheck.nameNotEng();
    }


    @Test
    public void nameiscorrect() throws NameNotEngExc, InputNameEmptyExc{
        String name = "alive";
        NameCheck nameCheck = new NameCheck(name);
        assertTrue("Need `true` f",nameCheck.CheckName());
    }




}
