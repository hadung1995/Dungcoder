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
    public void themclass(Class cl){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",cl.name);
        values.put("typetraining",cl.train);
        values.put("course_id",cl.course_id);
        db.insert("Class",null,values);
    }
    public ArrayList<Class> xemclass(int course_id){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Class> arrayList=new ArrayList<>();
        Cursor c=db.rawQuery("SELECT * FROM Class WHERE course_id=? ",new String[]{String.valueOf(course_id)});
        if(c.moveToFirst())
            do{
                int class_id=c.getInt(0);
                String class_name=c.getString(1);
                String typetrain=c.getString(2);
                int class_course_id=c.getInt(3);
                arrayList.add(new Class(class_id,class_name,typetrain,class_course_id));
            }
            while (c.moveToNext());
        return arrayList;
    }
    public void xoaClass(int id,int id2)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("Class","course_id=? and _id=?",new String[]{id+"",""+id2});
    }
    public void suaClass(Class cl) {
        //c la cong viec co id cu, noidung va thoigian la moi (can update)
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",cl.name);
        values.put("typetraining",cl.train);
        values.put("course_id",cl.course_id);
        db.update("Class",values,"_id=?",new String[]{cl.id+""});
    }
    public void themstudent(Student std){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="INSERT INTO Student VALUES(null,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,std.name);
        sqLiteStatement.bindString(2,std.dob);
        sqLiteStatement.bindString(3,std.sex);
        sqLiteStatement.bindString(4, String.valueOf(std.class_id));
        sqLiteStatement.bindBlob(5,std.picture);
        sqLiteStatement.executeInsert();

    }
    public ArrayList<Student> xemStudent(int class_id){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Student> arrayList=new ArrayList<>();
        Cursor c=db.rawQuery("SELECT * FROM Student WHERE class_id=?",new String[]{class_id+""});
        if(c.moveToFirst())
            do{
                int _id=c.getInt(0);
                String name=c.getString(1);
                String dob=c.getString(2);
                String sex=c.getString(3);
                int classid=c.getInt(4);
                byte[] picture=c.getBlob(5);
                arrayList.add(new Student(_id,name,dob,sex,classid,picture));
            }
            while (c.moveToNext());
        return arrayList;
    }
    public void suaStudent(Student std){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="UPDATE Student SET name=?, dob=?, sex=?, class_id=?, picture=? WHERE _id=?";
        SQLiteStatement sqLiteStatement=db.compileStatement(sql);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1,std.name);
        sqLiteStatement.bindString(2,std.dob);
        sqLiteStatement.bindString(3,std.sex);
        sqLiteStatement.bindString(4, String.valueOf(std.class_id));
        sqLiteStatement.bindBlob(5,std.picture);
        sqLiteStatement.bindString(6, String.valueOf(std.id));
        sqLiteStatement.execute();
    }
    public void xoaStudent(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("Student","_id=?",new String[]{id+""});
    }
    public void themsubject(Subject s){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",s.s_name);
        values.put("class_id",s.class_id);
        db.insert("Subject",null,values);
    }
    public ArrayList<Subject> xemsubject(int class_id){
        SQLiteDatabase db=this.getReadableDatabase();
        ArrayList<Subject> arrayList=new ArrayList<>();
        Cursor c=db.rawQuery("SELECT * FROM Subject where class_id=?",new String[]{""+class_id});
        if(c.moveToFirst())
            do{
                int id=c.getInt(0);
                int c_id=c.getInt(1);
                String name=c.getString(2);
                arrayList.add(new Subject(id,c_id,name));
            }
            while (c.moveToNext());
        return arrayList;
    }
    public void xoasubject(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("Subject","_id=?",new String[]{id+""});
    }
    public void suaSubject(Subject s) {
        //c la cong viec co id cu, noidung va thoigian la moi (can update)
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",s.s_name);
        values.put("class_id",s.class_id);
        db.update("Subject",values,"_id=?",new String[]{s.s_id+""});
    }





}
