package com.example.sporty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class page3 extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    String GetSQliteQuery;
    Button button;
    Cursor cursor;
    TextView mail,game,matches,won;
    String ranking,emailid;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        sqLiteHelper = new SQLiteHelper(this);
        button=findViewById(R.id.back);
        mail = findViewById(R.id.emailid);
        matches = findViewById(R.id.matches_play);
        won = findViewById(R.id.won_matches);
        game = findViewById(R.id.game);
        Intent intent = getIntent();
        emailid = intent.getStringExtra("message1");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openprofile();
            }
        });
        mail.setText(emailid);
        retrievedata();
        ranking();
    }
    public void retrievedata() {
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
        //String EmailHolder = emailid.getText().toString();
        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE__NAME2, null, " " + SQLiteHelper.COlumn_2 + "=?", new String[]{emailid}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                // Storing Password associated with entered email.
                String ra = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Column_7));
                String sport,match,win;
                sport=cursor.getString(cursor.getColumnIndex(SQLiteHelper.COlumn_6));
                match=cursor.getString(cursor.getColumnIndex(SQLiteHelper.COlumn_3));
                win=cursor.getString(cursor.getColumnIndex(SQLiteHelper.COlumn_4));

                // Closing cursor.
                cursor.close();
                ranking = ra;
                game.setText(sport);
                won.setText(win);
                matches.setText(match);
            }
            // Calling method to check final result ..
            else {
                //If any of login EditText empty then this block will be executed.
                Toast.makeText(page3.this, "Exception Error", Toast.LENGTH_LONG).show();

            }
        }
    }
    public void ranking() {
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar2);
        double r = 2.5;
        double p = Double.parseDouble(ranking);
        //p=70.0;
        if (p >= 90) {
            r = 5.0;
        }
        if (p == 80 || p == 81 || p == 82 || p == 83 || p == 84 || p == 85 || p == 86 || p == 87 || p == 88 || p == 89) {
            r = 4.5;
            simpleRatingBar.setRating((float) r);
        } else if (p == 75 || p == 76 || p == 77 || p == 78 || p == 79) {
            r = 4;
            simpleRatingBar.setRating((float) r);
        } else if (p == 70 || p == 71 || p == 72 || p == 73 || p == 74) {
            r = 3.5;
            simpleRatingBar.setRating((float) r);
        } else if (p == 65 || p == 66 || p == 67 || p == 68 || p == 69) {
            r = 3;
            simpleRatingBar.setRating((float) r);
        } else if (p == 60 || p == 61 || p == 62 || p == 63 || p == 64) {
            r = 2.75;
            simpleRatingBar.setRating((float) r);
        } else if (p == 50 || p == 51 || p == 52 || p == 53 || p == 54 || p == 55 || p == 56 || p == 57 || p == 58 || p == 59) {
            r = 2.5;
            simpleRatingBar.setRating((float) r);
        } else if (p == 40 || p == 41 || p == 42 || p == 43 || p == 44 || p == 45 || p == 46 || p == 47 || p == 48 || p == 49) {
            r = 2;
            simpleRatingBar.setRating((float) r);
        } else if (p == 30 || p == 31 || p == 32 || p == 33 || p == 34 || p == 35 || p == 36 || p == 37 || p == 38 || p == 39) {
            r = 1.5;
            simpleRatingBar.setRating((float) r);
        } else {
            r = 1.0;
            simpleRatingBar.setRating((float) r);
        }
    }
    public void openprofile() {

        // Intent intent1 = new Intent(page1.this, page2.class);
        Intent intent = new Intent(this, page1.class);

        startActivity(intent);
    }}


