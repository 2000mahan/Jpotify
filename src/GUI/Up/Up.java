package GUI.Up;


import GUI.Center.Center;
import GUI.CustomScrollBar;

import javax.swing.*;
import java.awt.*;

/**
 * This panel contains all of the up components.
 * @author Aryan
 * @version 1.0
 */
public class Up extends JPanel{
    private LeftButtons leftButtons;
    private SearchBar searchBar;
    private Users users;
    private JPanel panel;

    /**
     * The constructor gets the center panel.
     * @param center
     */
    public Up(Center center){
        leftButtons = new LeftButtons();
        searchBar = new SearchBar();
        users = new Users();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 5));
        panel.setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        add(leftButtons, FlowLayout.LEFT);
        add(searchBar);
        add(panel);
        add(CustomScrollBar.createScrollPanel(users));
        setBackground(Color.black);
    }
}
