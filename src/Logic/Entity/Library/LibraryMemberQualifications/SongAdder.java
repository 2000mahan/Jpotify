package Logic.Entity.Library.LibraryMemberQualifications;

import Logic.Entity.Song.Song;

import java.util.ArrayList;
/**
 * Interface which is a requirement for being qualified at library which adds songs
 */
public interface SongAdder {
    public void addSong(ArrayList<Song> songs, Song song);
}
