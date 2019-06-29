package GUI.Right;

import GUI.Center.Center;
import GUI.CustomScrollBar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class Right extends JPanel{
    private JLabel title;
    private JList friendActivity;

    public Right(){
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Friend Activity");
        Dimension dimension = this.getSize();
        label.setFont(new Font("Serif", Font.PLAIN, 25));
        label.setForeground(Color.WHITE);
        this.add(label, BorderLayout.PAGE_START);
        this.setBackground(Color.BLACK);
        JTextArea area = new JTextArea();
        area.setBackground(Color.black);
        this.add(new CustomScrollBar().createScrollPanel(area));

    }

}
