package Interface.LeftListeners;

import GUI.Center.Center;
import GUI.CustomButton;
import GUI.CustomScrollBar;
import GUI.Down.Down;
import GUI.Left.Left;
import Interface.Center.StartToPlayListener;
import Logic.Audio.Audio;
import Logic.Entity.Library.Library;
import Logic.Entity.Song.Song;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This listener show the songs to play.
 * @author Aryan
 * @version 1.0
 */
public class SongsListener implements ActionListener {
    private Library library;
    private JPanel center;
    private JPanel down;
    private JPanel left;
    private JButton[] songs;

    /**
     * Constructor.
     * @param library
     * @param center
     * @param down
     * @param left
     */
    public SongsListener(Library library, Center center, Down down, Left left){
        this.library = library;
        this.center = center;
        this.down = down;
        this.left = left;
    }

    /**
     * Shows the songs to play.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(library != null)
            this.songs = new JButton[library.getSongs().size()];
        center.removeAll();
        center.setBackground(new Color(169, 169, 169));
        ArrayList<Song> songs = library.getSongs();
        JLabel songStats;
        JPanel panel = new JPanel();
        int songNum = songs.size();
        panel.setPreferredSize(new Dimension(676, 419));
        panel.setBackground(new Color(169, 169, 169));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        int x = 0, y = 0;
        for(int i = 0; i < songNum; i++, x++){
            JPanel pane = new JPanel();
            pane.setLayout(new BorderLayout());
            this.songs[i] = new CustomButton("");
            Icon buttonIcon = new ImageIcon(library.getSongs().get(i).getTitle() + ".jpg");
            Image img = ((ImageIcon) buttonIcon).getImage();
            Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            this.songs[i].setIcon(new ImageIcon(newImg));
            String labelString = library.getSongs().get(i).getArtistName() + " : " + library.getSongs().get(i).getTitle();
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
                startToPlayListener = new StartToPlayListener(new Audio(this.library.getSongs().get(i).getSongFile().getAbsolutePath()), (Down) down, library.getSongs().get(i), (Left) left, library);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (JavaLayerException e1) {
                e1.printStackTrace();
            }
            this.songs[i].addActionListener(startToPlayListener);
            if(x == 3){
                x = 0;
                y++;
            }
            gbc.gridx = x;
            gbc.gridy = y;
            pane.add(this.songs[i], BorderLayout.PAGE_START);
            pane.add(songStats, BorderLayout.CENTER);
            pane.setBackground(new Color(169, 169, 169));
            panel.add(pane, gbc);
            panel.setBackground(new Color(169, 169, 169));
        }
        center.setBackground(new Color(169, 169, 169));
        center.add(panel);
        center.revalidate();
        center.repaint();
    }
}
