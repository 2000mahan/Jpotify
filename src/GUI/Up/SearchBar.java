package GUI.Up;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is the search bar panel.
 * @author Aryan
 * @version 1.0
 */

public class SearchBar extends JPanel{
    private JTextField searchBar;

    /**
     * Constructor.
     */
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
