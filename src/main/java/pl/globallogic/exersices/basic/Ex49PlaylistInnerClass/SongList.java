package pl.globallogic.exersices.basic.Ex49PlaylistInnerClass;

import java.util.ArrayList;

public class SongList {
    private ArrayList<Song> songs;

    public SongList() {
        this.songs = new ArrayList<>();
    }

    public boolean add(Song song) {
        if (!songs.contains(song)) {
            songs.add(song);
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

    public Song findSong(int trackNumber) {
        if (trackNumber >= 1 && trackNumber <= songs.size()) {
            return songs.get(trackNumber - 1);
        }
        return null;
    }
}
