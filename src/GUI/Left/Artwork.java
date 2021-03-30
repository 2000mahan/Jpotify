package GUI.Left;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class develops the artwork of the playing song.
 * @author Aryan
 * @version 1.0
 */
public class Artwork extends JPanel{
    private JLabel artwork;

    /**
     * Constructor without parameters.
     */
    public Artwork(){
        super();
        artwork = new JLabel();
        add(artwork);
        setBackground(Color.black);
    }

    public JLabel getArtworkLabel() {
        return artwork;
    }
}
