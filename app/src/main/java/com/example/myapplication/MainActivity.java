package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInput_email, TextInput_password;
    RelativeLayout Relative_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInput_email = findViewById(R.id.Input_email);
        TextInput_password = findViewById(R.id.Input_password);
        Relative_login = findViewById(R.id.login_lay);

        //1. 값을 가져온다
        //2. 클릭을 감지한다.
        //3. 값을 다음 액티비티로 넘긴다.



        Relative_login.setClickable(true);
        Relative_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = TextInput_email.getText().toString();
                String password = TextInput_password.getText().toString();

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);

            }
        });
    }
}