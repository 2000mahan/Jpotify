package GUI;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;

/**
 * This class develops custom button for better UI.
 * @author Aryan
 * @version 1.0
 */
public class CustomButton extends JButton {

    private Color focusColor = Color.GRAY;

    /**
     * Gets the text of the button.
     * @param text
     */
    public CustomButton(String text) {
        super(text);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setContentAreaFilled(false); //Background changed.
        setFocusPainted(false);
        setOpaque(false);
        /*
        mouse listener for better UI.
         */
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setForeground(Color.GRAY);
            }

            @Override
            public void mouseReleased(MouseEvent e){
                setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e){
                setForeground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e){
                setForeground(Color.GRAY);
            }
        });

    }

}
