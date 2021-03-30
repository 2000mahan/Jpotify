package GUI;

import GUI.Center.Center;
import GUI.Down.Down;
import GUI.Left.Left;
import GUI.Right.Right;
import GUI.Up.Up;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is the main window class.
 * @author Aryan
 * @version 1.0
 */

public class JpotifyWindow extends JFrame {
    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Constructor.
     * @param button
     * @throws IOException
     * @throws JavaLayerException
     * @throws InvalidDataException
     * @throws UnsupportedTagException
     */
    public JpotifyWindow(JButton button) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
        super();
        ImageIcon img = new ImageIcon("Header.png");
        setIconImage(img.getImage());
        Center center = new Center();
        Down down = new Down();
        Right right = new Right();
        Left left = new Left(center, down);
        Up up = new Up(center);
        up.add(button);
        setMinimumSize(new Dimension(1000,600));
        setMaximumSize(DIMENSION);
        setLocation(DIMENSION.width/2 - getSize().width/2, DIMENSION.height/2 - getSize().height/2);
        setLayout(new BorderLayout());
        this.add(down, BorderLayout.SOUTH);
        this.add(right, BorderLayout.EAST);
        this.add(left, BorderLayout.WEST);
        this.add(up, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}