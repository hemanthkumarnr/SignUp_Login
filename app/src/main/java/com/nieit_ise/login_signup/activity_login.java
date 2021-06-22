package com.nieit_ise.login_signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class activity_login extends AppCompatActivity {

    private Button btnlogin;
    private EditText usName,password;
    private String struname,strpswd;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usName = findViewById(R.id.usernamelogin);
        password = findViewById(R.id.passwordlogin);
        btnlogin = findViewById(R.id.btnlogin);
        Bundle bundle = getIntent().getExtras();
        struname = bundle.getString("Username");
        strpswd = bundle.getString("Password");
        Intent intent = new Intent(getApplicationContext(),activity_loginsucess.class);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter!=2)
                {
                    if(usName.getText(). toString().equals(struname) && password.getText().toString().equals(strpswd)){
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(activity_login.this,"Username / Password is invaid",Toast.LENGTH_SHORT).show();
                        counter++;
                        usName.setText(null);
                        password.setText(null);
                    }
                }
                else {
                    Toast.makeText(activity_login.this,"Maximum attempts reached!!",Toast.LENGTH_SHORT).show();
                    btnlogin.setEnabled(false);
                }
            }
        });

    }
}