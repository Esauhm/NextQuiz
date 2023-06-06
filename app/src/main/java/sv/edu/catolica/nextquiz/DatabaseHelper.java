package sv.edu.catolica.nextquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String databaseName = "Signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table allusers(email TEXT Primary Key, password TEXT, palabra TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists allusers");
        db.execSQL("create Table allusers(email TEXT Primary Key, password TEXT, palabra TEXT)");
    }

    public Boolean insertData(String email, String password, String palabra){
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("palabra", palabra);
        long result = MyDatabase.insert("allusers", null, contentValues);

        if(result == -1){
            return false;
        } else {
            return  true;
        }
    }

    public  Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * From allusers Where email = ?", new String[]{email});

        if(cursor.getCount() > 0){
            return true;
        } else {
            return  false;
        }
    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * From allusers where email = ? and password = ?", new String[]{email, password});


        if(cursor.getCount() > 0){
            return true;
        } else {
            return  false;
        }
    }


    public String checkPalabraCorreo(String email, String palabra){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT password FROM allusers WHERE email = ? AND palabra = ?", new String[]{email, palabra});

        String password = "";

        if (cursor.moveToFirst()) {
            password = cursor.getString(0);
        }

        return password;
    }

}
