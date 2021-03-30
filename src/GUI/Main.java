package GUI;

import Interface.RightListeners.FriendActivityButtonListenerClient;
import Interface.RightListeners.FriendActivityButtonListenerServer;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main class for running the program.
 * @author Aryan
 * @version 1.0
 */
public class Main{
    public static void main(String[] args) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
        User user = new User("Mahan");
        JButton button = new CustomButton("Connect...");
        button.setFont(new Font("Serif", Font.PLAIN, 15));
        Scanner scan = new Scanner(System.in);
        String status = scan.nextLine();
        JpotifyWindow window = new JpotifyWindow(button);
        if(status.equals("server")) {
            FriendActivityButtonListenerServer friendActivityButtonListener;
            friendActivityButtonListener = new FriendActivityButtonListenerServer(user, window);
            button.addActionListener(friendActivityButtonListener);
        }
        else if(status.equals("client")){
            FriendActivityButtonListenerClient friendActivityButtonListener;
            friendActivityButtonListener = new FriendActivityButtonListenerClient(user, window);
            button.addActionListener(friendActivityButtonListener);
        }
    }
}
