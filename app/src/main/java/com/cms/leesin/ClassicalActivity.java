package com.cms.leesin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassicalActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical);

        ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Eine Kleine Nachtmusik: Allegro", "Mozart", "04:38"));
        musics.add(new Music("Magic Flute: Queen Of The Night", "Mozart", "06:52"));
        musics.add(new Music("Moonlight Sonata", "Beethoven", "07:15"));
        musics.add(new Music("Für Elise", "Beethoven", "06:16"));
        musics.add(new Music("Toccata And Fugue In D Minor", "Bach", "09:12"));
        musics.add(new Music("Air On The G String", "Bach", "04:23"));
        musics.add(new Music("1812 Overture", "Tchaikovsky", "07:19"));
        musics.add(new Music("William Tell Overture", "Rossini", "05:48"));
        musics.add(new Music("Canon In D", "Pachelbel", "04:17"));
        musics.add(new Music("Blue Danube", "Strauss", "06:07"));
        musics.add(new Music("Messiah: Hallelujah Chorus", "Handel", "05:38"));
        musics.add(new Music("Over The Waves", "Rosas", "04:10"));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics);
        final ListView listView = findViewById(R.id.classical_ListView);
        listView.setAdapter(musicAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //Music music_clicked = (Music) parent.getSelectedItem();
                Toast.makeText(getApplicationContext(), Integer.toString(position),Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(this, )
            }
        });
    }




}
