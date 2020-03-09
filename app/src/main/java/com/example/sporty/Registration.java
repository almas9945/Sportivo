package com.example.sporty;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
public class Registration extends AppCompatActivity {
    EditText editName,editemail,editpassword ,editcontact;
    Spinner qualification,gender;
    String NameHolder,EmailHolder,PasswordHolder,preHolder,pracHolder,titleHolder;
    Button btnNext;
    EditText editpre,editprac,edittitle;
    Spinner games;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Registration.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Registration.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names1));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);
        final Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Registration.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);

        editName = (EditText)findViewById(R.id.name);
        editemail = (EditText)findViewById(R.id.email);
        editpassword = (EditText)findViewById(R.id.pass);
        editcontact = (EditText)findViewById(R.id.contact);
        qualification=(Spinner) findViewById(R.id.spinner1);
        gender=(Spinner) findViewById(R.id.spinner2);
        editpre = (EditText)findViewById(R.id.pre_history);
        editprac = (EditText)findViewById(R.id.prac);
        edittitle = (EditText)findViewById(R.id.title);
        games=(Spinner) findViewById(R.id.spinner3);
        btnNext = (Button)findViewById(R.id.btn_next);
       // btnview=(Button)findViewById(R.id.btnviewAll);
        sqLiteHelper=new SQLiteHelper(this);
        //Adding click listener to register button.
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();
                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();
                // Checking EditText is empty or Not.
                CheckEditTextStatus();
                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();
                InsertDataIntoSQLiteDatabase();
                // Empty EditText After done inserting process.
                // EmptyEditTextAfterDataInsert();
                //senddata();
                //openActivityregister();
            }}); }
            // SQLite database build method.
            public void SQLiteDataBaseBuild() {
                sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
            }
            // SQLite table build method.
            public void SQLiteTableBuild() {

                sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "(" + SQLiteHelper.COL_1 + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper. COL_2 + " VARCHAR, " + SQLiteHelper.COL_3 + " VARCHAR, " + SQLiteHelper.COL_4 + " VARCHAR, " + SQLiteHelper.COL_5 +  "VARCHAR, "+ SQLiteHelper.COL_6 + " VARCHAR, "+ SQLiteHelper.COL_7 + " VARCHAR, "+ SQLiteHelper.COL_8 + " VARCHAR, "+ SQLiteHelper.COL_9 + " VARCHAR, "+ SQLiteHelper.COL_10 + " VARCHAR, "+ SQLiteHelper.COL_11 + " VARCHAR);");
             }
            // Insert data into SQLite database method.
            public void InsertDataIntoSQLiteDatabase(){
                // If editText is not empty then this block will executed.
                if (EditTextEmptyHolder == true) {
                    // SQLite query to insert data into table.
                    SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (name,email,password,Contact,Qualification,Gender,pre_history,games,P_session,title) VALUES('" + editName.getText().toString() + "', '" + editemail.getText().toString() + "', '" + editpassword.getText().toString() + "', '" + editcontact.getText().toString() + "', '" + qualification.getSelectedItem().toString() + "', '" + gender.getSelectedItem().toString() + "', '" + editpre.getText().toString() + "', '" + games.getSelectedItem().toString() + "' , '" + editprac.getText().toString() + "', '" + edittitle.getText().toString() + "');";sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
                    sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
                    sqLiteDatabaseObj.close();
                    // Printing toast message after done inserting.
                    Toast.makeText(Registration.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                }
                // This block will execute if any of the registration EditText is empty.
                else {
                    Toast.makeText(Registration.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
                    // Printing toast message if any of EditText is empty.
                }}
                // Empty edittext after done inserting process method.
               // public void EmptyEditTextAfterDataInsert() {
                    //editName.getText().clear();
                    //editemail.getText().clear();
                  //  editpassword.getText().clear();
                  //  edittitle.getText().clear();
                  //  editprac.getText().clear();
                  //  editpre.getText().clear();
                //}
                // Method to check EditText is empty or Not.
                public void CheckEditTextStatus () {
                    // Getting value from All EditText and storing into String Variables.
                    NameHolder = editName.getText().toString();
                    EmailHolder = editemail.getText().toString();
                    PasswordHolder = editpassword.getText().toString();
                    preHolder = editpre.getText().toString();
                    pracHolder = editprac.getText().toString();
                    titleHolder = edittitle.getText().toString();
                    if (TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(preHolder) || TextUtils.isEmpty(pracHolder) || TextUtils.isEmpty(titleHolder)) {
                        EditTextEmptyHolder = false;
                    } else {
                        EditTextEmptyHolder = true;
                    }
                }
                // Checking Email is already exists or not.
                public void CheckingEmailAlreadyExistsOrNot(){
                    // Opening SQLite database write permission.
                    sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
                    // Adding search email query to cursor.
                    cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.COL_3 + "=?", new String[]{EmailHolder}, null, null, null);
                    while (cursor.moveToNext()) {

                        if (cursor.isFirst()) {

                            cursor.moveToFirst();

                            // If Email is already exists then Result variable value set as Email Found.
                            F_Result = "Email Found";

                            // Closing cursor.
                            cursor.close();
                        }
                    }
                    // Calling method to check final result and insert data into SQLite database.
                    CheckFinalResult();
                }
                // Checking result
                public void CheckFinalResult () {
                    // Checking whether email is already exists or not.
                    if (F_Result.equalsIgnoreCase("Email Found")) {

                        // If email is exists then toast msg will display.
                        Toast.makeText(Registration.this, "Email Already Exists", Toast.LENGTH_LONG).show();

                    } else {

                        // If email already dose n't exists then user registration details will entered to SQLite database.
                        InsertDataIntoSQLiteDatabase();
                    }
                    F_Result = "Not_Found";
                    senddata();
                }
                public void senddata () {
                    if (EditTextEmptyHolder == true) {
                    String str1 =games.getSelectedItem().toString();
                    String str2 = editName.getText().toString();
                    Intent intent = new Intent(Registration.this, Registration2.class);
                    intent.putExtra("message1", str1);
                    intent.putExtra("message2", str2);
                        startActivity(intent);
                    }
                    else
                    {Toast.makeText(Registration.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();}
                }
            }

