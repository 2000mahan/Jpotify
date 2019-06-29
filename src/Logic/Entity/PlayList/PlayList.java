package Logic.Entity.PlayList;

import Logic.Entity.Song.Song;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayList implements Serializable {
    private String playListName;
    private ArrayList<Song> playListSongs;

    public PlayList(String playListName) {
        this.playListName = playListName;
        ArrayList<Song> playListSongs = new ArrayList<Song>();
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListSongs(ArrayList<Song> playListSongs) {
        this.playListSongs = playListSongs;
    }

    public ArrayList<Song> getPlayListSongs() {
        return playListSongs;
    }

}

