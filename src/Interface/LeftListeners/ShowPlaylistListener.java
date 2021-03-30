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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This listener is used for showing play lists.
 * @author Aryan
 * @version 1.0
 */
public class ShowPlaylistListener implements ActionListener {
    private Center center;
    private Down down;
    private PlayList playList;
    private Left left;
    private Library library;

    /**
     * Constructor.
     * @param playList
     * @param center
     * @param down
     * @param left
     * @param library
     */
    public ShowPlaylistListener(PlayList playList, Center center, Down down, Left left, Library library){
        this.center = center;
        this.down = down;
        this.playList = playList;
        this.left = left;
        this.library = library;
    }

    /**
     * Show songs.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        center.removeAll();
        int songsCounter = playList.getPlayListSongs().size();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(169, 169, 169));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton[] song = new CustomButton[songsCounter];
        int x = 0, y = 0;
        for(int i = 0; i < songsCounter; i++, x++){
            JPanel pane = new JPanel();
            JLabel songStats;
            pane.setLayout(new BorderLayout());
            song[i] = new CustomButton("");
            Icon buttonIcon = new ImageIcon(playList.getPlayListSongs().get(i).getTitle() + ".jpg");
            Image img = ((ImageIcon) buttonIcon).getImage();
            Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            song[i].setIcon(new ImageIcon(newImg));
            String labelString = playList.getPlayListSongs().get(i).getArtistName() + " : " + playList.getPlayListSongs().get(i).getTitle();
            songStats = new JLabel(labelString, SwingConstants.CENTER);
            if(songStats.getText().length() > 25){
                char[] chars = new char[25];
                for(int j = 0; j < 22; j++)
                    chars[j] = labelString.charAt(j);
                chars[22] = chars[23] = chars[24] = '.';
                labelString = String.copyValueOf(chars);
                songStats.setText(labelString);
            }
            songStats.setFont(new Font("Serif", Font.ITALIC, 15));
            songStats.setForeground(Color.WHITE);
            StartToPlayListener startToPlayListener = null;
            try {
                startToPlayListener = new StartToPlayListener(new Audio(playList.getPlayListSongs().get(i).getSongFile().getAbsolutePath()), (Down) down, playList.getPlayListSongs().get(i), (Left) left, library);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (JavaLayerException e1) {
                e1.printStackTrace();
            }
            song[i].addActionListener(startToPlayListener);
            if(x == 3){
                x = 0;
                y++;
            }
            gbc.gridx = x;
            gbc.gridy = y;
            pane.add(song[i], BorderLayout.PAGE_START);
            pane.add(songStats, BorderLayout.CENTER);
            pane.setBackground(new Color(169, 169, 169));
            panel.add(pane, gbc);
        }
        panel.setBackground(new Color(169, 169, 169));
        center.setBackground(new Color(169, 169, 169));
        center.add(panel);
        center.revalidate();
        center.repaint();
    }
}
