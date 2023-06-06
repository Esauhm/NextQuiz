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

    public  String obtienePalabra(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT palabra FROM allusers WHERE email = ?", new String[]{email});
        String palabra = "";

        if (cursor.moveToFirst()) {
            palabra = cursor.getString(0);
        }

        return palabra;
    }

    public void updateEmail(String currentEmail, String newEmail, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            // La contraseña y la confirmación no coinciden
            // Puedes mostrar un mensaje de error o realizar alguna acción apropiada
            return;
        }

        if (!checkPassword(currentEmail, password)) {
            // La contraseña actual ingresada es incorrecta
            // Puedes mostrar un mensaje de error o realizar alguna acción apropiada
            return;
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", newEmail);
        db.update("allusers", values, "email = ?", new String[]{currentEmail});
        db.close();
    }

    public void updatePassword(String email, String newPassword, String currentPassword, String confirmPassword) {
        if (!currentPassword.equals(confirmPassword)) {
            // La contraseña actual y la confirmación no coinciden
            // Puedes mostrar un mensaje de error o realizar alguna acción apropiada
            return;
        }

        if (!checkPassword(email, currentPassword)) {
            // La contraseña actual ingresada es incorrecta
            // Puedes mostrar un mensaje de error o realizar alguna acción apropiada
            return;
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", newPassword);
        db.update("allusers", values, "email = ?", new String[]{email});
        db.close();
    }

    public void updateKeyword(String email, String newKeyword, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            // La contraseña y la confirmación no coinciden
            // Puedes mostrar un mensaje de error o realizar alguna acción apropiada
            return;
        }

        if (!checkPassword(email, password)) {
            // La contraseña actual ingresada es incorrecta
            // Puedes mostrar un mensaje de error o realizar alguna acción apropiada
            return;
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("palabra", newKeyword);
        db.update("allusers", values, "email = ?", new String[]{email});
        db.close();
    }

    public boolean checkPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM allusers WHERE email = ? AND password = ?", new String[]{email, password});

        boolean passwordMatched = cursor.moveToFirst();

        cursor.close();
        db.close();

        return passwordMatched;
    }

}
