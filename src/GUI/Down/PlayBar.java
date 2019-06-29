package GUI.Down;

import GUI.CustomProgressBar;

import javax.swing.*;
import java.awt.*;

public class PlayBar extends JPanel {
    private JLabel pastTime;
    private JLabel remainingTime;
    private CustomProgressBar progress;

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
