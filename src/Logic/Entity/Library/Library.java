package Logic.Entity.Library;

import Logic.Entity.Library.QualifiedMember.QualifiedMember;
import Logic.Entity.Song.Song;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private ArrayList<File> songFile;
    private ArrayList<Song> songs;
    private static QualifiedMember libraryMember = new QualifiedMember();

    public Library(){
         this.songFile = new ArrayList<File>();
         this.songs = new ArrayList<Song>();

    }

    public void addSongToLibrary(String path) throws IOException, InvalidDataException, UnsupportedTagException, UnsupportedAudioFileException {

        libraryMember.addSong(songs, libraryMember.songCreator(new File(path)));
    }

    public ArrayList<File> getSongAddress() {
        return songFile;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongFile(ArrayList<File> songFile) {
        this.songFile = songFile;
    }
}
