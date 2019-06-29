package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Custom progress bar for batter UI.
 * @author Aryan
 * @version 1.0
 */
public class CustomProgressBar extends JProgressBar {

    /**
     * Constructor.
     * @param dimension
     */
    public CustomProgressBar(Dimension dimension){
        super();
        setPreferredSize(dimension);
        setMaximum(dimension.width);
        setValue(0);
        /*
        mouse listener for better UI.
         */
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setValue(e.getX());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setValue(e.getX());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
