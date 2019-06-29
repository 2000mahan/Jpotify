package GUI.Down;

import GUI.Center.Center;

import javax.swing.*;
import java.awt.*;

public class Down extends JPanel {
    private LeftPart leftPart;
    private PlayBar playBar;
    private PlayButtons playButtons;
    private RightButtons rightButtons;
    private JPanel center;

    public Down(){
        super();
        setLayout(new BorderLayout());
        add(leftPart = new LeftPart(), BorderLayout.WEST);
        add(playBar = new PlayBar(), BorderLayout.SOUTH);
        add(playButtons = new PlayButtons(), BorderLayout.NORTH);
        add(rightButtons = new RightButtons(), BorderLayout.EAST);
        add(this.center = new JPanel(), BorderLayout.CENTER);
        this.center.setBackground(new Color(66, 66, 66));
    }

    public LeftPart getLeftPart() {
        return leftPart;
    }

    public PlayBar getPlayBar() {
        return playBar;
    }

    public PlayButtons getPlayButtons() {
        return playButtons;
    }

    public RightButtons getRightButtons() {
        return rightButtons;
    }
}
