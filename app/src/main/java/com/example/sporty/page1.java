package com.example.sporty;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
public class page1 extends AppCompatActivity {
    ListView listView;
    TextView r,r1;
    String EmailHolder;
    String ranking;
    TextView emailid;
    Button shedule,view;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    String GetSQliteQuery;
    Cursor cursor;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        Button buttonOne = findViewById(R.id.button);
        Button profile=findViewById(R.id.button2);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openschedule();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openprofile();
            }
        });
        sqLiteHelper = new SQLiteHelper(this);

       // r = findViewById(R.id.ranking);
        shedule=findViewById(R.id.button2);
        emailid = findViewById(R.id.game);
//        openActivityregister();
        Intent intent = getIntent();
        EmailHolder = intent.getStringExtra(MainActivity.UserEmail);

        // Setting up received email to TextView.
        emailid.setText(EmailHolder);


       // String str4 = emailid.getText().toString();
       // Intent intent2 = new Intent(page1.this, page3.class);
        //intent2.putExtra("message2", str4);
                // Receiving User Email Send By MainActivity.

               //
            }



            public void openschedule() {
                String str3 = emailid.getText().toString();
               // Intent intent1 = new Intent(page1.this, page2.class);
                Intent intent = new Intent(this, page2.class);
                intent.putExtra("message1", str3);
                startActivity(intent);
            }
    public void openprofile() {
        String str3 = emailid.getText().toString();
        // Intent intent1 = new Intent(page1.this, page2.class);
        Intent intent = new Intent(this, page3.class);
        intent.putExtra("message1", str3);
        startActivity(intent);
    }
        }



