package GUI.Right;

import Interface.RightListeners.FriendActivityButtonListenerClient;
import Logic.Entity.Network.Network;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FriendActivityPanelClient extends JPanel {
    private JLabel [] friendActivity;
    private Network network;
    private User user;
    private JLabel friendUser;
    private JLabel friendTitleSong;
    private JLabel friendAitleSong;
    public FriendActivityPanelClient(User user, JLabel friendUser, JLabel friendTitleSong, JLabel friendAitleSong) throws InvalidDataException, IOException, UnsupportedTagException {
        this.user = user;
        network = new Network(this.user);
        friendActivity = new JLabel[network.getIPAddress().size()];
        this.friendUser = friendUser;
        this.friendUser.setBackground(Color.blue);
        this.friendTitleSong = friendTitleSong;
        this.friendTitleSong.setBackground(Color.red);
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
