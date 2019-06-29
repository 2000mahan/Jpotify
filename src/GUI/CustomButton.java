package GUI;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;


public class CustomButton extends JButton {

    private Color focusColor = Color.GRAY;

    public CustomButton(String text) {
        super(text);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
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
