package Logic.Entity.UserInfo;

import Logic.Entity.PlayList.PlayList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * User class simply keeps datas a user
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class User implements Serializable {

    private String userName;
    private ArrayList<PlayList> playLists;

    public User(String userName){
      this.userName = userName;
      playLists = new ArrayList<>();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
