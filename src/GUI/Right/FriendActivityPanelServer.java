package GUI.Right;

import Interface.RightListeners.FriendActivityButtonListenerServer;
import Logic.Entity.Network.Network;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This panel is used for showing server panel.
 * @author Mahan
 * @version 1.0
 */
public class FriendActivityPanelServer extends JPanel {
    private JLabel [] friendActivity;
    private Network network;
    private User user;
    private JLabel friendUser;
    private JLabel friendTitleSong;
    private JLabel friendAitleSong;

    /**
     * Constructor of the class.
     * @param user
     * @param friendUser
     * @param friendTitleSong
     * @param friendAitleSong
     * @throws InvalidDataException
     * @throws IOException
     * @throws UnsupportedTagException
     */
    public FriendActivityPanelServer(User user, JLabel friendUser, JLabel friendTitleSong, JLabel friendAitleSong) throws InvalidDataException, IOException, UnsupportedTagException {
        this.user = user;
        network = new Network(this.user);
        friendActivity = new JLabel[network.getIPAddress().size()];
        this.friendUser = friendUser;
        this.friendTitleSong = friendTitleSong;
        this.friendAitleSong = friendAitleSong;
        updateAndSet();

    }

    /**
     * This method updates the panel.
     * @throws InvalidDataException
     * @throws UnsupportedTagException
     */
    public void updateAndSet() throws InvalidDataException, UnsupportedTagException {
        this.setLayout(new GridLayout(4, 0));
        this.add(this.friendUser);
        this.add(this.friendTitleSong);
        this.add(this.friendAitleSong);


    }


}
