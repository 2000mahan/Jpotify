package GUI.Up;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchBar extends JPanel{
    private JTextField searchBar;

    public SearchBar(){
        searchBar = new JTextField("Search...", 10);
        searchBar.setForeground(Color.GRAY);
        searchBar.setBackground(Color.WHITE);
        searchBar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                searchBar.setText("");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchBar.setText("Search...");
            }
        });
        add(searchBar);
    }
}
