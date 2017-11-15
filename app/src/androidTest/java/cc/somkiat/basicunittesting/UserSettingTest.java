package cc.somkiat.basicunittesting;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import cc.somkiat.basicunittesting.model.UserSsetting;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class UserSettingTest implements UserSsetting.userProfileListener {

    @Test
    public void createCorrectlyUserProfile() {

        String name = "Boonyarith";
        Date birthday = new Date(1997, 1, 11);
        String email = "admin@hotmail.com";

       UserSsetting userSsetting = new UserSsetting(this, name, birthday, email);

        assertEquals(userSsetting.getName(), name);
        assertEquals(userSsetting.getBirthday(), birthday);
        assertEquals(userSsetting.getEmail(), email);

    }

    @Override
    public void onError(String errorMsg) {

    }
}