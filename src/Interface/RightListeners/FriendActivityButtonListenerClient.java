package Interface.RightListeners;

import GUI.JpotifyWindow;
import GUI.Right.FriendActivityPanelClient;
import GUI.Right.Right;
import Logic.Entity.Network.Client;
import Logic.Entity.Network.Network;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FriendActivityButtonListenerClient implements ActionListener {
    private Client client;
    private FriendActivityPanelClient friendActivityPanelClient;
    private User user;
    private JpotifyWindow window;
    public  FriendActivityButtonListenerClient(User user, JpotifyWindow window) throws InvalidDataException, UnsupportedTagException {
        this.user = user;
        try {
            this.window = window;
            this.client = new Client(user);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.client.run();

            this.friendActivityPanelClient = new FriendActivityPanelClient(this.user, this.client.getFriendUserLabel(), this.client.getFriendTitleLable(), this.client.getFriendArtistLabel());
            this.window.add(this.friendActivityPanelClient,  BorderLayout.EAST);
        } catch (InvalidDataException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (UnsupportedTagException e1) {
            e1.printStackTrace();
        }


    }

}
