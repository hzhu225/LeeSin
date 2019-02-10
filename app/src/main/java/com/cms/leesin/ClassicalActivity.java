package com.cms.leesin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassicalActivity extends AppCompatActivity
{
    public static ArrayList<Music> musics_classical;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        //Create an ArrayList of Music objects
        musics_classical = new ArrayList<>();

        musics_classical.add(new Music("Eine Kleine Nachtmusik: Allegro", "Mozart", 256));
        musics_classical.add(new Music("Magic Flute: Queen Of The Night", "Mozart", 312));
        musics_classical.add(new Music("Moonlight Sonata", "Beethoven", 402));
        musics_classical.add(new Music("Für Elise", "Beethoven", 374));
        musics_classical.add(new Music("Toccata And Fugue In D Minor", "Bach", 246));
        musics_classical.add(new Music("Air On The G String", "Bach", 274));
        musics_classical.add(new Music("1812 Overture", "Tchaikovsky", 305));
        musics_classical.add(new Music("William Tell Overture", "Rossini", 332));
        musics_classical.add(new Music("Canon In D", "Pachelbel", 297));
        musics_classical.add(new Music("Blue Danube", "Strauss", 270));
        musics_classical.add(new Music("Messiah: Hallelujah Chorus", "Handel", 319));
        musics_classical.add(new Music("Over The Waves", "Rosas", 263));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics_classical);
        ListView listView = findViewById(R.id.music_ListView);
        listView.setBackgroundResource(R.color.colorClassicalLight);
        listView.setAdapter(musicAdapter);

        //Add onClickListener for each item in listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(ClassicalActivity.this, PlayActivity.class);
                intent.putExtra("genres", "classical");
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
