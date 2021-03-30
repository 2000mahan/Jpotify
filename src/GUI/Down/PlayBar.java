package GUI.Down;

import GUI.CustomProgressBar;

import javax.swing.*;
import java.awt.*;

/**
 * This class is the bottom part of the main window's lowest part.
 * It has a progress bar to indicate the duration of the playing song.
 * @author Aryan
 * @version 1.0
 */

public class PlayBar extends JPanel {
    private JLabel pastTime;
    private JLabel remainingTime;
    private CustomProgressBar progress;

    /**
     * The class's constructor.
     * With a flow layout.
     */
    public PlayBar(){
        super();
        setLayout(new FlowLayout());
        add(pastTime = new JLabel("00:00"));
        pastTime.setFont(new Font("DialogInput", Font.PLAIN, 10));
        pastTime.setForeground(Color.WHITE);
        add(progress = new CustomProgressBar(new Dimension(500, 5)));
        add(remainingTime = new JLabel("02:00"));
        remainingTime.setFont(new Font("DialogInput", Font.PLAIN, 10));
        remainingTime.setForeground(Color.WHITE);
        setBackground(new Color(66, 66, 66));
    }

    public JLabel getPastTime() {
        return pastTime;
    }

    public JLabel getRemainingTime() {
        return remainingTime;
    }

    public CustomProgressBar getProgress() {
        return progress;
    }
}
