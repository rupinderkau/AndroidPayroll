package com.example.developers.androidpayroll;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

public class LoginActivity extends AppCompatActivity {
    //DatabaseHelper helper=new DatabaseHelper(this);
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper openHelper;

    public EditText username,password1;
    public Button login,signup;
    public CheckBox checkBox1;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        sqLiteDatabase = openHelper.getWritableDatabase();

        username = (EditText) findViewById(R.id.Username);
        password1 = (EditText) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        sharedPreferences=getSharedPreferences("loginref",MODE_PRIVATE);
        editor=sharedPreferences.edit();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password1.getText().toString().trim();
                cursor = sqLiteDatabase.rawQuery("SELECT  * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_PASSWORD + "=? AND " +  DatabaseHelper.COL_UNAME + "=?", new String[]{user, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_LONG).show();

                        if (checkBox1.isChecked())
                        {
                            editor.putBoolean("SaveLogin",true);
                            editor.putString("username",user);
                            editor.putString("password",pass);
                            editor.commit();

                        }
                    } else
                        Toast.makeText(getApplicationContext(), "username and password do not matched", Toast.LENGTH_LONG).show();
                }

                // Login();

            }
        });

        savelogin=sharedPreferences.getBoolean("SaveLogin",true);
        if (savelogin==true)
        {
        username.setText(sharedPreferences.getString("username",null));
        password1.setText(sharedPreferences.getString("password",null));
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup();
            }

        });
    }
        public void Signup()
        {
            Intent signup=new Intent(this,SignupActivity.class);

            startActivity(signup);
        }



    }


   /* private void Login()
            {
                String user= username.getText().toString().trim();
                String pass=password1.getText().toString().trim();

                /*String password=helper.searchPass(user);
                if (pass.equals(password))
                {*/

               /* if (user.equals("rupi")&& pass.equals("rupi"))
                {
                    Toast.makeText(this,"username and password matched",Toast.LENGTH_LONG).show();

                    Intent home=new Intent(this,HomeActivity.class);
                    startActivity(home);

                    if (checkBox1.isChecked())
                    {
                        editor.putBoolean("SaveLogin",true);
                        editor.putString("username",user);
                        editor.putString("password",pass);
                        editor.commit();

                    }}
                    else
                    {
                        Toast.makeText(this,"username and password do not matched",Toast.LENGTH_LONG).show();

                    }

                }

   */





