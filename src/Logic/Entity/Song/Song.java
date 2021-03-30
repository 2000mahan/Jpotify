package Logic.Entity.Song;

import java.io.*;
/**
 * Song class simply keeps datas of a mp3 file
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class Song implements Serializable{
    private String title;
    private String artistName;
    private String albumName;
    private File songFile;
    private byte[] buffer; //buffer keeps our vital data which is the mp3 bytes itself.
    private boolean playingStatus;
    private boolean inSharedPlaylist;

    public Song(String title, String artistName, String albumName, File songFile){

    this.title = title;
    this.artistName = artistName;
    this.albumName = albumName;
    this.songFile = songFile;
    this.buffer = new byte[(int) this.songFile.length()];
        try {
            this.setBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setSongFile(File songFile) {
        this.songFile = songFile;
    }

    public File getSongFile() {
        return songFile;
    }

    public void setBuffer() throws IOException {
        FileInputStream fis = new FileInputStream(songFile.getAbsolutePath());
        BufferedInputStream bif = new BufferedInputStream(fis);
        int byteAmount = 0;
        while ((byteAmount = bif.read(buffer)) != -1){}
    }

    public byte[] getBuffer() {
        return buffer;
    }

    @Override
    public String toString(){
        return title + " " + artistName + " " + albumName;
    }

    public boolean isPlayingStatus() {
        return playingStatus;
    }


    public void setPlayingStatus(boolean playingStatus) {
        this.playingStatus = playingStatus;
    }
}
