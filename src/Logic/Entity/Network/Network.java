package Logic.Entity.Network;

import Logic.Entity.PlayList.FixedPlayLists.SharedPlayList;
import Logic.Entity.PlayList.PlayList;
import Logic.Entity.UserInfo.User;

import java.util.ArrayList;

public class Network {
    private ArrayList<String> IPAddress = null;
    private PlayList sharedPlaylist;
    private User user;

    public Network(User user){
        this.IPAddress = new ArrayList<String>();
        this.sharedPlaylist = new SharedPlayList();
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
