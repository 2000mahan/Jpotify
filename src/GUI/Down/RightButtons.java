package GUI.Down;

import GUI.CustomButton;
import GUI.CustomProgressBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This panel includes the sound progress bar and the lyrics button.
 * @author Aryan
 * @version 1.0
 */

public class RightButtons extends JPanel{
    private JButton lyricsButton;
    private JLabel soundLabel;
    private JProgressBar sound;

    /**
     * Constructor without parameters.
     * We used emoji's instead of images for the buttons.
     */
    public RightButtons(){
        super();
        setLayout(new FlowLayout());
        lyricsButton = new CustomButton("\uD83D\uDDC8");
        lyricsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        soundLabel = new JLabel("\uD83D\uDD69");
        soundLabel.setForeground(Color.WHITE);
        lyricsButton.setForeground(Color.WHITE);
        add(soundLabel);
        add(sound = new CustomProgressBar(new Dimension(80,5)));
        add(lyricsButton);
        setBackground(new Color(66, 66, 66));
    }

    public JButton getLyricsButton() {
        return lyricsButton;
    }

    public JProgressBar getSound() {
        return sound;
    }
}
