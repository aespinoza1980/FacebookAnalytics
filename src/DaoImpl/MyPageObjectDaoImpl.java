package DaoImpl;


import Beans.MyPage;
import Config.MapsEnums;
import Dao.ObjectDao;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 * Created by  Alexis Espinoza on 11/09/15.
 */
public class MyPageObjectDaoImpl implements ObjectDao {
    List<MyPage> myPageList;
    public MyPageObjectDaoImpl(){
        myPageList = new ArrayList<MyPage>();
        Random generator = new Random();
        ArrayList<String> arrayListNames=new ArrayList<String>();
        ArrayList<String> arrayListLastNames=new ArrayList<String>();
        ArrayList<String> arrayListHobbies=new ArrayList<String>();
        ArrayList<String> arrayListNationalities=new ArrayList<String>();
        arrayListNames=MapsEnums.getListFromFile(MapsEnums.fileNames);
        arrayListLastNames=MapsEnums.getListFromFile(MapsEnums.fileLastNames);
        arrayListHobbies=MapsEnums.getListFromFile(MapsEnums.fileHobbies);
        arrayListNationalities=MapsEnums.getListFromFile(MapsEnums.fileNationalities);
        int limitHobby=arrayListHobbies.size();
        int limitNationalities=arrayListNationalities.size();
        int limitNames=arrayListNames.size();
        int limitLastNames=arrayListLastNames.size();

        int countryCode;
        int randomIndex;
        String name=null;

        String nationality=null;
        String Hobby;
        MyPage myPageObj;
        //UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        int j;
        for(int i=0;i<MapsEnums.limitMyPage;i++){
            j=i+1;
            //name = uid.randomUUID().toString().substring(0,19);
            name=arrayListNames.get(generator.nextInt(limitNames))+" "+arrayListLastNames.get(generator.nextInt(limitLastNames));
            countryCode=generator.nextInt(limitNationalities);
            nationality=arrayListNationalities.get(countryCode);
            randomIndex=generator.nextInt(limitHobby);
            Hobby=arrayListHobbies.get(randomIndex);
            myPageObj = new MyPage(j,name,nationality,countryCode,Hobby);
            myPageList.add(myPageObj);
        }
    }
    @Override
    public List<Objects> getAllObjects() {
        return (List<Objects>)(Object)myPageList;
    }

    @Override
    public Object getObject(int id){
        return (Object )myPageList.get(id);
    }
    @Override
    public boolean areWeFriendsAlready(int personID,int myFriend){ return true;}
    @Override
    public void addFriendRel(int personID, int myFriend,String dateOfFriendShip,String desc){}

}
