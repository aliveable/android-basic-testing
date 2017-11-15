package cc.somkiat.basicunittesting;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import cc.somkiat.basicunittesting.Check.EmailCheck;
import cc.somkiat.basicunittesting.exception.InputEmailEmptyExc;
import cc.somkiat.basicunittesting.exception.InputNameEmptyExc;
import cc.somkiat.basicunittesting.exception.NotEmailPatternExc;

import static junit.framework.Assert.assertTrue;

/**
 * Created by 58070012 on 11/14/2017.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class EmailCheckValid {

    @Test(expected = InputEmailEmptyExc.class)
    public void emailIsEmpty() throws InputEmailEmptyExc {
        String email = "";
        EmailCheck emailCheck = new EmailCheck(email);
        emailCheck.isNotEmpty();
    }

    @Test(expected = NotEmailPatternExc.class)
    public void emailWithOutAtSymbol() throws NotEmailPatternExc {

        String email = "testtestmail.com";
        EmailCheck emailCheck = new EmailCheck(email);
        emailCheck.isPattern();

    }

    @Test(expected = NotEmailPatternExc.class)
    public void emailWithOutDotSymbol() throws NotEmailPatternExc {

        String email = "test@testmailcom";
        EmailCheck emailCheck = new EmailCheck(email);
        emailCheck.isPattern();

    }

    @Test(expected = NotEmailPatternExc.class)
    public void emailWithOutdotcom() throws NotEmailPatternExc {

        String email = "test@testmail";
        EmailCheck emailCheck = new EmailCheck(email);
        emailCheck.isPattern();

    }

    @Test
    public void checkpattern() throws NotEmailPatternExc {

        String email = "admin@hotmail.com";
        EmailCheck emailCheck = new EmailCheck(email);
        assertTrue("Need `true` when email is correctly", emailCheck.isPattern());

    }

    @Test
    public void emailIsCorrectly() throws NotEmailPatternExc, InputEmailEmptyExc {

        String email = "admin@hotmail.com";
        EmailCheck emailCheck = new EmailCheck(email);
        assertTrue("Need `true` when email is correctly", emailCheck.Check());


    }



}
