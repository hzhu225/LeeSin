package com.cms.leesin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

//A custom adapter for Music class
public class MusicAdapter extends ArrayAdapter<Music>
{
    public MusicAdapter(Context context, ArrayList<Music> resource)
    {
        super(context,0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Music currentMusic = getItem(position);

        if(currentMusic != null)
        {
            TextView musicNameTV = listItemView.findViewById(R.id.listItem_musicName);
            musicNameTV.setText(currentMusic.getMusicName());

            TextView artistNameTV = listItemView.findViewById(R.id.listItem_artistName);
            artistNameTV.setText(currentMusic.getArtistName());

            TextView lengthTV = listItemView.findViewById(R.id.listItem_length);
            int length = currentMusic.getLength();
            String minutes = String.format(Locale.getDefault(), "%02d", length / 60);
            String seconds = String.format(Locale.getDefault(), "%02d", length % 60);
            lengthTV.setText(minutes + ":" + seconds);
        }

        return listItemView;
    }
}
