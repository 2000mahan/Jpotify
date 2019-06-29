package Logic.Entity.Library.LibraryMemberQualifications;

import Logic.Entity.Song.Song;

import java.util.ArrayList;
/**
 * Interface which is a requirement for being qualified at library which removes songs
 */
public interface SongRemover {
    public void removeSong(ArrayList<Song> songs, int index);
}
