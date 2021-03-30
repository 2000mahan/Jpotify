package Logic.Entity.Network.SharingCenter;

import Logic.Entity.PlayList.FixedPlayLists.SharedPlayList;
import Logic.Entity.Song.Song;
import Logic.Entity.UserInfo.User;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
/**
 * a center for sharing datas between client and server
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class SharingCenterClient {
    private User user;
    private SharedPlayList mySharedPlayList;
    private Socket socket;
    private String status;
    private User friendUser;
    private SharedPlayList friendSharedPlaylist;

    public SharingCenterClient(User user, Socket clientSocket, SharedPlayList sharedPlayList) {
        this.user = user;
        this.mySharedPlayList = sharedPlayList;
        this.socket = clientSocket;
        this.status = "download";

    }

    //  public SharingCenter(User user) {
    //    this(user, null);
    //}

    public void setSharedPlayList(SharedPlayList sharedPlayList) {
        this.mySharedPlayList = sharedPlayList;
    }

    public SharedPlayList getSharedPlayList() {
        return mySharedPlayList;
    }

    /**
     * as being called it sends and recieves datas by calling some other methods
     */
    public void run() {
        int sendAndDownload = 0;
        while (sendAndDownload < 2) {
            try {

                sendAndDownload++;

                switch (this.status) {
                    case "download":
                        this.downloadFriendUser();
                        break;
                    case "send":
                        this.sendUser();
                        break;
                }
            }
            catch(IOException e){
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }


            //if(this.status.equals("download")){
            try {

                switch (this.status) {
                    case "download":
                        downloadData();

                        break;
                    case "send":
                        sendData();
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            this.status = "send";
            Scanner scan = new Scanner(System.in);

        }
    }





    /**
     * it downloads datas which is a sharedPlaylist
     */
    private void downloadData() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        SharedPlayList JohnDoesSharedPlaylist = (SharedPlayList)input.readObject();
        this.friendSharedPlaylist = JohnDoesSharedPlaylist;
        System.out.printf("%d", friendSharedPlaylist.getPlayListSongs().size());
        this.dataExtractor();

    }
    /**
     * it sends datas which is a sharedPlaylist
     */
    private void sendData() throws IOException {

        ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()));
        out.writeObject(this.mySharedPlayList);
        out.flush();
    }
    /**
     * it sends users information
     */
    private void sendUser() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()));
        out.writeObject(this.user);
        out.flush();
    }
    /**
     * it downloads friends user information
     */
    private void downloadFriendUser() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        User friendUser = (User)input.readObject();
        this.friendUser = friendUser;

    }
    /**
     * it extracts datas being downloaded which is a sharedPlaylist
     */
    private void dataExtractor() {
        for(Song song:this.friendSharedPlaylist.getPlayListSongs()){
            int myMp3FileSize = (int)song.getSongFile().length();
            byte[] buffer = new byte[myMp3FileSize];
            buffer = song.getBuffer();
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(new File(song.getTitle() + ".mp3"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                out.write(song.getBuffer());
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public User getFriendUser() {
        return friendUser;
    }

    public SharedPlayList getFriendSharedPlaylist() {
        return friendSharedPlaylist;
    }

}
