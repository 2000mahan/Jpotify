package GUI.Left;

import GUI.Center.Center;
import GUI.CustomButton;
import GUI.CustomScrollBar;
import GUI.Down.Down;
import Interface.LeftListeners.ShowPlaylistListener;
import Logic.Entity.Library.Library;
import Logic.Entity.PlayList.PlayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This panel is used for showing play lists.
 * @author Aryan
 * @version 1.0
 */

public class PlayLists extends JPanel{
    private ArrayList<JButton> playlistButtons;
    private JLabel playlistLabel;
    private ArrayList<PlayList> playLists;
    private JPanel panel;
    private Library library;
    private Down down;
    private Center center;
    private Left left;

    /**
     * Constructor.
     * Panel has grid bag layout.
     * We have used custom scroll bar in this component.
     */
    public PlayLists(Center center, Left left, Down down, Library library){
        panel = new JPanel();
        this.left = left;
        this.down = down;
        this.library = library;
        this.center = center;
        panel.setBackground(Color.black);
        playLists = new ArrayList<>();
        playlistButtons = new ArrayList<>();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        playlistLabel = new JLabel("Playlist", SwingConstants.CENTER);
        playlistLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        add(playlistLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomScrollBar().makeUI(panel), gbc);
        playlistLabel.setBackground(Color.black);
        playlistLabel.setForeground(Color.WHITE);
        setBackground(Color.black);
    }

    public void addPlaylist(PlayList playList){
        playLists.add(playList);
        playlistButtons.add(new CustomButton(playLists.size() + ". " + playList.getPlayListName()));
        playlistButtons.get(playLists.size() - 1).setFont(new Font("Serif", Font.PLAIN, 15));
        playlistButtons.get(playLists.size() - 1).addActionListener(new ShowPlaylistListener(playList, center, down, left, library));
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for(int i = 0; i < playlistButtons.size(); i++){
            panel.add(playlistButtons.get(i));
        }
    }
}
