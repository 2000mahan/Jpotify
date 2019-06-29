package GUI.Left;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Artwork extends JPanel{
    private JLabel artwork;

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
