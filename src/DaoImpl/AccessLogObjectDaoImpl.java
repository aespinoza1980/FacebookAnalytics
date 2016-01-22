package DaoImpl;

import Dao.*;
import Beans.AccessLog;
import Config.MapsEnums;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by  Alexis Espinoza on 11/09/15.
 */
public class AccessLogObjectDaoImpl implements ObjectDao {
    List<AccessLog> accessLogList;
    public AccessLogObjectDaoImpl(ObjectDao myPageDao, ObjectDao friendsDao){
        //Users must have been created first
        accessLogList=new ArrayList<AccessLog>();
        int limitUsers= myPageDao.getAllObjects().size();//myPageDao.getAllMyPage().size();
        ArrayList<String> typeOfFriends= MapsEnums.getListFromFile(MapsEnums.fileTypeFriends);
        int limitTypeOfFriends=typeOfFriends.size();
        int byWho;
        int whatPage;
        int chooseTypeOfAccess;
        int hour;
        int min;
        int sec;
        int month;
        int day;
        int year;
        String typeOfAccess=null;
        String accessTime=null;
        String hourString=null;
        String minString=null;
        String secString=null;
        String yearString=null;
        String monthString=null;
        String dayString=null;
        String dateOfFriendShip=null;
        AccessLog accessLogObj;
        Random generator = new Random();
        int j;
        for(int i=0;i<MapsEnums.limitAccesLog;i++){
            j=i+1;
            byWho=generator.nextInt(limitUsers);
            whatPage=generator.nextInt(limitUsers);
            hour=generator.nextInt(23) + 1;
            if(hour<10)
                hourString="0"+Integer.toString(hour);
            else
                hourString=Integer.toString(hour);
            min=generator.nextInt(59) + 1;
            if(min<10)
                minString="0"+Integer.toString(min);
            else
                minString=Integer.toString(min);

            sec =generator.nextInt(59) + 1;
            if(sec<10)
                secString="0"+Integer.toString(sec);
            else
                secString=Integer.toString(sec);

            month =generator.nextInt(12) + 1;
            if(month<10)
                monthString="0"+Integer.toString(month);
            else
                monthString=Integer.toString(month);
            if(month==2) {
                day = generator.nextInt(28) + 1;
            }else {
                if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))
                    day = generator.nextInt(31) + 1;
                else
                    day = generator.nextInt(30) + 1;
            }
            if(day<10)
                dayString="0"+Integer.toString(day);
            else
                dayString=Integer.toString(day);
            year =generator.nextInt(5) + 1;
            year=year+2010;
            yearString=Integer.toString(year);
            accessTime=yearString+"-"+monthString+"-"+dayString+" "+hourString+":"+minString+":"+secString;
            dateOfFriendShip=yearString+"-"+monthString+"-"+dayString;
            if(byWho==whatPage){ //just watching my page
                typeOfAccess= MapsEnums.TYPEOFACCESS.justViewed.name();
            }else {

                if(friendsDao.areWeFriendsAlready(whatPage,byWho))//you cannot add me as friend if we are friends already
                    chooseTypeOfAccess=generator.nextInt(2) + 1;
                else
                    chooseTypeOfAccess=generator.nextInt(3) + 1;
                switch(chooseTypeOfAccess){
                    case 1:typeOfAccess= MapsEnums.TYPEOFACCESS.justViewed.name();
                           System.out.println("USER "+byWho+" has just viewed USER "+whatPage+" Profile Page");
                           break;
                    case 2:typeOfAccess= MapsEnums.TYPEOFACCESS.leftANote.name();
                           System.out.println("USER "+byWho+" has just left a Note in USER "+whatPage+" Profile Page");
                           break;
                    case 3://need to validate beforehand if the friendship was added
                           typeOfAccess= MapsEnums.TYPEOFACCESS.AddedAFriendShip.name();
                           System.out.println("USER "+byWho+" Has just added USER "+whatPage+" as friend");
                           chooseTypeOfAccess=generator.nextInt(limitTypeOfFriends);
                           friendsDao.addFriendRel(whatPage,byWho,dateOfFriendShip,typeOfFriends.get(chooseTypeOfAccess).toString());
                           break;

                }
            }

            accessLogObj=new AccessLog(j,byWho,whatPage,typeOfAccess,accessTime);
            accessLogList.add(accessLogObj);
        }
    }
    @Override
    public List<Objects> getAllObjects() {
        return (List<Objects>)(Object)accessLogList;
    }
    @Override
    public Object getObject(int accessId){
        return (Object )accessLogList.get(accessId);
    }
    @Override
    public boolean areWeFriendsAlready(int personID,int myFriend){ return true;}
    @Override
    public void addFriendRel(int personID, int myFriend,String dateOfFriendShip,String desc){}

}
