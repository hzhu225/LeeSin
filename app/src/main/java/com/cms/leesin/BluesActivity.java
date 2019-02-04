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

        musics_blues = new ArrayList<>();

        musics_blues.add(new Music("Eine Kleine Nachtmusik: Allegro", "Mozart", "04:38"));
        musics_blues.add(new Music("Magic Flute: Queen Of The Night", "Mozart", "06:52"));
        musics_blues.add(new Music("Moonlight Sonata", "Beethoven", "07:15"));
        musics_blues.add(new Music("Für Elise", "Beethoven", "06:16"));
        musics_blues.add(new Music("Toccata And Fugue In D Minor", "Bach", "09:12"));
        musics_blues.add(new Music("Air On The G String", "Bach", "04:23"));
        musics_blues.add(new Music("1812123 Overture", "Tchaikovsky", "07:19"));
        musics_blues.add(new Music("William Tell Overture", "Rossini", "05:48"));
        musics_blues.add(new Music("Canon In D", "Pachelbel", "04:17"));
        musics_blues.add(new Music("Blue Danube", "Strauss", "06:07"));
        musics_blues.add(new Music("Messiah: Hallelujah Chorus", "Handel", "05:38"));
        musics_blues.add(new Music("Over The Waves", "Rosas", "04:10"));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics_blues);
        final ListView listView = findViewById(R.id.blues_ListView);
        listView.setAdapter(musicAdapter);
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