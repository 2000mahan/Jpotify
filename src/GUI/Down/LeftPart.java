package GUI.Down;

import GUI.Left.Artwork;

import javax.swing.*;
import java.awt.*;

/**
 * This part is the left part of the bottom panel of the main window.
 * @author Aryan
 * @version 1.0
 */

public class LeftPart extends JPanel {
    private JLabel songTitleArtist;
    private JLabel songAlbum;
    private final static Color COLOR = new Color(66, 66, 66);

    /**
     * This is the class's constructor.
     * It had a grid bag layout.
     */
    public LeftPart(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        songTitleArtist = new JLabel("", SwingConstants.CENTER);
        songAlbum = new JLabel("", SwingConstants.CENTER);
        songTitleArtist.setForeground(Color.WHITE);
        songAlbum.setForeground(Color.WHITE);
        songAlbum.setFont(new Font("Serif", Font.PLAIN, 10));
        songTitleArtist.setFont(new Font("Serif", Font.PLAIN, 15));
        songTitleArtist.setBackground(COLOR);
        songAlbum.setBackground(COLOR);
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(songTitleArtist, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(songAlbum, gbc);
        setBackground(COLOR);
    }

    public JLabel getSongAlbum() {
        return songAlbum;
    }

    public JLabel getSongTitleArtist() {
        return songTitleArtist;
    }
}
