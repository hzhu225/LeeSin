package com.cms.leesin;

public class Music
{
    private String mMusicName;
    private String mArtistName;
    private String mLength;

    public Music(String musicName, String artistName, String length)
    {
        mMusicName = musicName;
        mArtistName = artistName;
        mLength = length;
    }

    public String getMusicName()
    {
        return mMusicName;
    }

    public String getArtistName()
    {
        return mArtistName;
    }

    public String getLength()
    {
        return mLength;
    }
}
