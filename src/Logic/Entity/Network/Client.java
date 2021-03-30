package Logic.Entity.Network;

import Logic.Entity.Network.SharingCenter.SharingCenterClient;
import Logic.Entity.Network.SharingCenter.SharingCenterClient;
import Logic.Entity.PlayList.FixedPlayLists.SharedPlayList;
import Logic.Entity.Song.Song;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Client class simply connects to server
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class Client extends Network{
    private boolean isRun;
    private JLabel friendUserLabel;
    private JLabel friendTitleLabel;
    private JLabel friendArtistLabel;
    private JLabel friendSongStatus;
    private SharingCenterClient sharingCenterClient;
    public Client(User user) throws IOException, InvalidDataException, UnsupportedTagException {
        super(user);
        this.isRun = true;


    }

    /**
     * it takes measures to connect
     */
    public void run() {

        int port = 8080;

        try {
            this.sharingCenterClient = new SharingCenterClient(super.getUser(), new Socket("192.168.1.101", port), (SharedPlayList) getSharedPlaylist());
            this.sharingCenterClient.run();
            this.labelSetter();

        } catch (IOException e) {
            e.printStackTrace();
        }





        }


    public SharingCenterClient getSharingCenter() {
        return sharingCenterClient;
    }

    public JLabel getFriendArtistLabel() {
        return friendArtistLabel;
    }

    public JLabel getFriendSongStatus() {
        return friendSongStatus;
    }

    public JLabel getFriendUserLabel() {
        return friendUserLabel;
    }

    public JLabel getFriendTitleLable() {
        return friendTitleLabel;
    }

    public void setFriendUserLabel(JLabel friendUserLabel) {
        this.friendUserLabel = friendUserLabel;
    }

    public void setFriendArtistLabel(JLabel friendArtistLabel) {
        this.friendArtistLabel = friendArtistLabel;
    }

    public void setFriendSongStatus(JLabel friendSongStatus) {
        this.friendSongStatus = friendSongStatus;
    }

    public void setFriendTitleLabel(JLabel friendTitleLabel) {
        this.friendTitleLabel = friendTitleLabel;
    }
    /**
     * it sets labels from a friends sharedPlaylist song which is being played and it sets friendUsers label also.
     */
    private void labelSetter(){
        for(Song song: this.getSharingCenter().getFriendSharedPlaylist().getPlayListSongs()){
            if(song.isPlayingStatus()){
                friendTitleLabel = new JLabel(song.getTitle());
                friendArtistLabel = new JLabel(song.getArtistName());

            }

        }
        friendUserLabel = new JLabel(this.getSharingCenter().getFriendUser().getUserName());

    }
}