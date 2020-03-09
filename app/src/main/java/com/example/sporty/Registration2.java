package com.example.sporty;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
public class Registration2 extends AppCompatActivity {
    EditText editmatch,editwon ,editpoints;
    TextView text,text1,editName;
    Button btnNext;
    String s;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Boolean EditTextEmptyHolder;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        editName = findViewById(R.id.text1);
        editmatch = findViewById(R.id.editmatch);
        editwon = findViewById(R.id.editwon);
        editpoints = findViewById(R.id.editpoints);
        text = findViewById(R.id.text);
        text1 = findViewById(R.id.text3);
        btnNext=findViewById(R.id.btnnext);
        sqLiteHelper=new SQLiteHelper(this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message1");
        String str1 = intent.getStringExtra("message2");
        text.setText(str);
        editName.setText(str1);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating SQLite database if dose n't exists
                rank_player();
                SQLiteDataBaseBuild();
                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();
                CheckEditTextStatus ();
                senddata ();
                //openActivityregister();
                // Checking EditText is empty or Not.

            }});}
    public void openActivityregister() {
        Intent intent = new Intent(this, page1.class);
        startActivity(intent);
    }
            public void rank_player(){
        String won=editwon.getText().toString();
        String match=editmatch.getText().toString();
        Double w=Double.parseDouble(won) ;
        Double m=Double.parseDouble(match);
         // if(text.10getText().toString()=="Badminton")
                Double r=((w/m)*100);
           s=Double.toString(r);
          text1.setText(s);
          System.out.print(( "out"+Double.toString(r)));
         Toast.makeText(Registration2.this, "Incorrect value selected."+s, Toast.LENGTH_LONG).show();
                }
            public void SQLiteDataBaseBuild() {
                sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
            }
            public void SQLiteTableBuild() {

                sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE__NAME2 + "(" + SQLiteHelper.COlumn_1 + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper. COlumn_2 + " VARCHAR, " + SQLiteHelper.COlumn_3 + " VARCHAR, " + SQLiteHelper.COlumn_4 + " VARCHAR, " + SQLiteHelper.COlumn_5 + " VARCHAR, " + SQLiteHelper.COlumn_6 + " VARCHAR," + SQLiteHelper.Column_7 + " VARCHAR);");
            }
            //Insert data into SQLite database method.
            public void InsertDataIntoSQLiteDatabase() {
                 //If editText is not empty then this block will executed.
                if (EditTextEmptyHolder == true) {
                    // SQLite query to insert data into table.
                   //SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE__NAME2 + " (name,matches,won,points,game,ranking) VALUES('" + editName.getText().toString() + "', '" + editmatch.getText().toString() + "', '" + editwon.getText().toString() + "', '" + editpoints.getText().toString() + "',  '" + text.getText().toString()+ "','" + text1.getText().toString()+ "');";
                    SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE__NAME2 + " (name,matches,won,pointsVARCHAR,game,ranking) VALUES('" + editName.getText().toString() + "', '" + editmatch.getText().toString() + "', '" + editwon.getText().toString() + "', '" + editpoints.getText().toString() + "', '" + text.getText().toString() + "', '" + text1.getText().toString() + "' );";
                   // sqLiteDatabaseObj.close();
                   // Executing query.
                    sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
                    // Closing SQLite database object.
                   sqLiteDatabaseObj.close();
                    // Printing toast message after done inserting.
                    Toast.makeText(Registration2.this, "Data inserted", Toast.LENGTH_LONG).show();
                }
                // This block will execute if any of the registration EditText is empty.
                else {
                    // Printing toast message if any of EditText is empty.
                    Toast.makeText(Registration2.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
                }}
    public void CheckEditTextStatus () {
        // Getting value from All EditText and storing into String Variables.
        //String NameHolder = editName.getText().toString();
        String   EmailHolder = editmatch.getText().toString();
        String  PasswordHolder = editwon.getText().toString();
        String  preHolder = editpoints.getText().toString();
        //String  pracHolder = text.getText().toString();
       // String  titleHolder = edittitle.getText().toString();

        if (TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(preHolder)) {

            EditTextEmptyHolder = false;

        } else {

            EditTextEmptyHolder = true;
            InsertDataIntoSQLiteDatabase();
        }

    }
    public void senddata () {
        if (EditTextEmptyHolder == true) {
            int  str1 =Integer.parseInt(s);
            //String str2 = r.getText().toString();
            Intent intent = new Intent(Registration2.this, page1.class);
            intent.putExtra("message1", str1);
           // intent.putExtra("message2", str2);
            startActivity(intent);
        }
        else
        {Toast.makeText(Registration2.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();}
    }
        }

