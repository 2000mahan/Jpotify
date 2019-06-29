package Logic.Entity.Network;

import Logic.Entity.Library.Library;
import Logic.Entity.PlayList.FixedPlayLists.SharedPlayList;
import Logic.Entity.PlayList.PlayList;
import Logic.Entity.Song.Song;
import Logic.Entity.UserInfo.User;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Network class simply keeps IPAddress and sharedPlaylist
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class Network {
    private ArrayList<String> IPAddress;
    private PlayList sharedPlaylist;
    private User user;

    public Network(User user) throws InvalidDataException, IOException, UnsupportedTagException {
        this.user = user;
    }

    public ArrayList<String> getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(ArrayList<String> IPAddress) {
        this.IPAddress = IPAddress;
    }

    public PlayList getSharedPlaylist() {
        return sharedPlaylist;
    }

    public void setSharedPlaylist(PlayList sharedPlaylist) {
        this.sharedPlaylist = sharedPlaylist;
    }
    public void addIPaddress(String IPAddress){
        this.IPAddress.add(IPAddress);
    }
    public void removeIPAddress(String IPAddress){

        this.IPAddress.remove(IPAddressIterator(IPAddress));

    }
    /**
     * iterates through IPAddresses to find one that user is looking for
     * @param IPAddress which is a string users option
     */
    private int IPAddressIterator(String IPAddress){
        for(String certainIPAddress:this.IPAddress){
            if(certainIPAddress.equals(IPAddress))
               return  this.IPAddress.indexOf(certainIPAddress);
        }
        return 0;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
