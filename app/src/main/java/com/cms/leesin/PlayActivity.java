package com.cms.leesin;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity
{
    private boolean playing;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        playing = true;
        Intent intent = getIntent();
        String call = getCallingActivity().getClassName();
        int position = intent.getIntExtra("music", 0);
        Music current = ClassicalActivity.musics_classical.get(position);
        Toast.makeText(getApplicationContext(), call,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
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
