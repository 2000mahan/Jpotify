package GUI.Right;

import Interface.RightListeners.FriendActivityButtonListenerServer;
import Logic.Entity.Network.Network;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FriendActivityPanelServer extends JPanel {
    private JLabel [] friendActivity;
    private Network network;
    private User user;
    private JLabel friendUser;
    private JLabel friendTitleSong;
    private JLabel friendAitleSong;
    public FriendActivityPanelServer(User user, JLabel friendUser, JLabel friendTitleSong, JLabel friendAitleSong) throws InvalidDataException, IOException, UnsupportedTagException {
        this.user = user;
        network = new Network(this.user);
        friendActivity = new JLabel[network.getIPAddress().size()];
        this.friendUser = friendUser;
        this.friendTitleSong = friendTitleSong;
        this.friendAitleSong = friendAitleSong;
        updateAndSet();

    }
    public void updateAndSet() throws InvalidDataException, UnsupportedTagException {
        this.setLayout(new GridLayout(4, 0));
        this.add(this.friendUser);
        this.add(this.friendTitleSong);
        this.add(this.friendAitleSong);


    }


}
