package Logic.Entity.PlayList.FixedPlayLists;

import Logic.Entity.PlayList.PlayList;

import java.io.Serializable;

public class SharedPlayList extends PlayList implements Serializable {
    public SharedPlayList(){
        this("SharedPlaylist");
    }
    public SharedPlayList(String playListName) {
        super(playListName);
    }
}
