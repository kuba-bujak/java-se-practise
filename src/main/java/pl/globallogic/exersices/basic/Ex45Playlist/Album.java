package pl.globallogic.exersices.basic.Ex45Playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name, artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> album) {
        if (trackNumber > 0 && trackNumber <= songs.size()) {
            album.add(songs.get(trackNumber - 1));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> album) {
        Song song = findSong(title);
        if (song != null) {
            album.add(song);
            return true;
        }
        return false;
    }
}
