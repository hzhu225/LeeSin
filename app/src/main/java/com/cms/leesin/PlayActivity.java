package com.cms.leesin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity
{
    private boolean playing;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        playing = true;
        Music currentMusic;

        Intent intent = getIntent();
        String genres = intent.getStringExtra("genres");
        int position = intent.getIntExtra("position", -1);

        if(genres.equals("classical"))
        {
            currentMusic = ClassicalActivity.musics_classical.get(position);
        }
        else
        {
            currentMusic = BluesActivity.musics_blues.get(position);
        }

        TextView musicNameTV = findViewById(R.id.musicName_TV);
        musicNameTV.setText(currentMusic.getMusicName());
        TextView artistNameTV = findViewById(R.id.artistName_TV);
        artistNameTV.setText(currentMusic.getArtistName());
        TextView lengthTV = findViewById(R.id.length_TV);
        lengthTV.setText(currentMusic.getLength());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);      //return to parent activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void playButtonClick(View view)
    {
        ImageButton playButton = (ImageButton) view;
        if(playing)
        {
            playButton.setImageResource(R.drawable.ic_pause);
            playing = false;
        }
        else
        {
            playButton.setImageResource(R.drawable.ic_play);
            playing = true;
        }
    }
}
