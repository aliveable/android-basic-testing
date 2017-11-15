package cc.somkiat.basicunittesting.Check;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.InputNameEmptyExc;
import cc.somkiat.basicunittesting.exception.NameNotEngExc;

/**
 * Created by 58070012 on 11/14/2017.
 */

public class NameCheck {

    String name;

    public NameCheck(String name){
        this.name = name;
    }


    public boolean CheckName() throws NameNotEngExc, InputNameEmptyExc{
        nameNotEng();
        nameNotEmpty();
        return true;

    }

    public boolean nameNotEmpty()throws InputNameEmptyExc{
        if (this.name.isEmpty()){
            throw new InputNameEmptyExc("Your Name Is Empty");
        }
        return true;
    }


    public boolean nameNotEng()throws NameNotEngExc{
        if (!Pattern.matches("^[a-zA-Z]+$", this.name)){
            throw new NameNotEngExc("Your Name Is Not English");
        }
        return true;
    }


}
