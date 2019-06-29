package Interface.RightListeners;
import GUI.JpotifyWindow;
import GUI.Right.FriendActivityPanelServer;
import GUI.Right.Right;
import Logic.Entity.Network.Network;
import Logic.Entity.Network.Server;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FriendActivityButtonListenerServer implements ActionListener {
    private Server server;
    private FriendActivityPanelServer friendActivityPanelServer;
    private User user;
    private JpotifyWindow window;
    public FriendActivityButtonListenerServer(User user, JpotifyWindow window ) throws InvalidDataException, UnsupportedTagException {
        this.user = user;
        try {
            this.window = window;
            this.server = new Server(user);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.server.run();
            this.friendActivityPanelServer = new FriendActivityPanelServer(this.user, this.server.getFriendUserLabel(), this.server.getFriendTitleLable(), this.server.getFriendArtistLable());
            this.window.add(this.friendActivityPanelServer, BorderLayout.EAST);
        } catch (InvalidDataException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (UnsupportedTagException e1) {
            e1.printStackTrace();
        }


    }

}