package com.example.sporty;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
public class page1 extends AppCompatActivity {
    ListView listView;
    TextView r;
    int p;
    Button shedule;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    String GetSQliteQuery;
    Cursor cursor;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        r = findViewById(R.id.ranking);
        //openActivityregister();
        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        Intent intent = getIntent();
        //String str = intent.getStringExtra("message1");
        String str1 = intent.getStringExtra("message1");
        p=Integer.parseInt(str1);
       // simpleRatingBar.setNumStars(4);
        double r=2.5;
        //p=70.0;
        if(p>=90)
        {r=5.0;}
        if (p==80||p==81||p==82||p==83||p==84||p==85||p==86||p==87||p==88||p==89){r=4.5;
            simpleRatingBar.setRating((float)r);}
        else if(p==75||p==76||p==77||p==78||p==79){r=4;
            simpleRatingBar.setRating((float)r);}
        else if(p==70||p==71||p==72||p==73||p==74){r=3.5;
            simpleRatingBar.setRating((float)r);}
        else if(p==65||p==66||p==67||p==68||p==69){r=3;
            simpleRatingBar.setRating((float)r);}
        else if(p==60||p==61||p==62||p==63||p==64){r=2.75;
            simpleRatingBar.setRating((float)r);}
        else if(p==50||p==51||p==52||p==53||p==54||p==55||p==56||p==57||p==58||p==59){r=2.5;
            simpleRatingBar.setRating((float)r);}
        else if(p==40||p==41||p==42||p==43||p==44||p==45||p==46||p==47||p==48||p==49){r=2;
            simpleRatingBar.setRating((float)r);}
        else if(p==30||p==31||p==32||p==33||p==34||p==35||p==36||p==37||p==38||p==39){r=1.5;
            simpleRatingBar.setRating((float)r);}
        else
        {r=1.0;
        simpleRatingBar.setRating((float)r);}
    }
    public void openActivityregister() {
        Intent intent = new Intent(this, page2.class);
        startActivity(intent);
    }

    }



