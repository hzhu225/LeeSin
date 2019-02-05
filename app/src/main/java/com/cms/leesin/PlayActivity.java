package com.cms.leesin;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class PlayActivity extends AppCompatActivity
{
    private TextView lengthTV;
    private ImageButton playButton;
    private boolean isPlaying;
    private CountDownTimer timer;
    private int length;
    private int secondsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ConstraintLayout playLayout = findViewById(R.id.play_Layout);
        lengthTV = findViewById(R.id.length_TV);

        isPlaying = false;
        Music currentMusic;

        //get intent
        Intent intent = getIntent();
        String genres = intent.getStringExtra("genres");
        int position = intent.getIntExtra("position", -1);

        //get music name and artist name
        switch (genres)
        {
            case "classical":
                currentMusic = ClassicalActivity.musics_classical.get(position);
                playLayout.setBackgroundResource(R.color.colorClassicalLight);
                break;
            case "blues":
                currentMusic = BluesActivity.musics_blues.get(position);
                playLayout.setBackgroundResource(R.color.colorBluesLight);
                break;
            case "jazz":
                currentMusic = JazzActivity.musics_jazz.get(position);
                playLayout.setBackgroundResource(R.color.colorJazzLight);
                break;
            case "rock":
                currentMusic = RockActivity.musics_rock.get(position);
                playLayout.setBackgroundResource(R.color.colorRockLight);
                break;
            default:
                throw new IllegalArgumentException("Invalid genres");
        }

        TextView musicNameTV = findViewById(R.id.musicName_TV);
        musicNameTV.setText(currentMusic.getMusicName());
        TextView artistNameTV = findViewById(R.id.artistName_TV);
        artistNameTV.setText(currentMusic.getArtistName());

        //Add onClickListener to playButton
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(isPlaying)
                {
                    pausePlaying();
                }
                else
                {
                    startPlaying();
                }
            }
        });

        length = currentMusic.getLength();
        secondsLeft = length;                   //initial with full length of music
        updateLengthTV();
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


    public void startPlaying()
    {
        isPlaying = true;
        playButton.setImageResource(R.drawable.ic_pause);
        timer = new CountDownTimer(1000 * secondsLeft,1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                secondsLeft = (int) millisUntilFinished / 1000;
                updateLengthTV();
            }

            @Override
            public void onFinish()       //When music finishes, change secondLeft back to length
            {
                secondsLeft = length;
                updateLengthTV();
                pausePlaying();
            }

        }.start();
    }

    public void pausePlaying()
    {
        isPlaying = false;
        playButton.setImageResource(R.drawable.ic_play);
        timer.cancel();
    }

    //update length TextView
    public void updateLengthTV()
    {
        String minutes = String.format(Locale.getDefault(), "%02d", secondsLeft / 60);
        String seconds = String.format(Locale.getDefault(), "%02d", secondsLeft % 60);
        lengthTV.setText(minutes + ":" + seconds);
    }
}
