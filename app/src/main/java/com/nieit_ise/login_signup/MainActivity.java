package com.nieit_ise.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button signup;
    private EditText password ,usName;
    private String uname,pswd;
    private static final String PASSWORD_PATTERN="^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    Pattern psPattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = findViewById(R.id.btnsignup);
        usName = findViewById(R.id.usernamesignup);
        password = findViewById(R.id.passwordsignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = usName.getText().toString();
                pswd = password.getText().toString();

                if (uname.isEmpty() || pswd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username/Password cannot be empty", Toast.LENGTH_SHORT).show();
                }

                if (isValid()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Username", uname);
                    bundle.putString("Password", pswd);

                    Intent intent = new Intent(getApplicationContext(), activity_login.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            }
        });
    }



    private boolean isValid(){
        if (!psPattern.matcher(pswd).matches()){
            Toast.makeText(MainActivity.this, "Password doesnot match the rules", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }

}
