package Interface.Center;

import GUI.Down.Down;
import GUI.Left.Left;
import Interface.DownListeners.NextSongListener;
import Interface.DownListeners.PlayAndPauseListener;
import Interface.DownListeners.PreviousSongListener;
import Logic.Audio.Audio;
import Logic.Entity.Library.Library;
import Logic.Entity.Song.Song;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * This listener makes the songs the ability for playing.
 * @author Aryan
 * @version 1.0
 */
public class StartToPlayListener implements ActionListener {

   private Audio audio;
   private Down down;
   private Song song;
   private Left left;
   private Library library;

    /**
     * Constructor.
     * @param audio
     * @param down
     * @param song
     * @param left
     * @param library
     */
   public StartToPlayListener(Audio audio, Down down, Song song, Left left, Library library){
       this.audio = audio;
       this.down = down;
       this.song = song;
       this.left = left;
       this.library = library;
   }

    /**
     * Do actions when song button clicked.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread startPlaying = new Thread(this.audio);
        startPlaying.start();
        down.getPlayButtons().getPlayPauseButton().addActionListener(new PlayAndPauseListener(audio, down.getPlayButtons().getPlayPauseButton()));
        down.getPlayButtons().getNextButton().addActionListener(new NextSongListener(library, song, left, down, this.audio));
        down.getPlayButtons().getPreviousButton().addActionListener(new PreviousSongListener(library, song, left, down, this.audio));
        down.getLeftPart().getSongAlbum().setText(song.getAlbumName());
        down.getLeftPart().getSongTitleArtist().setText(song.getArtistName() + " : " + song.getTitle());
        down.getLeftPart().validate();
        Icon buttonIcon = new ImageIcon(song.getTitle() + ".jpg");
        Image img = ((ImageIcon) buttonIcon).getImage();
        Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        left.getArtwork().getArtworkLabel().setIcon(new ImageIcon(newImg));
        left.getArtwork().validate();
    }
}
