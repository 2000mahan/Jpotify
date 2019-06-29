package Logic.Entity.Network;

import Logic.Entity.Network.SharingCenter.SharingCenterServer;
import Logic.Entity.Network.SharingCenter.SharingCenterServer;
import Logic.Entity.PlayList.FixedPlayLists.SharedPlayList;
import Logic.Entity.Song.Song;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Network{

    private boolean isRun;
    private SharingCenterServer sharingCenterServer;
    private ServerSocket serverSocket;
    private JLabel friendUserLabel;
    private JLabel friendTitleLable;
    private JLabel friendArtistLable;
    private JLabel friendSongStatus;

    public Server(User user) throws IOException, InvalidDataException, UnsupportedTagException {
        super(user);
        serverSocket = new ServerSocket(8080);
            this.isRun = true;


    }


    public void run() {
        while (isRun){

            try {

                Socket client = this.serverSocket.accept();

                 this.sharingCenterServer = new SharingCenterServer(super.getUser() ,client, (SharedPlayList) getSharedPlaylist());
                this.sharingCenterServer.run();
                this.labelSetter();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public SharingCenterServer getSharingCenter() {
        return sharingCenterServer;
    }

    public JLabel getFriendArtistLable() {
        return friendArtistLable;
    }

    public JLabel getFriendSongStatus() {
        return friendSongStatus;
    }

    public JLabel getFriendUserLabel() {
        return friendUserLabel;
    }

    public JLabel getFriendTitleLable() {
        return friendTitleLable;
    }

    public void setFriendUserLabel(JLabel friendUserLabel) {
        this.friendUserLabel = friendUserLabel;
    }

    public void setFriendArtistLable(JLabel friendArtistLable) {
        this.friendArtistLable = friendArtistLable;
    }

    public void setFriendSongStatus(JLabel friendSongStatus) {
        this.friendSongStatus = friendSongStatus;
    }

    public void setFriendTitleLable(JLabel friendTitleLable) {
        this.friendTitleLable = friendTitleLable;
    }

    private void labelSetter(){
        for(Song song: this.getSharingCenter().getFriendSharedPlaylist().getPlayListSongs()){
            if(song.isPlayingStatus()){
                friendTitleLable = new JLabel(song.getTitle());
                friendArtistLable = new JLabel(song.getArtistName());

            }

        }
        friendUserLabel = new JLabel(this.getSharingCenter().getFriendUser().getUserName());

    }
}
