package Dao;
import java.util.List;
import java.util.Objects;

/**
 * Created by  Alexis Espinoza on 11/09/15.
 */
public interface ObjectDao {
    public List<Objects> getAllObjects();
    public Object getObject(int id);
    public boolean areWeFriendsAlready(int personID,int myFriend);
    public void addFriendRel(int personID, int myFriend,String dateOfFriendShip,String desc);
}
