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
        setContentView(R.layout.music_list);

        //Create an ArrayList of Music objects
        musics_blues = new ArrayList<>();

        musics_blues.add(new Music("Stormy Monday", "T-Bone Walker", 251));
        musics_blues.add(new Music("Juke", "Little Walter", 287));
        musics_blues.add(new Music("Statesboro Blues", "Taj Mahal", 305));
        musics_blues.add(new Music("I'm a King Bee", "Slim Harpo", 246));
        musics_blues.add(new Music("Sweet Home Chicago", "Robert Johnson", 262));
        musics_blues.add(new Music("Five Long Years", "Eddie Boyd", 273));
        musics_blues.add(new Music("All Your Love", "Magic Sam", 225));
        musics_blues.add(new Music("Dust My Broom", "Elmore James", 234));
        musics_blues.add(new Music("The Sky Is Crying", "Elmore James", 306));
        musics_blues.add(new Music("It Hurts Me Too", "Elmore James", 294));
        musics_blues.add(new Music("On The Road Again", "Canned Heat", 213));
        musics_blues.add(new Music("The Same Thing", "Willie Dixon", 247));
        musics_blues.add(new Music("CC Rider", "Ma Rainey", 288));
        musics_blues.add(new Music("Hard Luck Blues", "Roy Brown", 253));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics_blues);
        ListView listView = findViewById(R.id.music_ListView);
        listView.setBackgroundResource(R.color.colorBluesLight);
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