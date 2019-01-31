package com.cms.leesin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassicalActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classical);

        ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Eine Kleine Nachtmusik: Allegro", "Mozart", "1787"));
        musics.add(new Music("Magic Flute: Queen Of The Night", "Mozart", "1791"));
        musics.add(new Music("Moonlight Sonata", "Beethoven", "1801"));
        musics.add(new Music("Für Elise", "Beethoven", "1810"));
        musics.add(new Music("Toccata And Fugue In D Minor", "Bach", "1707"));
        musics.add(new Music("Air On The G String", "Bach", "1723"));
        musics.add(new Music("1812 Overture", "Tchaikovsky", "1880"));
        musics.add(new Music("William Tell Overture", "Rossini", "1829"));
        musics.add(new Music("Canon In D", "Pachelbel", "1694"));
        musics.add(new Music("Blue Danube", "Strauss", "1866"));
        musics.add(new Music("Messiah: Hallelujah Chorus", "Handel", "1741"));
        musics.add(new Music("Over The Waves", "Rosas", "1884"));


        MusicAdapter musicAdapter = new MusicAdapter(this, musics);
        ListView listView = findViewById(R.id.classical_ListView);
        listView.setAdapter(musicAdapter);
    }
}
