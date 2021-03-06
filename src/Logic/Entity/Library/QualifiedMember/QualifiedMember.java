package Logic.Entity.Library.QualifiedMember;
/**
 * QualifiedMember class simply works with the MetadataExtractorMachine
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
import Logic.Entity.Library.LibraryMemberQualifications.SongAdder;
import Logic.Entity.Library.LibraryMemberQualifications.SongCreator;
import Logic.Entity.Library.LibraryMemberQualifications.SongRemover;
import Logic.Entity.Library.MetadataExtractorMachine.MetadataExtractorMachine;
import Logic.Entity.Song.Song;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class QualifiedMember implements SongAdder, SongCreator, SongRemover{

    private String Member;
    private static MetadataExtractorMachine MyDataExtractor = new MetadataExtractorMachine();

    public QualifiedMember() {
        Member = "Qualified Member Of Library";
    }

    /**
     * adds song to library
     * @param songs from library and Song song
     */
    @Override
    public void addSong(ArrayList<Song> songs, Song song) {

     songs.add(song);
    }
    /**
     * creats song
     * @param songFile is a File
     * @return returns a song
     */
    @Override
    public Song songCreator(File songFile) throws IOException, InvalidDataException, UnsupportedTagException, UnsupportedAudioFileException {
     MyDataExtractor.startTheEngine(songFile);
     Song song = new Song(MyDataExtractor.getTitleData(),MyDataExtractor.getArtistNameData(), MyDataExtractor.getAlbumNameData(), songFile);
     return song;

    }
    /**
     * removes song from library
     * @param songs and  index of the song in the arraylist of songs
     */
    @Override
    public void removeSong(ArrayList<Song> songs, int index) {
        songs.remove(index);
    }


}
