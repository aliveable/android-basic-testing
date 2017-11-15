package cc.somkiat.basicunittesting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import cc.somkiat.basicunittesting.model.UserSsetting;

public class MainActivity extends AppCompatActivity implements UserSsetting.userProfileListener{

    private EditText name;
    private DatePicker birthday;
    private EditText email;

    private Button save;
    private Button revert;

    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = findViewById(R.id.userNameInput);
        this.birthday = findViewById(R.id.dateOfBirthInput);
        this.email = findViewById(R.id.emailInput);

        this.save = findViewById(R.id.saveButton);
        this.revert = findViewById(R.id.revertButton);

        this.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveClick();
            }
        });

        this.revert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRevertClick();
            }
        });

        MainActivity.mContext = this;

    }

    public void onSaveClick() {
        UserSsetting userSsetting = new UserSsetting(this,
                this.name.getText().toString(),new Date(this.birthday.getYear(),
                this.birthday.getMonth(), this.birthday.getDayOfMonth()),
                this.email.getText().toString());

    }

    public void onRevertClick() {
        this.name.setText("");
        this.email.setText("");
    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
