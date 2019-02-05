package com.cms.leesin;

//A custom class which is used to store music info: Music Name, Artist Name and Length
public class Music
{
    private String mMusicName;
    private String mArtistName;
    private int mLength;

    public Music(String musicName, String artistName, int length)
    {
        mMusicName = musicName;
        mArtistName = artistName;
        mLength = length;                //length in second
    }

    public String getMusicName()
    {
        return mMusicName;
    }

    public String getArtistName()
    {
        return mArtistName;
    }

    public int getLength()
    {
        return mLength;
    }
}
