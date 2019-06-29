package Logic.Entity.Library;

import Logic.Audio.Audio;
import Logic.Entity.Library.MetadataExtractorMachine.MetadataExtractorMachine;
import Logic.Entity.Song.Song;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidDataException, UnsupportedTagException, UnsupportedAudioFileException {
        final  File file = new File("C:\\Users\\Aryan\\Desktop\\1.mp3");
        Song song = new Song("hi", "hi", "hi", file);


    }
}
