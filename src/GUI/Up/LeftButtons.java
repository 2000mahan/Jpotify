package GUI.Up;

import GUI.CustomButton;

import javax.swing.*;
import java.awt.*;

public class LeftButtons extends JPanel{
    private JButton backButton;
    private JButton forwardButton;

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
