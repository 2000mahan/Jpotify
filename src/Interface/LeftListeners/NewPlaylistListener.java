package Interface.LeftListeners;

import GUI.Center.Center;
import GUI.CustomButton;
import GUI.Down.Down;
import GUI.Left.Left;
import Interface.Center.StartToPlayListener;
import Logic.Audio.Audio;
import Logic.Entity.Library.Library;
import Logic.Entity.PlayList.PlayList;
import Logic.Entity.Song.Song;
import javazoom.jl.decoder.JavaLayerException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 * Makes a playlist when clicked.
 * @author Aryan
 * @version 1.0
 */
public class NewPlaylistListener implements ActionListener {

    private Library library;
    private PlayList playList;
    private String name;
    private Center center;
    private Left left;
    private ArrayList<Song> songsToAdd;

    /**
     * Constructor
     *
     * @param library
     * @param center
     */
    public NewPlaylistListener(Library library, Center center, Left left) {
        this.library = library;
        this.center = center;
        this.left = left;
        songsToAdd = new ArrayList<>();
    }


    /**
     * Makes a play list.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        center.removeAll();
        center.revalidate();
        center.repaint();
        String playlistName = JOptionPane.showInputDialog("Enter A name for Playlist");
        if (playlistName != null) {
            playList = new PlayList(playlistName);
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Click create when you finished selecting your songs.");
            JButton create = new CustomButton("Create");
            JPanel panel = new JPanel();
            panel.setBackground(new Color(169, 169, 169));
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            ArrayList<Song> songs = library.getSongs();
            JButton[] buttons = new JButton[songs.size()];
            gbc.weightx = 1;
            gbc.weighty = 0.1;
            int x = 0, y = 0;
            JLabel songStats;
            HashMap<JButton, Song> flag = new HashMap<>();
            for (int i = 0; i < songs.size(); i++, x++) {
                JPanel pane = new JPanel();
                pane.setLayout(new BorderLayout());
                buttons[i] = new CustomButton("");
                Icon buttonIcon = new ImageIcon(songs.get(i).getTitle() + ".jpg");
                Image img = ((ImageIcon) buttonIcon).getImage();
                Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                buttons[i].setIcon(new ImageIcon(newImg));
                String labelString = songs.get(i).getArtistName() + " : " + library.getSongs().get(i).getTitle();
                songStats = new JLabel(labelString, SwingConstants.CENTER);
                if (songStats.getText().length() > 25) {
                    char[] chars = new char[25];
                    for (int j = 0; j < 22; j++)
                        chars[j] = labelString.charAt(j);
                    chars[22] = chars[23] = chars[24] = '.';
                    labelString = String.copyValueOf(chars);
                    songStats.setText(labelString);
                }
                songStats.setFont(new Font("Serif", Font.ITALIC, 15));
                songStats.setForeground(Color.WHITE);
                flag.put(buttons[i], songs.get(i));
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            songsToAdd.add(flag.get(e.getSource()));
                    }
                });
                if (x == 3) {
                    x = 0;
                    y++;
                }
                gbc.gridx = x;
                gbc.gridy = y;
                pane.add(buttons[i], BorderLayout.PAGE_START);
                pane.add(songStats, BorderLayout.CENTER);
                pane.setBackground(new Color(169, 169, 169));
                panel.add(pane, gbc);
                panel.setBackground(new Color(169, 169, 169));
            }
            center.add(create, BorderLayout.CENTER);
            center.add(panel, BorderLayout.NORTH);
            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playList.setPlayListSongs(songsToAdd);
                    left.getPlayLists().addPlaylist(playList);
                    playList.getPlayListSongs().size();
                    center.removeAll();
                    center.revalidate();
                    center.repaint();
                }
            });
            center.revalidate();
            center.repaint();

        }
    }
}