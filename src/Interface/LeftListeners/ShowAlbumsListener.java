package Interface.LeftListeners;

import GUI.Center.Center;
import Logic.Entity.Library.Library;
import Logic.Entity.Song.Song;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowAlbumsListener implements ActionListener {
    private Library library;
    private Center center;

    public ShowAlbumsListener(Center center, Library library){
        this.center = center;
        this.library = library;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        center.removeAll();
        ArrayList<Song> songs = library.getSongs();
        Song[] song = new Song[library.getSongs().size()];
        for(int i = 0; i < library.getSongs().size(); i++)
            song[i] = songs.get(i);
        for(int i = 0; i < songs.size() - 1; i++)
            for(int j = i + 1; j < songs.size(); j++){
                if(song[i] != null && song[j] != null) {
                    if (song[i].getAlbumName().equals(song[j].getAlbumName()))
                        song[j] = null;
                }
            }
        JPanel pane = new JPanel();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 0.1;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        int x = 0, y = 0;
        JPanel[] panels = new JPanel[songs.size()];
        for(int i = 0; i < songs.size(); i++, x++) {
            if (song[i] != null) {
                panels[i] = new JPanel();
                panels[i].setLayout(new BorderLayout());
                panels[i].setBackground(new Color(169, 169, 169));
                JLabel icon = new JLabel("", SwingConstants.CENTER);
                Icon buttonIcon = new ImageIcon(song[i].getTitle() + ".jpg");
                Image img = ((ImageIcon) buttonIcon).getImage();
                Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                icon.setIcon(new ImageIcon(newImg));
                String albumStats = "Album : " + song[i].getAlbumName();
                JLabel albumName = new JLabel(albumStats, SwingConstants.CENTER);
                albumName.setFont(new Font("Serif", Font.ITALIC, 15));
                if(albumStats.length() > 25){
                    char[] chars = new char[25];
                    for(int j = 0; j < 22; j++)
                        chars[j] = albumStats.charAt(j);
                    chars[22] = chars[23] = chars[24] = '.';
                    albumStats = String.copyValueOf(chars);
                    albumName.setText(albumStats);
                }
                albumName.setForeground(Color.WHITE);
                panels[i].add(icon, BorderLayout.PAGE_START);
                panels[i].add(albumName, BorderLayout.CENTER);
                if (x == 3) {
                    x = 0;
                    y++;
                }
                gbc.gridx = x;
                gbc.gridy = y;
                pane.add(panels[i], gbc);
            }
        }
        center.add(pane);
        center.revalidate();
        center.repaint();
    }
}
