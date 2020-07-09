package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInput_email, TextInput_password;
    RelativeLayout Relative_login;
    String emailOK = "cksgh@gmail.com";
    String passwordOK = "1234";

    String inputEmail = "";
    String inputPassword = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInput_email = findViewById(R.id.Input_email);
        TextInput_password = findViewById(R.id.Input_password);
        Relative_login = findViewById(R.id.login_lay);

        //1. 값을 가져온다 - 검사 (123@gmail.com / 1234)
        //2. 클릭을 감지한다.
        //3. 값을 다음 액티비티로 넘긴다.

        Relative_login.setClickable(false);

        TextInput_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              //  Log.d("chanho", charSequence + "," + i + ","+ i1 + ","+ i2);

                if(charSequence != null){
                    inputEmail = charSequence.toString();
                  //  Relative_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        TextInput_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Log.d("chanho", charSequence + "," + i + ","+ i1 + ","+ i2);
                if(charSequence != null){
                    inputPassword = charSequence.toString();
                    Relative_login.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


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

    public boolean validation() {
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}


