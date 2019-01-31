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

        TextView musicNameTV = listItemView.findViewById(R.id.musicName_tv);
        musicNameTV.setText(currentMusic.getMusicName());

        TextView artistNameTV = listItemView.findViewById(R.id.artistName_tv);
        artistNameTV.setText(currentMusic.getArtistName());

        TextView yearTV = listItemView.findViewById(R.id.year_tv);
        yearTV.setText(currentMusic.getYear());

        return listItemView;
    }
}
