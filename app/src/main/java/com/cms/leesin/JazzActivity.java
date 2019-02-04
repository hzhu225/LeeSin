package com.cms.leesin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class JazzActivity extends AppCompatActivity
{
    public static ArrayList<Music> musics_jazz;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jazz);

        //Create an ArrayList of Music objects
        musics_jazz = new ArrayList<>();

        musics_jazz.add(new Music("Take Five", "Dave Brubeck", "04:38"));
        musics_jazz.add(new Music("Round Midnight", "Thelonious Monk", "06:52"));
        musics_jazz.add(new Music("My Favorite Things", "John Coltrane", "07:15"));
        musics_jazz.add(new Music("Strange Fruit", "Billie Holiday", "06:16"));
        musics_jazz.add(new Music("Goodbye Pork Pie Hat", "Charles Mingus", "09:12"));
        musics_jazz.add(new Music("Stolen Moments", "Oliver Nelson", "04:23"));
        musics_jazz.add(new Music("My Funny Valentine", "Chet Baker", "07:19"));
        musics_jazz.add(new Music("Song For My Father", "Horace Silver", "05:48"));
        musics_jazz.add(new Music("Waltz For Debby", "Bill Evans", "04:17"));
        musics_jazz.add(new Music("Poinciana", "Ahmad Jamal", "06:07"));
        musics_jazz.add(new Music("Summertime", "Ella Fitzgerald", "05:38"));


        MusicAdapter musicAdapter = new MusicAdapter(this, musics_jazz);
        final ListView listView = findViewById(R.id.jazz_ListView);
        listView.setAdapter(musicAdapter);

        //Add onClickListener for each item in listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(JazzActivity.this, PlayActivity.class);
                intent.putExtra("genres", "jazz");
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
