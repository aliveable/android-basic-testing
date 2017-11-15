package cc.somkiat.basicunittesting.model;

import java.util.Date;

import cc.somkiat.basicunittesting.App;
import cc.somkiat.basicunittesting.Check.EmailCheck;
import cc.somkiat.basicunittesting.Check.NameCheck;
import cc.somkiat.basicunittesting.R;
import cc.somkiat.basicunittesting.exception.InputEmailEmptyExc;
import cc.somkiat.basicunittesting.exception.InputNameEmptyExc;
import cc.somkiat.basicunittesting.exception.NameNotEngExc;
import cc.somkiat.basicunittesting.exception.NotEmailPatternExc;

/**
 * Created by 58070012 on 11/14/2017.
 */

public class UserSsetting {

    public String name;
    public Date birthday;
    public String email;
    public NameCheck nameCheck;
    public EmailCheck emailCheck;
    private UserSsetting.userProfileListener userProfileListener;

    public interface userProfileListener {
        void onError(String errorMsg);
    }

    public UserSsetting(userProfileListener userProfileListener, String name, Date birthday, String email) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.userProfileListener = userProfileListener;

        this.nameCheck = new NameCheck(this.name);
        this.emailCheck = new EmailCheck(this.email);

        try {
            this.nameCheck.CheckName();
        } catch (NameNotEngExc nameNotEngExc) {
            this.userProfileListener.onError(App.getContext().getString(R.string.EmptyName));
        } catch (InputNameEmptyExc inputNameEmptyExc) {
            this.userProfileListener.onError(App.getContext().getString(R.string.NameOnlyEnglish));
        }

        try {
            this.emailCheck.Check();
        } catch (InputEmailEmptyExc inputEmailEmptyExc) {
            this.userProfileListener.onError(App.getContext().getString(R.string.EmailEmpty));
        } catch (NotEmailPatternExc notEmailPatternExc) {
            this.userProfileListener.onError(App.getContext().getString(R.string.EmailIsWrong));
        }


    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

}
