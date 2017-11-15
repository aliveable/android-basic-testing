package cc.somkiat.basicunittesting.Check;

import android.util.Patterns;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.InputEmailEmptyExc;
import cc.somkiat.basicunittesting.exception.NotEmailPatternExc;

/**
 * Created by 58070012 on 11/14/2017.
 */

public class EmailCheck {
    private String email;

    public EmailCheck(String email){
        this.email = email;
    }

    public boolean Check() throws InputEmailEmptyExc, NotEmailPatternExc{
        this.isNotEmpty();
        this.isPattern();
        return true;
    }

    public boolean isNotEmpty()throws InputEmailEmptyExc{
            if (this.email.isEmpty()){
                throw new InputEmailEmptyExc("Your E-mail Is Empty");
            }
            return true;
    }

    public  boolean isPattern()throws NotEmailPatternExc{
        if (!Patterns.EMAIL_ADDRESS.matcher(this.email).matches()){
            throw new NotEmailPatternExc("Your Input Is Not E-mail Pattern");
        }
        return true;
    }

}
