package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 /*Songs album*/
public class Album
{

    private String name;
    private String artist;
    private List<Song> songs=new ArrayList<>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;

    }

    public boolean addSong(String title, double duration)
    {
        if(findSong(title)== null)
        {
            this.songs.add(new Song(title,duration));
            return true;
        }

        return false;
    }

    private Song findSong(String title)
    {
        for (Song checkedSong: this.songs)
        {
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }

        return null;
    }

   public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
   {
       int index=trackNumber-1;
       if((index>=0) && (index<this.songs.size()))
       {
           playList.add(this.songs.get(index));
           return true;
       }
   System.out.println("This album does not have a track number"+index);
       return false;
   }
    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
        Song checkSong=findSong(title);
        if(checkSong!=null)
        {
            playList.add(checkSong);
            return true;
        }

        System.out.println("This song "+title+" is not in this album.");
        return false;
    }
}
