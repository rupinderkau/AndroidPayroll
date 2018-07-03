package com.example.developers.androidpayroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public EditText username,password;
    public Button login,signup;
    public CheckBox checkBox1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.Username);
        password=(EditText)findViewById(R.id.Password);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login();


            }
        });
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Signup();
            }

        });


    }


    private void Login()
            {
                String user= username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                if (user.equals("RUPINDER")&& pass.equals("rupinder"))
                {
                    Toast.makeText(this,"username and password matched",Toast.LENGTH_LONG).show();
                    Intent home=new Intent(this,HomeActivity.class);
                    startActivity(home);
                }
                else
                    Toast.makeText(this,"username and password do not matched",Toast.LENGTH_LONG).show();
            }


    public void Signup()
    {
        Intent signup=new Intent(this,SignupActivity.class);

        startActivity(signup
        );
    }


}


