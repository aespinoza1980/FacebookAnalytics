package Beans;

/**
 * Created by  Alexis Espinoza on 11/09/15.
 */
public class Friends {
    private int friendRel;
    private int personId;
    private int myFriend;
    private String dateOfFriendShip;
    private String desc;
    public Friends(int friendRel,int personId,int myFriend, String dateOfFriendShip,String desc){
        this.friendRel = friendRel;
        this.personId = personId;
        this.myFriend = myFriend;
        this.dateOfFriendShip = dateOfFriendShip;
        this.desc = desc;
    }
    public int getFriendRel() {
        return friendRel;
    }
    public void setFriendRel(int friendRel) {
        this.friendRel = friendRel;
    }
    public int getPersonId() {
        return personId;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getMyFriend() {
        return myFriend;
    }
    public void setMyFriend(int myFriend) {
        this.myFriend = myFriend;
    }
    public String getDateOfFriendShip() {
        return dateOfFriendShip;
    }
    public void setDateOfFriendShip(String dateOfFriendShip) {
        this.dateOfFriendShip = dateOfFriendShip;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
