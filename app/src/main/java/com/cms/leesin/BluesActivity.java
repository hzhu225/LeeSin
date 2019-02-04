package com.cms.leesin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BluesActivity extends AppCompatActivity
{
    public static ArrayList<Music> musics_blues;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blues);

        //Create an ArrayList of Music objects
        musics_blues = new ArrayList<>();

        musics_blues.add(new Music("Stormy Monday", "T-Bone Walker", "04:16"));
        musics_blues.add(new Music("Juke", "Little Walter", "04:23"));
        musics_blues.add(new Music("Statesboro Blues", "Taj Mahal", "04:32"));
        musics_blues.add(new Music("I'm a King Bee", "Slim Harpo", "05:02"));
        musics_blues.add(new Music("Sweet Home Chicago", "Robert Johnson", "04:19"));
        musics_blues.add(new Music("Five Long Years", "Eddie Boyd", "03:42"));
        musics_blues.add(new Music("All Your Love", "Magic Sam", "04:10"));
        musics_blues.add(new Music("Dust My Broom", "Elmore James", "03:58"));
        musics_blues.add(new Music("The Sky Is Crying", "Elmore James", "04:25"));
        musics_blues.add(new Music("It Hurts Me Too", "Elmore James", "05:12"));
        musics_blues.add(new Music("On The Road Again", "Canned Heat", "04:29"));
        musics_blues.add(new Music("The Same Thing", "Willie Dixon", "04:42"));
        musics_blues.add(new Music("CC Rider", "Ma Rainey", "03:42"));
        musics_blues.add(new Music("Hard Luck Blues", "Roy Brown", "04:42"));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics_blues);
        final ListView listView = findViewById(R.id.blues_ListView);
        listView.setAdapter(musicAdapter);

        //Add onClickListener for each item in listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(BluesActivity.this, PlayActivity.class);
                intent.putExtra("genres", "blues");
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}