package GUI.Left;

import GUI.CustomScrollBar;

import javax.swing.*;
import java.awt.*;

public class PlayLists extends JPanel{
    private JTextArea area;
    private JLabel playlistLabel;

    public PlayLists(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        playlistLabel = new JLabel("Playlist", SwingConstants.CENTER);
        playlistLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        area = new JTextArea(5, 10);
        area.setBackground(Color.black);
        area.setForeground(Color.WHITE);
        add(playlistLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomScrollBar().createScrollPanel(area), gbc);

        playlistLabel.setBackground(Color.black);
        playlistLabel.setForeground(Color.WHITE);
        setBackground(Color.black);
    }
}
