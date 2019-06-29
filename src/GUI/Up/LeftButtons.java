package GUI.Up;

import GUI.CustomButton;

import javax.swing.*;
import java.awt.*;

/**
 * This is the left part of the highest part of the main window.
 * @author Aryan
 * @version 1.0
 */
public class LeftButtons extends JPanel{
    private JButton backButton;
    private JButton forwardButton;

    /**
     * Constructor.
     */
    public LeftButtons(){
        super();
        backButton = new CustomButton("\u2B05");
        forwardButton = new CustomButton("\u27A1");
        backButton.setPreferredSize(new Dimension(50, 20));
        forwardButton.setPreferredSize(new Dimension(50, 20));
        setLayout(new FlowLayout());
        add(backButton);
        add(forwardButton, FlowLayout.CENTER);
        setBackground(Color.black);
    }
}
