package brainzerstechnologies.sample.com.sharedpreferencessample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private String email =  "raazzsingh1994@gmail.com";
    private String pass = "Abc@1234";
    private EditText et_email, et_pass;
    private CheckBox cbRememerMe;
    UtilPreferences utilPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email =  (EditText) findViewById(R.id.et_email);
        et_pass =  (EditText) findViewById(R.id.et_pass);
        cbRememerMe = (CheckBox) findViewById(R.id.cb_remember_me);
        utilPreferences = new UtilPreferences(LoginActivity.this);
        if (utilPreferences.getIsLogin()){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        et_email.setText(email);
        et_pass.setText(pass);



    }

    public void onLogin(View view) {
        if (cbRememerMe.isChecked()){
            saveValuesToSharedPreferences(true);
        }
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private void saveValuesToSharedPreferences(boolean isLogin) {
        email =  et_email.getText().toString();
        pass =  et_pass.getText().toString();
        utilPreferences.setIsLogin(isLogin);
        utilPreferences.setKeyEmail(email);
        utilPreferences.setKeyPassword(pass);
    }



}
