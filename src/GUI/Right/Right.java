package GUI.Right;

import GUI.CustomButton;
import GUI.CustomScrollBar;
import Interface.RightListeners.FriendActivityButtonListenerClient;
import Interface.RightListeners.FriendActivityButtonListenerServer;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;


public class Right extends JPanel{
    private JLabel title;
    private JList friendActivity;
    private User user;
    private String status;

    public Right() throws InvalidDataException, IOException, UnsupportedTagException {
        super();
        this.user = new User("mahan");
        this.setLayout(new BorderLayout());
        JButton button = new CustomButton("Friend Activity");
        button.setFont(new Font("Serif", Font.PLAIN, 25));
        this.add(button, BorderLayout.PAGE_START);
        this.setBackground(Color.black);
        JTextArea area = new JTextArea();
        area.setBackground(Color.black);
        area.setRows(5);
        this.add(new CustomScrollBar().createScrollPanel(area));


    }

}
