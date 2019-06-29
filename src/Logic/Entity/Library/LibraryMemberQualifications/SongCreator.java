package Logic.Entity.Library.LibraryMemberQualifications;

import Logic.Entity.Song.Song;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public interface SongCreator {
    public Song songCreator(File songFile) throws IOException, InvalidDataException, UnsupportedTagException, UnsupportedAudioFileException;
}
