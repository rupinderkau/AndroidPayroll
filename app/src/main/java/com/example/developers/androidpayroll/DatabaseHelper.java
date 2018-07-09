package com.example.developers.androidpayroll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Developers on 7/7/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

     public static final int DATABASE_VERSION=1;
     public static final String DATABASE_NAME="Contacts";
     public static final String TABLE_NAME="Contacts";
     public static final String TABLE_ID="id";
    //public static final int DATABASE_VERSION=1;
    //public static final String DATABASE_NAME="Contacts.db";
    //public static final String TABLE_NAME="Contacts";
    //private static final String TABLE_ID="id";
    public static final String COL_EMAIL="email";
    public static final String COL_PASSWORD="password";
    public static final String COL_UNAME="username";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null ,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Contacts("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " email TEXT,"
        + " password TEXT,"
        + " username TEXT)");
        //sqLiteDatabase.execSQL("CREATE TABLE" + TABLE_NAME +"(id INTEGER PRIMARY KEY AUTOINCREMENT, email");
       // sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT");
        //this.sqLiteDatabase=sqLiteDatabase;

    }
   /* public void insertContact(Contact s)
    {
   sqLiteDatabase=this.getWritableDatabase();

   ContentValues values=new ContentValues();

   String query="select * from Contacts";
   Cursor cursor=sqLiteDatabase.rawQuery(query,null);
   int count=cursor.getCount();

   values.put(COLUMN_ID,count);
   values.put(COLUMN_EMAIL,s.getEmail());
   values.put(COLUMN_PASSWORD,s.getPassword());
   values.put(COLUMN_UNAME,s.getUname());

   sqLiteDatabase.insert(TABLE_NAME,null, values);
  sqLiteDatabase.close();
    }
public String searchPass(String uname)
{
    sqLiteDatabase=this.getReadableDatabase();
    String query="select uname,password from"+TABLE_NAME;
    Cursor cursor= sqLiteDatabase.rawQuery(query,null);
    String a,b;
    b="not found";
    if (cursor.moveToFirst()) {
        do {
            a = cursor.getString(0);
            if (a.equals(uname)) {
                b = cursor.getString(1);
                break;
            }
        }
        while (cursor.moveToNext());
    }
    return b;


}*/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    }



