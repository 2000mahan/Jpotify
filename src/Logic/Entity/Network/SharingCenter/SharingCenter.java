package Logic.Entity.Network.SharingCenter;

import Logic.Entity.PlayList.FixedPlayLists.SharedPlayList;
import Logic.Entity.Song.Song;
import Logic.Entity.UserInfo.User;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class SharingCenter extends Thread {
  private User user;
  private SharedPlayList mySharedPlayList;
  private static Socket socket;
  private String status;
  private HashMap<String, SharedPlayList> otherUsersSharedPlaylist;

  public SharingCenter(User user, Socket client) {
    this.user = user;
    this.mySharedPlayList = new SharedPlayList();
    this.socket = client;
    this.status  = null;
    this.otherUsersSharedPlaylist = new HashMap<>();
    }

    public SharingCenter(User user) {
        this(user, null);
    }

    public void setSharedPlayList(SharedPlayList sharedPlayList) {
        this.mySharedPlayList = sharedPlayList;
    }

    public SharedPlayList getSharedPlayList() {
        return mySharedPlayList;
    }

    @Override
    public void run(){

     switch (this.status){
         case "download":
             try {
                 downloadData();
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }
         case "send":
             try {
                 sendData();
             } catch (IOException e) {
                 e.printStackTrace();
             }

     }
    }

    private void downloadData() throws IOException, ClassNotFoundException {
    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
     User user = (User)input.readObject();
     SharedPlayList JohnDoesSharedPlaylist = (SharedPlayList)input.readObject();
       otherUsersSharedPlaylist.put(user.getUserName(), JohnDoesSharedPlaylist);
    }

    private void sendData() throws IOException {

      ObjectOutputStream out = new ObjectOutputStream((socket.getOutputStream()));
        out.writeObject(this.user);
        out.flush();
        out.writeObject(this.mySharedPlayList);
    }

    public void dataExtractor(User user) {
     for(Song song:otherUsersSharedPlaylist.get(user).getPlayListSongs()){
         int myMp3FileSize = (int)song.getSongFile().length();
         byte[] buffer = new byte[myMp3FileSize];
         buffer = song.getBuffer();
         FileOutputStream out = null;
         try {
             out = new FileOutputStream(new File("E:\\mySong.mp3"));
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
}
