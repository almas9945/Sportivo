package com.example.sporty;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "player.db";
    public static final String TABLE_NAME = "registration_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "Email";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "Contact";
    public static final String COL_6 = "Qualification";
    public static final String COL_7 = "Gender";
    public static final String COL_8 = "pre_history";
    public static final String COL_9 = "games";
    public static final String COL_10 = "p_session";
    public static final String COL_11 = "age";
    public static final String TABLE__NAME2="registration2";
    public static final String COlumn_1 = "Key_ID";
    public static final String COlumn_2 = "NAME";
    public static final String COlumn_3 = "matches";
    public static final String COlumn_4 = "won";
    public static final String COlumn_5 = "points";
    public static final String COlumn_6 = "game";
    public static final String Column_7="ranking";
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE__NAME2+ " (Key_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR,matches VARCHAR,won VARCHAR,points VARCHAR,game VARCHAR,ranking VARCHAR)");
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME VARCHAR,Email VARCHAR,Password VARCHAR,Contact VARCHAR,Qualification VARCHAR,Gender VARCHAR,pre_history VARCHAR,games VARCHAR,p_session VARCHAR,age VARCHAR  )");
       }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE__NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //db.execSQL("DROP TABLE IF EXISTS " + player_score);

        onCreate(db);
    }
    public Cursor getdata()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from TABLE_NAME",null );
        return cursor;
    }

}

