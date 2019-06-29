package Interface.DownListeners;

import GUI.Down.Down;
import GUI.Left.Left;
import Interface.Center.StartToPlayListener;
import Logic.Audio.Audio;
import Logic.Entity.Library.Library;
import Logic.Entity.Song.Song;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class PreviousSongListener implements ActionListener {

    private Library library;
    private Left left;
    private Down down;
    private Song song;
    private Audio audio;

    public PreviousSongListener(Library library, Song song, Left left, Down down, Audio audio){
        this.audio = audio;
        this.down = down;
        this.left = left;
        this.library = library;
        this.song = song;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Song songToPlay;
        int i = 0;
        for(Song song : library.getSongs()){
            if(this.song.equals(song))
                break;
            i++;
        }
        System.out.println(i);
        if(--i >= 0){
            this.audio.kill();
            songToPlay = library.getSongs().get(i);
            Audio audio = null;
            try {
                audio = new Audio(songToPlay.getSongFile().getAbsolutePath());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (JavaLayerException e1) {
                e1.printStackTrace();
            }
            try {
                Thread.sleep(500);
            }catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            Thread t = new Thread(audio);
            for( ActionListener al : down.getPlayButtons().getPlayPauseButton().getActionListeners() ) {
                down.getPlayButtons().getPlayPauseButton().removeActionListener( al );
            }
            for( ActionListener al : down.getPlayButtons().getNextButton().getActionListeners() ) {
                down.getPlayButtons().getNextButton().removeActionListener( al );
            }
            for( ActionListener al : down.getPlayButtons().getPreviousButton().getActionListeners() ) {
                down.getPlayButtons().getPreviousButton().removeActionListener( al );
            }
            down.getPlayButtons().getPlayPauseButton().addActionListener(new PlayAndPauseListener(audio, down.getPlayButtons().getPlayPauseButton()));
            down.getPlayButtons().getNextButton().addActionListener(new NextSongListener(library, songToPlay, left, down, audio));
            down.getPlayButtons().getPreviousButton().addActionListener(new PreviousSongListener(library, songToPlay, left, down, audio));
            down.getLeftPart().getSongAlbum().setText(songToPlay.getAlbumName());
            down.getLeftPart().getSongTitleArtist().setText(songToPlay.getArtistName() + " : " + songToPlay.getTitle());
            down.getLeftPart().validate();
            down.getPlayButtons().getPlayPauseButton().setText("\u23F8");
            Icon buttonIcon = new ImageIcon(songToPlay.getTitle() + ".jpg");
            Image img = ((ImageIcon) buttonIcon).getImage();
            Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            left.getArtwork().getArtworkLabel().setIcon(new ImageIcon(newImg));
            left.getArtwork().validate();
            t.start();
        }

    }
}