package pl.globallogic.exersices.basic.Ex49PlaylistInnerClass;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name, artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public void addSong(String title, double duration) {
        songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> album) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
            album.add(song);
            return true;
        }
        System.out.printf("This album does not have a track %s \n", trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> album) {
        Song song = songs.findSong(title);
        if (song != null) {
            album.add(song);
            return true;
        }
        System.out.printf("The song %s is not in this album \n", title);
        return false;
    }
}
