package GUI.Down;

import GUI.CustomButton;
import Interface.DownListeners.PlayAndPauseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This is the panel of buttons used for playing songs.
 * @author Aryan
 * @version 1.0
 */
public class PlayButtons extends JPanel{
    private JButton shuffleButton;
    private JButton previousButton;
    private JButton playPauseButton;
    private JButton nextButton;
    private JButton repeatButton;
    private JButton likeButton;
    private final static Color COLOR = new Color(66, 66, 66);

    /**
     * We have used emoji's instead of image's for the icons.
     * Constructor without parameters.
     */
    public PlayButtons(){
        super();
        setLayout(new FlowLayout());
        shuffleButton = new CustomButton("\uD83D\uDD00");
        previousButton = new CustomButton("\u23EE");
        playPauseButton = new CustomButton("\u23F8");
        nextButton = new CustomButton("\u23ED");
        repeatButton = new CustomButton("\uD83D\uDD01");
        likeButton = new CustomButton("\u2764");
        setBackground(COLOR);
        shuffleButton.setBackground(COLOR);
        previousButton.setBackground(COLOR);
        playPauseButton.setBackground(COLOR);
        nextButton.setBackground(COLOR);
        repeatButton.setBackground(COLOR);
        likeButton.setBackground(COLOR);
        add(likeButton);
        add(shuffleButton);
        add(previousButton);
        add(playPauseButton);
        add(nextButton);
        add(repeatButton);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPlayPauseButton() {
        return playPauseButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getShuffleButton() {
        return shuffleButton;
    }

    public JButton getRepeatButton() {
        return repeatButton;
    }

    public JButton getLikeButton() {
        return likeButton;
    }
}
