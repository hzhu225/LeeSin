package com.cms.leesin;

public class Music
{
    private String mMusicName;
    private String mArtistName;
    private String mYear;

    public Music(String musicName, String artistName, String year)
    {
        mMusicName = musicName;
        mArtistName = artistName;
        mYear = year;
    }

    public String getMusicName()
    {
        return mMusicName;
    }

    public String getArtistName()
    {
        return mArtistName;
    }

    public String getYear()
    {
        return mYear;
    }
}
