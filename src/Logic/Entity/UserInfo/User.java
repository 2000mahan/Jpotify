package Logic.Entity.UserInfo;

import java.io.Serializable;
/**
 * User class simply keeps datas a user
 * @author Mahan
 * @version 7.0
 * @since 06/15/2019
 */
public class User implements Serializable {

    private String userName;

    public User(String userName){
      this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
