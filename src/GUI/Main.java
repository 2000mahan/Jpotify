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


public class Main{
    public static void main(String[] args) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
        User user = new User("mahan");
        JButton button = new JButton();
        Scanner scan = new Scanner(System.in);
        String status = scan.nextLine();
        JpotifyWindow window = new JpotifyWindow(button);
        if(status.equals("server")) {
            FriendActivityButtonListenerServer friendActivityButtonListener;
            friendActivityButtonListener = new FriendActivityButtonListenerServer(user, window);
            button.addActionListener(friendActivityButtonListener);
        }
        else {
            FriendActivityButtonListenerClient friendActivityButtonListener;
            friendActivityButtonListener = new FriendActivityButtonListenerClient(user, window);
            button.addActionListener(friendActivityButtonListener);
        }
    }
}
