package GUI.Left;

import GUI.Center.Center;
import GUI.CustomButton;
import GUI.Down.Down;
import Interface.LeftListeners.AddSongToLibraryListener;
import Interface.LeftListeners.ShowAlbumsListener;
import Interface.LeftListeners.SongsListener;
import Logic.Entity.Library.Library;
import Logic.Save;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

/**
 * This panel contains the left buttons.
 * @author Aryan
 * @version 1.0
 */
public class Icons extends JPanel {
    private JButton recentlyPlayed;
    private JButton songs;
    private JButton album;
    private JButton library;
    private JButton addPlaylist;
    private Save  librarySave;
    private static final Font FONT = new Font("Serif", Font.PLAIN, 15);

    /**
     * Constructor.
     * @param center
     * @param down
     * @param left
     * @throws FileNotFoundException
     * @throws JavaLayerException
     */
    public Icons(Center center, Down down, Left left) throws FileNotFoundException, JavaLayerException {
        library = new CustomButton("\u2795" + " Library");
        library.setFont(FONT);
        librarySave = new Save();
        Library lib;
        if(this.librarySave.load() != null)
            lib = this.librarySave.load();
        else
            lib = new Library();
        library.addActionListener(new AddSongToLibraryListener(lib, librarySave));
        album = new CustomButton("\uD83D\uDCD6" + "Album");
        album.setFont(FONT);
        album.addActionListener(new ShowAlbumsListener(center, lib));
        recentlyPlayed = new CustomButton("\uD83D\uDD60" + " Recently Played");
        recentlyPlayed.setFont(FONT);
        songs = new CustomButton("\uD83C\uDFB6"+ " Songs");
        songs.setFont(FONT);
        songs.addActionListener(new SongsListener(lib, center, down, left));
        addPlaylist = new CustomButton("\u2795" + " Playlist");
        addPlaylist.setFont(FONT);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(library, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(addPlaylist, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(recentlyPlayed, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(album, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(songs, gbc);
        setBackground(Color.black);
    }
}
