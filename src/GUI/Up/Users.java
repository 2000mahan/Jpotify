package GUI.Up;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Users extends JPanel{
    private JComboBox users;
    private String[] user;

    public Users(){
        super();
        user = new String[10];
        user[0] = "9731012";
        user[1] = "9731013";
        users = new JComboBox(user);
        add(users);
        setBackground(Color.BLACK);
    }
}
