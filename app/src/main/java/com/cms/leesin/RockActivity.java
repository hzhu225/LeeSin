package com.cms.leesin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RockActivity extends AppCompatActivity
{
    
    public static ArrayList<Music> musics_rock;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        //Create an ArrayList of Music objects
        musics_rock = new ArrayList<>();

        musics_rock.add(new Music("Waly This Way", "Aerosmith", 201));
        musics_rock.add(new Music("Born To Be Wild", "Steppenwolf", 302));
        musics_rock.add(new Music("Enter Sandman", "Metallica", 242));
        musics_rock.add(new Music("A Day in the Life", "The Beatles", 291));
        musics_rock.add(new Music("Hey Jude", "The Beatles", 259));
        musics_rock.add(new Music("Smoke On The Water", "Deep Purple", 245));
        musics_rock.add(new Music("Just the Way You Are", "Billy Joel", 270));
        musics_rock.add(new Music("Rock and Roll All Nite", "Kiss", 310));
        musics_rock.add(new Music("Fame", "David Bowie", 227));
        musics_rock.add(new Music("What'd I Say", "Ray Charles", 283));
        musics_rock.add(new Music("Eight Miles High", "The Byrds", 247));
        musics_rock.add(new Music("The Tracks of My Tears", "The Miracles", 316));
        musics_rock.add(new Music("Omaha", "Moby Grape", 214));
        musics_rock.add(new Music("Get Up Stand Up", "The Wailers", 243));

        MusicAdapter musicAdapter = new MusicAdapter(this, musics_rock);
        ListView listView = findViewById(R.id.music_ListView);
        listView.setBackgroundResource(R.color.colorRockLight);
        listView.setAdapter(musicAdapter);

        //Add onClickListener for each item in listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(RockActivity.this, PlayActivity.class);
                intent.putExtra("genres", "rock");
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}