package Logic.Entity.PlayList.FixedPlayLists;

import Logic.Entity.PlayList.PlayList;

public class SharedPlayList extends PlayList {
    public SharedPlayList(){
        this("SharedPlaylist");
    }
    public SharedPlayList(String playListName) {
        super(playListName);
    }
}
