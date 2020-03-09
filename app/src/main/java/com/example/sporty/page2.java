package com.example.sporty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.widget.Toast;
import android.app.Activity;
import android.widget.VideoView;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        ListView listView=(ListView)findViewById(R.id.list_view2);
        final ArrayList<String> arrayList=new ArrayList<>();
//Add elements to arraylist
        arrayList.add("Cricket");
        arrayList.add("Badminton");
        arrayList.add("Table Tennis");
        arrayList.add("Basket Ball");
        arrayList.add("Volley Ball");
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
//assign adapter to listview
        listView.setAdapter(arrayAdapter);
        //Video
        //VideoView videoView = findViewById(R.id.video_view);
        //String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.vidio
        //Url uri = Uri.parse(videoPath);
        //videoView.setVideoURI(uri);

        //MediaController mediaController = new MediaController(this);
        //videoView.setMediaController(mediaController);
        //mediaController.setAnchorView(videoView);
    }
}
