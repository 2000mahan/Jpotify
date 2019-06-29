package Logic.Entity;

import GUI.Left.Artwork;
import Logic.Entity.Library.Library;
import Logic.Entity.Song.Song;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
    private String albumName;
    private Artwork artwork;
    private ArrayList<Song> songs;

    public Album(Library library){
        songs = library.getSongs();
    }
}
