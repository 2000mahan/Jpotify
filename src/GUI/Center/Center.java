package GUI.Center;

import Logic.Entity.Album;
import Logic.Entity.Library.Library;
import Logic.Entity.PlayList.PlayList;
import Logic.Entity.Song.Song;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Center extends JPanel {
    private JButton button;
    private JLabel name;
    private JLabel artist;
    public Center(){
        setBackground(new Color(169, 169, 169));
    }
}
