package com.example.developers.androidpayroll;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
   // DatabaseHelper helper = new DatabaseHelper(this);

    public EditText username, password, email;
    public Button login1, Signup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        openHelper=new DatabaseHelper(this);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        email = (EditText) findViewById(R.id.email);
        Signup1 = (Button) findViewById(R.id.signup1);
        login1 = (Button) findViewById(R.id.login1);

        Signup1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                sqLiteDatabase=openHelper.getWritableDatabase();
                String user1 = username.getText().toString().trim();
                String pass1 = password.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                insertdata(user1,pass1,email1);
                Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_LONG).show();
            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(log);
            }
        });
    }
   /* private void Signup1() {
        String user1 = username.getText().toString().trim();
        String pass1 = password.getText().toString().trim();
        String email1 = email.getText().toString().trim();
        Contact s = new Contact();
        s.setEmail(email1);
        s.setUname(user1);
        s.setPassword(pass1);
        helper.insertContact(s);
    }*/
   public  void insertdata(String user1,String pass1,String email1)
   {
       ContentValues contentValues=new ContentValues();
       contentValues.put(DatabaseHelper.COL_EMAIL,email1);
       contentValues.put(DatabaseHelper.COL_UNAME,user1);
       contentValues.put(DatabaseHelper.COL_PASSWORD,pass1);
       long id=sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
   }
}




