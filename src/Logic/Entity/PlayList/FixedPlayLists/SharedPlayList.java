package Logic.Entity.PlayList.FixedPlayLists;

import Logic.Entity.PlayList.PlayList;

import java.io.Serializable;
/**
 * SharedPlayList class simply keeps users favorite songs and is fixed also
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class SharedPlayList extends PlayList implements Serializable {
    public SharedPlayList(){
        this("SharedPlaylist");
    }
    public SharedPlayList(String playListName) {
        super(playListName);
    }
}
