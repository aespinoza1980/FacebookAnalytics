package DaoImpl;

import Beans.Friends;
import Dao.ObjectDao;

import java.util.*;
import java.util.List;

/**
 * Created by  Alexis Espinoza on 11/09/15.
 */
public class FriendsObjectDaoImpl implements ObjectDao {
    private List<Friends> FriendsList;
    private HashMap<Integer, ArrayList<Integer>> areWeFriendsAlready;
    private Friends FriendsObj;
    private ArrayList<Integer> myFriends;

    public FriendsObjectDaoImpl(){
        FriendsList=new ArrayList<Friends>();
        areWeFriendsAlready = new HashMap<Integer, ArrayList<Integer>>();
        myFriends = new ArrayList<Integer>();
    }
    @Override
    public List<Objects> getAllObjects(){
        return (List<Objects>)(Object)FriendsList;
    }
    @Override
    public Object getObject(int friendRel){
        return (Object )FriendsList.get(friendRel);
    }
    @Override
    public boolean areWeFriendsAlready(int personID,int myFriend){
        boolean flag=false;
        if((!areWeFriendsAlready.isEmpty())&&(areWeFriendsAlready.containsKey(personID))&&(areWeFriendsAlready.containsKey(myFriend))
                && (areWeFriendsAlready.get(personID).toString().contains(Integer.toString(myFriend)))) {
            System.out.println("These two guys are friends already "+personID+" and "+myFriend);
            flag = true;
        }
        return flag;
    }
    @Override
    public void addFriendRel(int personID, int myFriend,String dateOfFriendShip,String desc){
        int nextIndex=FriendsList.size()+1;
        FriendsObj=new Friends(nextIndex,personID,myFriend,dateOfFriendShip,desc);
        FriendsList.add(FriendsObj);
        if(!areWeFriendsAlready.isEmpty()) {
            if (areWeFriendsAlready.containsKey(personID)) {
                areWeFriendsAlready.get(personID).add(myFriend);// the two become friends
                if(areWeFriendsAlready.containsKey(myFriend)) {
                    areWeFriendsAlready.get(myFriend).add(personID);
                }
                else{
                    areWeFriendsAlready.put(myFriend, new ArrayList<Integer>());
                    areWeFriendsAlready.get(myFriend).add(personID);
                }
            } else {
                areWeFriendsAlready.put(personID, new ArrayList<Integer>());//Create hashmap with friendship for faster lookup
                areWeFriendsAlready.get(personID).add(myFriend);//Create hashmap with friendship for faster lookup

                areWeFriendsAlready.put(myFriend, new ArrayList<Integer>());
                areWeFriendsAlready.get(myFriend).add(personID);

            }
        }else{

            areWeFriendsAlready.put(personID, new ArrayList<Integer>());//Create hashmap with friendship for faster lookup
            areWeFriendsAlready.get(personID).add(myFriend);//Create hashmap with friendship for faster lookup

            areWeFriendsAlready.put(myFriend, new ArrayList<Integer>());
            areWeFriendsAlready.get(myFriend).add(personID);

        }

    }



}
