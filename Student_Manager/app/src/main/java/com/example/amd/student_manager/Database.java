package com.example.amd.student_manager;

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
 * Created by AMD on 11/20/2017.
 */

public class Database extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.example.amd.student_manager/databases/";
    private static String DB_NAME = "Student.sqlite";
    private SQLiteDatabase myDataBase;

    private final Context myContext;

    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void openDataBase() throws SQLException{

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //database chua ton tai
        }

        if(checkDB != null)
            checkDB.close();

        return checkDB != null ? true :false;
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
        while ((length = myInput.read(buffer))>0)
        {
            myOutput.write(buffer, 0, length);
        }

        //Dong luon
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase(); //kiem tra db

        if(dbExist){
            //khong lam gi ca, database da co roi
        }
        else{
            this.getReadableDatabase();
            try {
                copyDataBase(); //chep du lieu
            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
    public String login(String username){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM Login WHERE username=?",new String[]{username});
        String pass="";
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            pass=cursor.getString(2);
            cursor.close();
        }
        return pass;
    }
    public void themcourse(Course c){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",c.name);
        values.put("phone",c.phone);
        db.insert("Course",null,values);
    }
    public ArrayList<Course> xemCourse(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM Course",null);
        ArrayList<Course> arrayList=new ArrayList<>();
        if(c.moveToFirst())
            do{
                int id=c.getInt(0);
                String name=c.getString(1);
                String phone=c.getString(2);
                arrayList.add(new Course(id,name,phone));
            }
            while (c.moveToNext());
        return arrayList;
    }
    public void xoaCourse(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("Course","_id=?",new String[]{id+""});
    }
    public void suaCourse(Course c) {
        //c la cong viec co id cu, noidung va thoigian la moi (can update)
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",c.name);
        values.put("phone",c.phone);
        db.update("Course",values,"_id=?",new String[]{c.id+""});
    }




}
