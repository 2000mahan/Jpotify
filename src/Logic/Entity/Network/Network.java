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
    private ArrayList<String> ipAddress;
    private PlayList sharedPlaylist;
    private User user;

    public Network(User user) throws InvalidDataException, IOException, UnsupportedTagException {
        this.user = user;
    }

    public ArrayList<String> getipAddress() {
        return ipAddress;
    }

    public void setIPAddress(ArrayList<String> ipAddress) {
        this.ipAddress = ipAddress;
    }

    public PlayList getSharedPlaylist() {
        return sharedPlaylist;
    }

    public void setSharedPlaylist(PlayList sharedPlaylist) {
        this.sharedPlaylist = sharedPlaylist;
    }
    public void addipaddress(String ipAddress){
        this.ipAddress.add(ipAddress);
    }
    public void removeipAddress(String ipAddress){

        this.ipAddress.remove(ipAddressIterator(ipAddress));

    }
    /**
     * iterates through IPAddresses to find one that user is looking for
     * @param ipAddress which is a string users option
     */
    private int ipAddressIterator(String ipAddress){
        for(String certainipAddress:this.ipAddress){
            if(certainipAddress.equals(ipAddress))
               return  this.ipAddress.indexOf(certainipAddress);
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
