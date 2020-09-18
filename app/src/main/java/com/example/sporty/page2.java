package com.example.sporty;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.content.DialogInterface;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.widget.VideoView;

public class page2 extends AppCompatActivity {
    EditText time;
    TextView save;
    Button btn;
    String game, ra;
    String ra1 = "abc";
    String s_time, email;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        sqLiteHelper = new SQLiteHelper(this);
        save = (TextView) findViewById(R.id.textView1);
        time = (EditText) findViewById(R.id.edittime);
        btn = findViewById(R.id.button3);
        final Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner3);
        spin = (Spinner) findViewById(R.id.spinner3);
        Intent intent1 = getIntent();
        email = intent1.getStringExtra("message1");

        // Setting up received email to TextView.
        save.setText(email);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(page2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s_time = time.getText().toString();

                retrievedata();
                //gotoback();
            }
        });
    }
    public void gotoback () {
        Intent intent = new Intent(this, page1.class);
        startActivity(intent);
    }
    public void retrievedata() {
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
        //String EmailHolder = emailid.getText().toString();
        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.COL_10 + "=?", new String[]{time.getText().toString()}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                // Storing Password associated with entered email.

                game = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COL_9));
                ra = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COL_1));
                //while (ra==s_time)
                // {String s=cursor.getString(cursor.getColumnIndex(SQLiteHelper.COL_2));;
                // Closing cursor.
                cursor.close();

                // }
                //ranking=ra;
                if (game == spin.getSelectedItem().toString() && (ra != email)) {
                    Toast.makeText(page2.this, "Your practice session scheduled at  " + s_time + " with " + ra, Toast.LENGTH_LONG).show();

                }
                // retrievetime();
                else {
                    Toast.makeText(page2.this, "you will be  Informed about your schedule by coach  ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }
}

