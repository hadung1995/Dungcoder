package com.example.amd.assignmenmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by AMD on 12/7/2017.
 */

public class Database extends SQLiteOpenHelper {
        private static String DB_PATH = "/data/data/com.example.amd.assignmenmap/databases/";
        private static String DB_NAME = "HuyAssignment.sqlite";
        private SQLiteDatabase myDataBase;
        private final Context myContext;
        private static final String TABLE_NAME_user = "Login";

        public Database(Context context) {
            super(context, DB_NAME, null, 1);
            myContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        public void openDataBase() throws SQLException {

            //Open the database
            String myPath = DB_PATH + DB_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }

        @Override
        public synchronized void close() {

            if (myDataBase != null)
                myDataBase.close();

            super.close();

        }

        private boolean checkDataBase() {
            SQLiteDatabase checkDB = null;

            try {
                String myPath = DB_PATH + DB_NAME;
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            } catch (SQLiteException e) {
                //database chua ton tai
            }

            if (checkDB != null)
                checkDB.close();

            return checkDB != null ? true : false;
        }

        private void copyDataBase() throws IOException {

            //mo db trong thu muc assets nhu mot input stream
            InputStream myInput = myContext.getAssets().open(DB_NAME);

            //duong dan den db se tao
            String outFileName = DB_PATH + DB_NAME;

            //mo db giong nhu mot output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //truyen du lieu tu inputfile sang outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            //Dong luon
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }

        public void createDataBase() throws IOException {
            boolean dbExist = checkDataBase(); //kiem tra db

            if (dbExist) {
                //khong lam gi ca, database da co roi
            } else {
                this.getReadableDatabase();
                try {
                    copyDataBase(); //chep du lieu
                } catch (IOException e) {
                    throw new Error("Error copying database");
                }
            }
        }

        public String checkuser(String username) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_user + " WHERE username=?", new String[]{username});
            String pass = "";
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                pass = cursor.getString(2);
                cursor.close();
            }
            return pass;
        }
        public void themuser(User u){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("Username",u.username);
            values.put("Password",u.password);
            values.put("Fullname",u.name);
            values.put("Dob",u.dob);
            db.insert("Login",null,values);
        }
    public ArrayList<Place> xemmap(){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Place> arrayList=new ArrayList<>();
        Cursor c=db.rawQuery("SELECT * FROM Place",null);
        if(c.moveToFirst())
            do{
                int id=c.getInt(0);
                String name=c.getString(1);
                String address=c.getString(2);
                Double latitude=c.getDouble(3);
                Double longtitude=c.getDouble(4);
                String description=c.getString(5);
                byte[] picture=c.getBlob(6);
                arrayList.add(new Place(id,name,address,latitude,longtitude,description,picture));
            }
            while (c.moveToNext());
        return arrayList;

    }

    public void suaPlace(Place std){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="UPDATE Place SET Name=?, Address=?, Latitude=?, Longtitude=?, Description=?, Picture=? WHERE _id=?";
        SQLiteStatement sqLiteStatement=db.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,std.name);
        sqLiteStatement.bindString(2,std.address);
        sqLiteStatement.bindDouble(3,std.latitude);
        sqLiteStatement.bindDouble(4, std.longtitude);
        sqLiteStatement.bindString(5,std.description);
        sqLiteStatement.bindBlob(6,std.picture);
        sqLiteStatement.bindDouble(7,std.id);
        sqLiteStatement.execute();
    }
    public void xoaPlace(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("Place","_id=?",new String[]{id+""});
    }
    public void themplace(Place std){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="INSERT INTO Place VALUES(null,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,std.name);
        sqLiteStatement.bindString(2,std.address);
        sqLiteStatement.bindDouble(3,std.latitude);
        sqLiteStatement.bindDouble(4, std.longtitude);
        sqLiteStatement.bindString(5, std.description);
        sqLiteStatement.bindBlob(6,std.picture);
        sqLiteStatement.executeInsert();

    }
    }

